package com.example.onemyapp.home.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.framewrok.base.base.BaseFragment;
import com.example.framewrok.base.journalism.JournalismCountroller;
import com.example.framewrok.base.journalism.JournalismImpl;
import com.example.net.bean.JournalismBean;
import com.example.onemyapp.MainActivity;
import com.example.onemyapp.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;


public class FinanceFragment extends BaseFragment<JournalismImpl, JournalismCountroller.JournalismView> implements JournalismCountroller.JournalismView {
    private RecyclerView recyle;

    ArrayList<JournalismBean.DataBean> arrayList=new ArrayList<>();


    @Override
    protected int getLayoutid() {
        return R.layout.financefragment;
    }

    @Override
    protected void intView(View inflate) {
        recyle = (RecyclerView)inflate. findViewById(R.id.recyle);


    }

    @Override
    protected void inPresone() {
     prine=new JournalismImpl();
    }

    @Override
    protected void inData() {
        prine.NewsShow();
    }

    @Override
    protected void ondestroy() {
            prine.onDestroy();
    }



    @Override
    public void loading() {

    }

    @Override
    public void hideloading() {

    }

    @Override
    public void onJournalismView(JournalismBean dataBeans) {
        Log.e("=======",""+dataBeans.getData().get(0).getContent());
    }
}
