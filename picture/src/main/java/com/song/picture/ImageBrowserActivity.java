package com.song.picture;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.snackbar.Snackbar;
import com.pixelcan.inkpageindicator.InkPageIndicator;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.song.common.ErrorAction;
import com.song.fromwork.BaseActivity;
import com.song.fromwork.utils.DownloadUtil;
import com.song.fromwork.utils.ImageLoader;
import com.song.fromwork.utils.SettingUtil;
import com.song.net.Constant;
import com.song.picture.widget.BottomSheetDialogFixed;
import com.song.picture.widget.imagebrowser.DismissFrameLayout;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.SettingService;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import uk.co.senab.photoview.DefaultOnDoubleTapListener;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageBrowserActivity extends BaseActivity {

    protected SlidrInterface slidrInterface;
    private static final String TAG = "ImageBrowserActivity";
    private static final String EXTRA_URl = "url";
    private static final String EXTRA_LIST = "list";

    private static final int ALPHA_MAX = 0xFF;

    private int mCurrentPosition;
    private ArrayList<String> mImgList;

    private ViewPager mViewPager;
    private InkPageIndicator mIndicator;
    private ColorDrawable mColorDrawable;

    private boolean canHideFlag = true;
    private long mIndicatorHideTime;

    private DismissFrameLayout.OnDismissListener onDismissListener = new DismissFrameLayout.OnDismissListener() {
        @Override
        public void onScaleProgress(float scale) {
            mColorDrawable.setAlpha(
                    Math.min(ALPHA_MAX, mColorDrawable.getAlpha() - (int) (scale * ALPHA_MAX)));
        }

        @Override
        public void onDismiss() {
            finish();
        }

        @Override
        public void onCancel() {
            mColorDrawable.setAlpha(ALPHA_MAX);
        }
    };


    public static void start(Context context, String url, ArrayList<String> imgList) {
        Intent starter = new Intent(context, ImageBrowserActivity.class);
        starter.putExtra(EXTRA_URl, url);
        starter.putStringArrayListExtra(EXTRA_LIST, imgList);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        int isSlidable = SettingUtil.getInstance().getSlidable();
        if (isSlidable != Constant.SLIDABLE_DISABLE) {
            SlidrConfig config = new SlidrConfig.Builder()
                    .edge(isSlidable == Constant.SLIDABLE_EDGE)
                    .build();
            slidrInterface = Slidr.attach(this, config);
        }

        RelativeLayout container = findViewById(R.id.container);
        mColorDrawable = new ColorDrawable(getResources().getColor(R.color.Black));
        container.setBackground(mColorDrawable);


        mImgList = intent.getStringArrayListExtra(EXTRA_LIST);
        String url = intent.getStringExtra(EXTRA_URl);
        mCurrentPosition = mImgList.indexOf(url);

        mViewPager = findViewById(R.id.viewPager);
        mViewPager.setAdapter(new PhotoAdapter(mImgList, onDismissListener));
        mViewPager.setCurrentItem(mCurrentPosition);

        mIndicator = findViewById(R.id.indicator);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (slidrInterface != null) {
                    if (position == 0) {
                        slidrInterface.unlock();
                    } else {
                        slidrInterface.lock();
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    mIndicatorHideTime = System.currentTimeMillis();
                    canHideFlag = true;
                } else {
                    canHideFlag = false;
                    mIndicator.animate()
                            .translationY(0)
                            .setDuration(200)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    mIndicator.setVisibility(View.VISIBLE);
                                }
                            });
                }
            }
        });

        startIndicatorObserver();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_imagebrowser;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIndicator.setViewPager(mViewPager);
    }

    private void startIndicatorObserver() {
        Flowable.interval(1, 1, TimeUnit.SECONDS)
                .filter(aLong -> canHideFlag && System.currentTimeMillis() - mIndicatorHideTime > 1000)
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .as(this.bindAutoDispose())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        canHideFlag = false;
                        mIndicator.animate()
                                .translationY(mIndicator.getHeight())
                                .setDuration(400)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        mIndicator.setVisibility(View.GONE);
                                    }
                                });
                    }
                });
    }

    public void translucentScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void onLongClick() {
        final BottomSheetDialogFixed dialog = new BottomSheetDialogFixed(this);
        dialog.setOwnerActivity(this);
        View view = getLayoutInflater().inflate(R.layout.item_imageview_action_sheet, null);
        view.findViewById(R.id.layout_dowm_image).setOnClickListener(view12 -> {
            saveImage();
            dialog.dismiss();
        });
        view.findViewById(R.id.layout_share_image).setOnClickListener(view1 -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                shareImage();
            }
            dialog.dismiss();
        });
        dialog.setContentView(view);
        dialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void shareImage() {
        if (ContextCompat.checkSelfPermission(this, Permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermission();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Maybe.create((MaybeOnSubscribe<Bitmap>) emitter -> {
                    final String url = mImgList.get(mViewPager.getCurrentItem());
                    Bitmap bitmap = Glide.with(this).asBitmap().load(url)
                            .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                            .get();
                    emitter.onSuccess(bitmap);
                })
                        .subscribeOn(Schedulers.io())
                        .filter(Objects::nonNull)
                        .map(bitmap -> {
                            File appDir = new File(Environment.getExternalStorageDirectory(), "Toutiao");
                            if (!appDir.exists()) {
                                appDir.mkdir();
                            }
                            String fileName = "temporary_file.jpg";
                            File file = new File(appDir, fileName);
                            FileOutputStream fos = new FileOutputStream(file);
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                            fos.flush();
                            fos.close();
                            return file;
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .as(this.bindAutoDispose())
                        .subscribe(file -> IntentAction.sendImage(this, Uri.fromFile(file)), ErrorAction.error());
            }
        }
    }

    private void requestPermission() {
        AndPermission.with(this)
                .permission(Permission.WRITE_EXTERNAL_STORAGE)
                .rationale((context, permissions, executor) -> new AlertDialog.Builder(context)
                        .setMessage("使用此功能需要打开存储权限")
                        .setPositiveButton("允许", (dialog, which) -> executor.execute())
                        .setNegativeButton("拒绝", (dialog, which) -> executor.cancel())
                        .show())
                .onDenied(permissions -> {
                    Snackbar.make(mViewPager, "不好使", Snackbar.LENGTH_SHORT).show();
                    if (AndPermission.hasAlwaysDeniedPermission(ImageBrowserActivity.this, permissions)) {
                        final SettingService settingService = AndPermission.permissionSetting(ImageBrowserActivity.this);
                        new AlertDialog.Builder(ImageBrowserActivity.this)
                                .setMessage("需要打开权限")
                                .setPositiveButton("允许", (dialog, which) -> settingService.execute())
                                .setNegativeButton("拒绝", (dialog, which) -> settingService.cancel())
                                .show();
                    }
                })
                .start();
    }

    private void saveImage() {
        if (ContextCompat.checkSelfPermission(this, Permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermission();
        } else {
            final String url = mImgList.get(mViewPager.getCurrentItem());
            Maybe.create((MaybeOnSubscribe<Boolean>) emitter -> emitter.onSuccess(DownloadUtil.saveImage(url, this)))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .as(this.bindAutoDispose())
                    .subscribe(b -> {
                        String s = b ? "保存成功" : "保存失败";
                        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                    }, ErrorAction.error());
        }
    }

    public class PhotoAdapter extends PagerAdapter {
        List<String> mList;
        DismissFrameLayout.OnDismissListener mOnDismissListener;
        SparseArray<View> mCacheViewArray;

        PhotoAdapter(List<String> mList, DismissFrameLayout.OnDismissListener onDismissListener) {
            this.mList = mList;
            this.mOnDismissListener = onDismissListener;
            this.mCacheViewArray = new SparseArray<>(mList.size());
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            View view = mCacheViewArray.get(position);

            if (view == null) {
                Context context = container.getContext();
                view = LayoutInflater.from(context).inflate(R.layout.item_image_browser, container, false);
                view.setTag(position);

                PhotoView imageView = view.findViewById(R.id.photoView);
                PhotoViewAttacher attacher = new PhotoViewAttacher(imageView);
                attacher.setOnDoubleTapListener(new PhotoViewOnDoubleTapListener(attacher));
                attacher.setOnLongClickListener(v -> {
                    ImageBrowserActivity.this.onLongClick();
                    return false;
                });

                ImageLoader.loadNormal(context, mList.get(position), imageView);

                DismissFrameLayout layout = view.findViewById(R.id.dismissContainter);
                layout.setDismissListener(mOnDismissListener);

                mCacheViewArray.put(position, view);
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

    private class PhotoViewOnDoubleTapListener extends DefaultOnDoubleTapListener {

        private PhotoViewAttacher photoViewAttacher;
        private boolean canZoom = true;

        PhotoViewOnDoubleTapListener(PhotoViewAttacher photoViewAttacher) {
            super(photoViewAttacher);
            this.photoViewAttacher = photoViewAttacher;
        }

        @Override
        public boolean onDoubleTap(MotionEvent ev) {
            if (photoViewAttacher == null)
                return false;
            try {
                float x = ev.getX();
                float y = ev.getY();

                if (canZoom) {
                    photoViewAttacher.setScale(photoViewAttacher.getMediumScale(), x, y, true);
                } else {
                    photoViewAttacher.setScale(photoViewAttacher.getMinimumScale(), x, y, true);
                }
                canZoom = !canZoom;
            } catch (ArrayIndexOutOfBoundsException e) {
                // Can sometimes happen when getX() and getY() is called
            }

            return true;
        }
    }

}
