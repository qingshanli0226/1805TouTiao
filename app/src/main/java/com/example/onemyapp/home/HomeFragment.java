package com.example.onemyapp.home;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.framewrok.base.base.BaseFragment;
import com.example.onemyapp.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class HomeFragment extends BaseFragment {
    private ImageView slidemenu;
    private TextView text;



    @Override
    protected int getLayoutid() {
        return R.layout.homefragment;
    }

    @Override
    protected void intView(View inflate) {
        slidemenu = (ImageView) inflate.findViewById(R.id.slidemenu);
        text = (TextView) inflate.findViewById(R.id.text);

    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {
        Toast.makeText(getContext(), "1111", Toast.LENGTH_SHORT).show();
        final SlidingMenu slidingMenu=new SlidingMenu(getActivity());
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.slidemenu, null);
        slidingMenu.setBehindWidth(400);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setMenu(inflate);
        slidingMenu.attachToActivity(getActivity(),SlidingMenu.SLIDING_CONTENT);
        slidemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slidingMenu.toggle();
            }
        });
    }

    @Override
    protected void ondestroy() {

    }
}
