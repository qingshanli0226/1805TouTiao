package com.example.onemyapp.home.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.framewrok.base.base.BaseFragment;
import com.example.onemyapp.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

<<<<<<< HEAD:app/src/main/java/com/example/onemyapp/home/HomeFragment.java
public class HomeFragment extends BaseFragment {
    private ImageView slidemenu;
    private TextView text;



=======
public class FinanceFragment extends BaseFragment {
>>>>>>> gtl2:app/src/main/java/com/example/onemyapp/home/fragment/FinanceFragment.java
    @Override
    protected int getLayoutid() {
        return R.layout.financefragment;
    }

    @Override
<<<<<<< HEAD:app/src/main/java/com/example/onemyapp/home/HomeFragment.java
    protected void intView(View inflate) {
        slidemenu = (ImageView) inflate.findViewById(R.id.slidemenu);
        text = (TextView) inflate.findViewById(R.id.text);

=======
    protected void intView(View view) {
>>>>>>> gtl2:app/src/main/java/com/example/onemyapp/home/fragment/FinanceFragment.java
    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {
        Toast.makeText(getContext(), "1111", Toast.LENGTH_SHORT).show();
        final SlidingMenu slidingMenu=new SlidingMenu(getActivity());
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.slidemenu, null);
        slidingMenu.setBehindWidth(500);
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
