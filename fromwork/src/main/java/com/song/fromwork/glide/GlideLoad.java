package com.song.fromwork.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.LruCache;
import android.widget.ImageView;

import com.jakewharton.disklrucache.DiskLruCache;
import com.song.net.RetrofitHelper;

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
import retrofit2.Call;
import retrofit2.Response;

public class GlideLoad {

    private LruCache<String, Bitmap> memoryCache;
    private DiskLruCache diskCache;
    private File cacheFileDir;

    private static volatile GlideLoad instance;

    private ExecutorService glideService = Executors.newCachedThreadPool();

    private boolean isInitated = false;

    private Handler mainHandler = new Handler();

    private GlideLoad() {
    }

    public void init(Context context) {
        //分配占多少内存空间
        memoryCache = new LruCache<>((int) Runtime.getRuntime().maxMemory() / 4);
        cacheFileDir = new File(context.getExternalCacheDir().getAbsolutePath() + "/glideLoad/");
        if (!cacheFileDir.exists()) {
            cacheFileDir.mkdir();
        }

        try {
            diskCache = DiskLruCache.open(cacheFileDir, 1, 1, 1024 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        isInitated = true;
    }

    public void unInit() {
        isInitated = false;
    }

    public boolean isInitated() {
        return isInitated;
    }

    public static GlideLoad getInstance() {
        if (instance == null) {
            synchronized (GlideLoad.class) {
                if (instance == null) {
                    instance = new GlideLoad();
                }
            }
        }
        return instance;
    }

    public void getBitmapFromDisk(final String key, @NonNull final IGetBitmapListener listener) {
        glideService.execute(new Runnable() {
            Bitmap bitmap = null;

            @Override
            public void run() {
                synchronized (diskCache) {
                    try {
                        DiskLruCache.Snapshot snapshot = diskCache.get(key);
                        if (snapshot == null) {//鏈¬鍦扮£佺洏涓­涔熸病鏈夎¯ュ浘鐗
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
                        setBitmapToMem(key, bitmap);//灏嗕粠鏈¬鍦拌幏鍙栫殑bitmap瀛樺叆鍐呭瓨缂撳瓨涓­
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

    public void setBitmapToDisk(@NonNull final String key, @NonNull final Bitmap bitmap) {
        glideService.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (diskCache) {
                    try {
                        DiskLruCache.Editor editor = diskCache.edit(key);
                        OutputStream outputStream = editor.newOutputStream(0);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                        editor.commit();
                        diskCache.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public interface IGetBitmapListener {
        void onBitmap(Bitmap bitmap);
    }

    public void setBitmapToMem(@NonNull String key, @NonNull Bitmap bitmap) {
        synchronized (memoryCache) {
            memoryCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMem(@NonNull String key) {
        synchronized (memoryCache) {
            return memoryCache.get(key);
        }
    }

    public void getBitmapFromServer(@NonNull final String url, final ImageView imageView, final IGetBitmapListener listener) {
        glideService.execute(new Runnable() {
            @Override
            public void run() {
                Call<ResponseBody> call = (Call<ResponseBody>) RetrofitHelper.getNetworkApi().downloadFile(url);
                //绗¬浜岀§嶈皟鐢ㄦ柟娉
                try {
                    Response<ResponseBody> response = call.execute();
                    //鑾峰彇鏈嶅姟绔¯鍥剧墖鐨勮緭鍏ユ祦
                    if (response.body() == null) {
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onBitmap(null);//閫氳繃涓荤嚎绋嬪皢bitmap杩斿洖璋冪敤鑰
                            }
                        });
                        return;
                    }
                    InputStream inputStream = response.body().byteStream();//杈撳叆娴
                    if (inputStream == null) {
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onBitmap(null);//閫氳繃涓荤嚎绋嬪皢bitmap杩斿洖璋冪敤鑰
                            }
                        });
                        return;

                    }
                    //閫氳繃鍥剧墖鐨勮緭鍏ユ祦锛岀敓鎴愬¯瑰簲bitmap
                    Bitmap originalBitmap = BitmapFactory.decodeStream(inputStream);
                    if (originalBitmap == null) {
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onBitmap(null);//閫氳繃涓荤嚎绋嬪皢bitmap杩斿洖璋冪敤鑰
                            }
                        });
                        return;
                    }
                    //鍋氫簩娆￠噰鏍·,浣跨敤鍘熷浘鐨凚itmap鐢熸垚鍜屾帶浠跺¯瑰簲鐨勪簩娆￠噰鏍峰悗鐨刡itmap锛岃繖鏍峰彲浠ヨ妭绾﹀唴瀛
                    final Bitmap sampleBitmap = sampleBitmap(imageView.getWidth(), imageView.getHeight(), originalBitmap);
                    originalBitmap.recycle();
                    originalBitmap = null;
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onBitmap(sampleBitmap);//閫氳繃涓荤嚎绋嬪皢bitmap杩斿洖璋冪敤鑰
                        }
                    });
                    //灏唖ampleBitmap瀛樺埌鏈¬鍦°
                    String key = generateCacheKey(url);
                    setBitmapToDisk(key, sampleBitmap);
                    //灏唖ampleBitmap瀛樺埌鍐呭瓨涓­
                    setBitmapToMem(key, sampleBitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //二次采样
    private Bitmap sampleBitmap(int width, int height, Bitmap originalBitmap) {
        int picWidth = originalBitmap.getWidth();
        int picHeight = originalBitmap.getHeight();
        int sample = 1;
        while (picHeight / sample > height && picWidth / sample > width) {
            sample = sample + 1;
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = sample;
        options.inPreferredConfig = Bitmap.Config.RGB_565;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        originalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bytes = baos.toByteArray();
        Bitmap sampleBitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        return sampleBitmap;
    }

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


    public static GlideRequest with(Context context) {
        GlideRequest glideRequest = new GlideRequest(context);
        return glideRequest;
    }

}
