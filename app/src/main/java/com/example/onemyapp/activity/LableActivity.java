package com.example.onemyapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.framewrok.base.base.BaseActivity;
import com.example.onemyapp.MainActivity;
import com.example.onemyapp.NewsManager;
import com.example.onemyapp.R;
import com.example.onemyapp.application.NewsApplication;
import com.example.onemyapp.apter.LableApter;
import com.example.onemyapp.apter.MyLableApter;
import com.example.onemyapp.bean.DaoSession;
import com.example.onemyapp.bean.LabelBean;
import com.example.onemyapp.bean.LabelBeanDao;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

public class LableActivity extends BaseActivity {
       DaoSession daoSession;
    LabelBeanDao labelBeanDao;
    private RecyclerView labeRecyle;
    LableApter lableApterapter;
    private ImageView slidemenu;
    private TextView text;
    private Button btnEdit;
    private RecyclerView RvShow;
    private RecyclerView RvHide;
    ArrayList<String> addarrayList=new ArrayList<>();
    MyLableApter myLableApter;

    @Override
    protected int getlayoutId() {
        return R.layout.lableview;
    }

    @Override
    protected void intView() {
      daoSession=NewsApplication.getDaoSession();
       labelBeanDao  = daoSession.getLabelBeanDao();
        slidemenu = (ImageView) findViewById(R.id.slidemenu);
        text = (TextView) findViewById(R.id.text);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        RvShow = (RecyclerView) findViewById(R.id.RvShow);
        RvHide = (RecyclerView) findViewById(R.id.RvHide);

    }

    @Override
    protected void inPresone() {

    }

    @Override
    protected void inData() {

        String []  strArr = this.getResources().getStringArray(R.array.mobile_news_name);
        final String []  strArrid = this.getResources().getStringArray(R.array.mobile_news_id);
        for (int i=0;i<strArr.length;i++){
            Log.e("SSSSSSSSS",""+strArr[i].toString());
            daoSession.insert(new LabelBean(null,strArr[i],strArrid[i]));
        }
        final List<String> getaddnews = NewsManager.getInstance().getaddnews();
        myLableApter=new MyLableApter(R.layout.hidelable,getaddnews);
        RvShow.setAdapter(myLableApter);
        RvShow.setLayoutManager(new GridLayoutManager(LableActivity.this,4));
        myLableApter.notifyDataSetChanged();
          NewsManager.getInstance().querMessage(new NewsManager.IMessageListener() {
              @Override
              public void onResult(final List<LabelBean> labelBeans) {
                  lableApterapter=new LableApter(R.layout.hidelable,labelBeans);
                  RvHide.setAdapter(lableApterapter);
                  RvHide.setLayoutManager(new GridLayoutManager(LableActivity.this,4));
                  lableApterapter.notifyDataSetChanged();

                  lableApterapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                      @Override
                      public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                          Toast.makeText(LableActivity.this, "1111111", Toast.LENGTH_SHORT).show();
                          addarrayList.add(labelBeans.get(position).getTitle());
                          NewsManager.getInstance().addLable(labelBeans.get(position).getTitle());

                          for (int i=0;i<getaddnews.size();i++){
                              Log.e("AAAAAAAAAAA",getaddnews.get(i));
                          }
                          myLableApter=new MyLableApter(R.layout.hidelable,getaddnews);
                          RvShow.setAdapter(myLableApter);
                          RvShow.setLayoutManager(new GridLayoutManager(LableActivity.this,4));
                          myLableApter.notifyDataSetChanged();
                          LabelBean labelBean=new LabelBean(null,labelBeans.get(position).getTitle(),labelBeans.get(position).getTitle_id());
                          EventBus.getDefault().post(labelBean);
                      }
                  });
              }
          });

    }



    @Override
    protected void ondestroy() {

        labelBeanDao.deleteAll();


    }
}
