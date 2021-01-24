package com.example.framewrok.base.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.LruCache;
import android.widget.ImageView;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.annotations.NonNull;
import okhttp3.ResponseBody;
import okhttp3.internal.cache.DiskLruCache;
import retrofit2.Call;
import retrofit2.Response;

//使用单例，来做内存缓存，并且对外部使用者来说,提供统一的接口
public class NewsGlide {

    private LruCache<String,Bitmap> memoryCache;//图片的内存缓存，数据结构使用LruCache.该数据结构可以避免无限制的占用应用内存。在实例化该数据结构时，可以给该数据结构设置一个使用内存的最大值
                                                //当该数据结构使用的内存值大于该最大值时，该数据结构自动将最老的一些图片的Bitmap删除,腾出空间来存储新的图片的Bitmap
    private DiskLruCache diskCache;//本地缓存，它可以用来缓存图片文件，它的特性也是有一最大值，当超过了这个这个最大值时，会删除旧的图片文件，腾出空间，来存放新的图片文件

    private File cacheFileDir;
    private static volatile NewsGlide instance; //声明成静态变量，可以确保单例的实例，生命周期和应用程序的一致

    private ExecutorService glideService = Executors.newCachedThreadPool();//该种类型的线程池，比较适合小而多的任务

    private boolean isInitated = false;

    private NewsGlide() {
    }

    //初始化缓存的数据结构，例如lrucache
    public void init(Context context) {
        //初始化内存缓存,给这个数据结构分配的最大内存空间是应用程序所能使用最大内存的四分之一，例如应用程序最大内存时200M，那么该数据结构可以使用的内存值是50M
        memoryCache = new LruCache<>((int)Runtime.getRuntime().maxMemory()/4);
        //初始化本地缓存
        //创建一个目录存放本地的图片,getExternalCacheDir该路径(/sdcard/Android/data/包名/cache/news)可以在应用程序卸载时，该目录下的文件同时被删除,不会产生垃圾文件
        cacheFileDir = new File(context.getExternalCacheDir().getAbsolutePath()+"/news/");
        if (!cacheFileDir.exists()) {//如果目录不存在，则创建该目录
            cacheFileDir.mkdir();
        }
        try {
            //设置磁盘的最大值是一个G
            diskCache = DiskLruCache.open(cacheFileDir,1,1,1024*1024*1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        isInitated = true;

    }

    //是不是已经初始化
    public boolean isInitated() {
        return isInitated;
    }

    public static NewsGlide getInstance() {
        if (instance == null) {//该检查是提升应用的执行效率，避免每次获取该实例时，都需要拿到锁
            synchronized (NewsGlide.class) {
                if (instance == null) {//这个检查可以避免重复创建该单例
                    instance = new NewsGlide();
                }
            }
        }
        return instance;
    }

    //定义一个Handler，通过该Handler切换到主线程，在主线程里通回调接口返回Bitmap，这样的话，使用该库的开发人员获取Bitmap后不用在手动切到主线程渲染控件，方便开发
    private Handler mainHandler = new Handler();


    //操作内存缓存的方法
    //1，从内存中读取图片的Bitmap
    public Bitmap getBitmapFromMem(@NonNull String key) {
        synchronized (memoryCache) {//使用锁来同步资源，防止多线程同时操作数据时，对数据的破坏。并且使用的memcache到的的资源锁
            return memoryCache.get(key);
        }
    }
    //2，将图片的Bitmap存到内存中
    public void setBitmapToMem(@NonNull String key, @NonNull Bitmap bitmap) {
        synchronized (memoryCache) {
            memoryCache.put(key, bitmap);
        }
    }

    //本地中查找，异步方法
    public void getBitmapFromDisk(final String key, @NonNull final IGetBitmapListener listener) {
        glideService.execute(new Runnable() {
            Bitmap bitmap = null;
            @Override
            public void run() {
                synchronized (diskCache) {
                    try {
                        DiskLruCache.Snapshot snapshot = diskCache.get(key);
                        if (snapshot==null) {//本地磁盘中也没有该图片
                            mainHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    listener.onBitmap(null);
                                }
                            });
                            return;
                        }
                        InputStream inputStream = snapshot.getInputStream(0);
                        bitmap = BitmapFactory.decodeStream(inputStream);
                        setBitmapToMem(key,bitmap);//将从本地获取的bitmap存入内存缓存中
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onBitmap(bitmap);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    //将图片文件存到DiskLruCache中
    public void setBitmapToDisk(@NonNull final String key, @NonNull final Bitmap bitmap) {
        glideService.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (diskCache) {
                    try {
                        DiskLruCache.Editor editor = diskCache.edit(key);
                        OutputStream outputStream = editor.newOutputStream(0);
                        bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                        editor.commit();
                        diskCache.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    //定义异步方法返回的回调接口,当通过异步方法拿到Bitmap时，通过该接口返回bitmap
    public interface IGetBitmapListener {
        void onBitmap(Bitmap bitmap);
    }


    //从服务端获取Bitmap
    public void getBitmapFromServer(@NonNull final String url, final ImageView imageView, final IGetBitmapListener listener) {
        glideService.execute(new Runnable() {
            @Override
            public void run() {
                Call<ResponseBody> call = RetrofitCreator.getNetworkApiService().downloadFile(url);
                //第二种调用方法
                try {
                    Response<ResponseBody> response = call.execute();
                    //获取服务端图片的输入流
                    if (response.body()==null) {
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onBitmap(null);//通过主线程将bitmap返回调用者
                            }
                        });
                        return;
                    }
                    InputStream inputStream = response.body().byteStream();//输入流
                    if (inputStream==null) {
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onBitmap(null);//通过主线程将bitmap返回调用者
                            }
                        });
                        return;

                    }
                    //通过图片的输入流，生成对应bitmap
                    Bitmap originalBitmap = BitmapFactory.decodeStream(inputStream);
                    if (originalBitmap==null) {
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onBitmap(null);//通过主线程将bitmap返回调用者
                            }
                        });
                        return;
                    }
                    //做二次采样,使用原图的Bitmap生成和控件对应的二次采样后的bitmap，这样可以节约内存
                    final Bitmap sampleBitmap = sampleBitmap(imageView.getWidth(),imageView.getHeight(),originalBitmap);
                    originalBitmap.recycle();
                    originalBitmap = null;
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onBitmap(sampleBitmap);//通过主线程将bitmap返回调用者
                        }
                    });
                    //将sampleBitmap存到本地
                    String key = generateCacheKey(url);
                    setBitmapToDisk(key,sampleBitmap);
                    //将sampleBitmap存到内存中
                    setBitmapToMem(key,sampleBitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //定义二次采样的函数,这个函数根据控件的大小，生成二次采样后的bitmap

    /**
     *
     * @param width 控件的宽度
     * @param height 控件的高度
     * @param originalBitmap 原图的bitmap
     * @return 返回的是采样后bitmap
     */
    private Bitmap sampleBitmap(int width, int height, Bitmap originalBitmap) {
        int picWidth = originalBitmap.getWidth();
        int picHeight = originalBitmap.getHeight();
        //定义采样的因子变量
        int sample = 1;
        while (picHeight/sample > height && picWidth / sample > width) {
            sample = sample+1;
        }

        //进行二次采样
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = sample;
        options.inPreferredConfig = Bitmap.Config.RGB_565;//使用两个字节表示一个像素  如果是8888四个字节表示一个像素

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        originalBitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);//将原图的bitmap放到数组中
        byte[] bytes = baos.toByteArray();
        //生成二次采样后的Bitmap
        Bitmap sampleBitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length,options);
        return sampleBitmap;
    }

    //通过图片的地址生成一个32位的Hash key作为内存缓存和本地缓存的key，这个是唯一的，地址不同，生成的key肯定不同，并且Hash key里面没有乱码
    public String generateCacheKey(String url) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(
                    url.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }


    public static NewsRequest with(Context context) {
        NewsRequest newsRequest = new NewsRequest(context);
        return newsRequest;
    }






}
