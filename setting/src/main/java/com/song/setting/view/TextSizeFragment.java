package com.song.setting.view;


import android.icu.text.DecimalFormat;
import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.jaygoo.widget.RangeSeekBar;
import com.song.fromwork.BaseFragment;
import com.song.fromwork.utils.RxBus;
import com.song.fromwork.utils.SettingUtil;
import com.song.setting.R;

/**
 * A simple {@link Fragment} subclass.
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class TextSizeFragment extends BaseFragment {

    private RangeSeekBar seekbar;
    private TextView text;
    private DecimalFormat df = new DecimalFormat("0");
    private int currentSize = -1;
    private SettingUtil settingUtil = SettingUtil.getInstance();

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        seekbar = findViewById(R.id.seekbar);
        text = findViewById(R.id.text);
        text.setTextSize(settingUtil.getTextSize());
        seekbar.setValue(settingUtil.getTextSize() - 14);
        seekbar.setLineColor(0, settingUtil.getColor());
        seekbar.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, final float min, float max, boolean isFromUser) {
                if (isFromUser) {
                    int size = Integer.parseInt(df.format(min));
                    if (currentSize != size) {
                        setText(size);
                        currentSize = size;
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }
        });
    }

    private void setText(int size) {
        // 最小 14sp
        size = 14 + size;
        text.setTextSize(size);
        settingUtil.setTextSize(size);
        RxBus.getInstance().post("BaseListFragment", size);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_text_size;
    }

}
