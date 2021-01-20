package com.example.framework.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.LruCache;
import android.widget.ImageView;

import com.example.net.api.RetrofitCreater;
import com.jakewharton.disklrucache.DiskLruCache;

import org.greenrobot.greendao.annotation.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;


public
class TouTiaoGlide {
    /**
     * 创建单例
     */
    private static volatile  TouTiaoGlide touTiaoGlide  =  null;

    /**
     * 私有构造确定单例唯一
     */
    private TouTiaoGlide(){}
    /**
     * 双重检查锁
     */
    public static TouTiaoGlide getInstance(){
        if (touTiaoGlide == null){
            synchronized (TouTiaoGlide.class){
                if (touTiaoGlide == null){
                    touTiaoGlide  = new TouTiaoGlide();
                }
            }
        }
        return touTiaoGlide;
    }

    /**
     * 首先我需要一个内存缓存 此数据类型可以自动管理内存 避免数据结构出现无限制的占用
     *在实例化该数据结构时，可以给该数据结构设置一使用最大限制 超出则自动管理
     */

    private LruCache<String, Bitmap> bitmapLruCache;

    /**
     * 其次我们需要一个磁盘换粗  是用来存储图片文件  同样自动管理
     * 设定是当我们的存储超出这个最大值，则自动删除  腾出空间  存放新的图片文件
     */

    private DiskLruCache diskLruCache;

    /**
     * 现在需要一个线程池  该线程池是缓存线程池，适合的是小而多的任务
     * 自动给我们生成和释放线程
     */

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private File cacheFileDisk ;


    /**
     * 是否已经初始化
     */

    private boolean isInitAted  = false;

    /**
     * 初始化缓存数据
     * @param context
     */
    public void init(Context context){
        bitmapLruCache = new LruCache<String,Bitmap>((int) Runtime.getRuntime().maxMemory()/8){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };

        /**
         * 初始化本地缓存  该缓存创建一目录存放本地图片，作用是在应用程序卸载是，该目录下的文件同时被删除
         * 不会产生垃圾文件  这样做可提高用户体验 提高对内存效率的使用
         */
        cacheFileDisk =  new File(context.getExternalCacheDir().getAbsoluteFile()+"/image/");
        if (!cacheFileDisk.exists()){
            cacheFileDisk.mkdirs();
        }

        try {
            diskLruCache = DiskLruCache.open(cacheFileDisk,1,1,1024*1024*1024);
        } catch (IOException e) {
            e.printStackTrace();
        }

        isInitAted = true;
    }

    /**
     * 是否初始化
     * @return
     */
    public boolean getIsInitAted(){
        return isInitAted;
    }

    /**
     * 定义一个handler  做到切换主线程  在主线程里通过回调接口返回bitmip 方便开发
     * 程序完善
     */
    private Handler handler = new Handler();


    /**
     * 设置锁
     */

    private Lock lock = new ReentrantLock();

    /**
     * 操作内存方法  内存中读取图片Bitmip
     */

    public Bitmap getBitmapFromMap(@NotNull String key){
        synchronized (bitmapLruCache){
            return bitmapLruCache.get(key);
        }
    }

    /**
     * 将图片写入内存中
     * @param key
     * @param bitmap
     */
    public void setBitmapToMen(@NotNull String key,@NotNull Bitmap bitmap){
        synchronized (bitmapLruCache){
            bitmapLruCache.put(key,bitmap);
        }
    }

    /**
     *
     * @param key
     * @param iGetBitmapListener
     */
    public void getBitmapFromDisk(@NotNull final String key,@NotNull final IGetBitmapListener iGetBitmapListener){
        executorService.execute(new Runnable() {
            Bitmap bitmap = null;
            @Override
            public void run() {
                synchronized (diskLruCache){
                    try {
                        DiskLruCache.Snapshot snapshot = diskLruCache.get(key);
                        if (snapshot == null){
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    iGetBitmapListener.onBitmap(null);
                                }
                            });
                            return;
                        }
                        InputStream inputStream = snapshot.getInputStream(0);
                        final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        //将本地 （磁盘） 获取的bitmap存入缓存中  下次直接可以使用
                        setBitmapToMen(key,bitmap);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iGetBitmapListener.onBitmap(bitmap);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * 将图片文件存入diskLrucache中
     *
     */
    public void  setBitmapToDisk(@NotNull final  String key,@NotNull final  Bitmap bitmap){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (diskLruCache){
                    try {
                        DiskLruCache.Editor edit = diskLruCache.edit(key);
                        OutputStream outputStream = edit.newOutputStream(0);
                        bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                        edit.commit();
                        diskLruCache.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * 从服务端获取Bitmap
     */
    public void getBitmapFromServer(@NotNull final  String url, final ImageView imageView,final IGetBitmapListener iGetBitmapListener){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Call<ResponseBody> responseBodyCall = RetrofitCreater.getiMobileMEdiaApi().downLoadFile(url);
                try {
                    Response<ResponseBody> execute = responseBodyCall.execute();
                    if (execute.body()==null){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iGetBitmapListener.onBitmap(null);
                            }
                        });
                        return;
                    }
                    InputStream inputStream = execute.body().byteStream();
                    if (inputStream==null){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iGetBitmapListener.onBitmap(null);
                            }
                        });
                        return;
                    }

                    //生成bitmap
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    if (bitmap==null){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iGetBitmapListener.onBitmap(null);
                            }
                        });
                    }

                    final Bitmap sampleBitmap = sampleBitmap(imageView.getWidth(), imageView.getMaxHeight(), bitmap);
                    bitmap.recycle();
                    bitmap = null;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iGetBitmapListener.onBitmap(sampleBitmap);
                        }
                    });

                    //生成key
                    String key = generateCacheKey(url);
                    //存入本地
                    setBitmapToDisk(key,sampleBitmap);
                    //存入内存
                    setBitmapToMen(key,sampleBitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     *
     * @param width
     * @param height
     * @param originalBitmap
     * @return
     */
    private Bitmap sampleBitmap(int width,int height,Bitmap originalBitmap){
        int picWidth = originalBitmap.getWidth();
        int picHeight = originalBitmap.getHeight();
        int sample = 1;
        if (picHeight/sample>height && picWidth/sample>width){
            sample = sample+1;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = sample;
        options.inPreferredConfig = Bitmap.Config.RGB_565;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        originalBitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);

        return bitmap;
    }

    /**
     *通过图片的地址生成key值  作为缓存和本地的key
     * @param url
     * @return
     */
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


    public interface  IGetBitmapListener{
        void onBitmap(Bitmap bitmap);
    }


}
