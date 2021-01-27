package com.example.framewrok.base.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.LruCache;
import android.widget.ImageView;


import com.bawei.deom.RetorfitConfig;
import com.example.net.bean.ImagesBean;
import com.jakewharton.disklrucache.DiskLruCache;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

//单例做内存缓存  对外部提供统一接口
public class NewsGlide {
    private LruCache<String,Bitmap> memoryCache;//内存
    private DiskLruCache diskLruCache;//本地缓存   特点  当图片过大时  会自动删除旧的图片  释放空间给新的图片腾出空间
    private static volatile NewsGlide glide;
    private ExecutorService glideService= Executors.newCachedThreadPool();//创建线程池  做多个小的事件工作 方便关闭线程
    //定义一个Handler，通过该Handler切换到主线程，在主线程里通回调接口返回Bitmap，这样的话，使用该库的开发人员获取Bitmap后不用在手动切到主线程渲染控件，方便开发
    private Handler mainHandler = new Handler();
    private boolean isInitated=false;
    private File cacheFileDir;
    private NewsGlide(){

    }
    public static NewsGlide getInstance(){
        if (glide==null) {
            synchronized (NewsGlide.class) {
                if (glide == null) {
                    glide = new NewsGlide();
                }
            }
        }
            return glide;
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
            diskLruCache = DiskLruCache.open(cacheFileDir,1,1,1024*1024*1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        isInitated = true;

    }

    //是不是已经初始化
    public boolean isInitated() {
        return isInitated;
    }
    //第一步取内存
    public Bitmap getBitmapFromMem(@NonNull String key){
        synchronized (memoryCache){
            return memoryCache.get(key);
        }
    }
    //存内存
    public  void setBitmapTomem(@NonNull String key,@NonNull Bitmap bitmap){
        synchronized (memoryCache){
             memoryCache.put(key,bitmap);
        }
    }
    //本地中查找  进行异步任务
     public void  getBitmapFromDisk(@NonNull final String key, @NonNull final IGetBitmapListerner getBitmapListerner){
        glideService.execute(new Runnable() {
            Bitmap bitmap=null;
            @Override
            public void run() {
                synchronized (diskLruCache){
                    try {
                        DiskLruCache.Snapshot snapshot = diskLruCache.get(key);
                        if (snapshot==null){
                            mainHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    getBitmapListerner.onBitmap(null);
                                }
                            });
                        }
                        InputStream inputStream = snapshot.getInputStream(0);
                        bitmap = BitmapFactory.decodeStream(inputStream);
                        setBitmapTomem(key,bitmap);//本地获取的Bitmap存放在内存缓存中
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                getBitmapListerner.onBitmap(bitmap);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
     }

     //将图片存储在DiskLruCache
    public void setBitmapToDisk(@NonNull final String key, @NonNull final Bitmap bitmap){
            glideService.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized (diskLruCache){
                        try {
                            DiskLruCache.Editor edit = diskLruCache.edit(key);
                            OutputStream outputStream = edit.newOutputStream(0);
                            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);//压缩
                            edit.commit();
                            diskLruCache.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
    }
    //从服务端获取Bitmap
    public void getBitmapFromServer(final String name, @NonNull final String url, final ImageView imageView, final IGetBitmapListerner getBitmapListerner){
        glideService.execute(new Runnable() {
            @Override
            public void run() {
                Call<ResponseBody> call = (Call<ResponseBody>) RetorfitConfig.getBaseUserInterface(name).image(url);
                //第二种调用方法
                try {
                    Response<ResponseBody> execute = call.execute();
                    //获取服务端图片的输入流
                    if (execute.body()==null){
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                getBitmapListerner.onBitmap(null);
                            }
                        });
                        return;
                    }
                    InputStream inputStream = execute.body().byteStream();//输入流
                    if (inputStream==null){
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                getBitmapListerner.onBitmap(null);
                            }
                        });
                        return;
                    }
                    //通过图片的输入流，生成对应bitmap
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    if (bitmap==null){
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                getBitmapListerner.onBitmap(null);
                            }
                        });
                        return;
                    }
                    Bitmap sampleBitmap = sampleBitmap(imageView.getWidth(), imageView.getHeight(), bitmap);
                    sampleBitmap.recycle();
                    sampleBitmap=null;
                    final Bitmap finalSampleBitmap = sampleBitmap;
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            getBitmapListerner.onBitmap(finalSampleBitmap);
                        }
                    });
                    //存入本地
                    String key = generateCacheKey(url);
                    setBitmapToDisk(key,sampleBitmap);
                    //存入内存
                    setBitmapTomem(key,sampleBitmap);
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
    private Bitmap sampleBitmap(int width,int height,Bitmap originalBitmap){
        int width1 = originalBitmap.getWidth();
        int height1 = originalBitmap.getHeight();
        //定义因子变量
        int sample=1;
        while (width1/sample > width && height1/sample > height){
            sample+=1;
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

     //接口回调Bitmap
    public interface IGetBitmapListerner{
        void onBitmap(Bitmap bitmap);
     }

    public static NewsRequest with(Context context) {
        NewsRequest newsRequest = new NewsRequest(context);
        return newsRequest;
    }


}
