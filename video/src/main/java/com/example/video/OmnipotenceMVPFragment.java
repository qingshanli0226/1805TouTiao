package com.example.video;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.deom.News;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.framewrok.base.base.BaseMVPFragment;
import com.example.framewrok.base.video.VideoCountroller;
import com.example.framewrok.base.video.VideoImpl;
import com.example.net.bean.NewsBean;
import com.example.video.videoapter.VideoApter;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.zip.CRC32;

public class OmnipotenceMVPFragment extends BaseMVPFragment<VideoImpl,VideoCountroller.VideoView> implements VideoCountroller.VideoView {
    private RecyclerView videoRecyle;
    HashMap<String, String> map;
    ;
    ArrayList<News> arrayList = new ArrayList<>();
    VideoApter videoApter;
    News news;

    @Override
    protected void onregister(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initHttpData() {

    }

    @Override
    protected int getLayoutid() {
        return R.layout.omnipotence;
    }

    @Override
    protected void intView(View inflate) {

        videoRecyle = (RecyclerView) inflate.findViewById(R.id.video_recyle);
    }

    @Override
    protected void inPresone() {
        presenter = new VideoImpl();
    }

    @Override
    protected void inData() {

        videoApter = new VideoApter(R.layout.newsviewimg, arrayList);
        videoRecyle.setAdapter(videoApter);
        videoRecyle.setLayoutManager(new LinearLayoutManager(getContext()));
        videoApter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), VideoMainActivity.class);
                intent.putExtra("video_id",""+arrayList.get(position).getId());
                Log.e("LLLLL",""+arrayList.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onstart() {

    }

    @Override
    protected void onstop() {

    }

    // http://lf.snssdk.com/api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13&category=subv_life&max_behot_time=1611059715
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Message(VideoBean videoBean) {
        if (videoBean.getName().equals("生活") || videoBean.equals("影视") || videoBean.getName().equals("推荐")) {
            Log.e("DDDDDDD", videoBean.getId());
            map = new HashMap<>();
            map.put("iid", "5034850950");
            map.put("device_id", "6096495334");
            map.put("refer", "1");
            map.put("count", "20");
            map.put("aid", "13");
            map.put("category", videoBean.id);
            Log.e("XXX", "" + videoBean.getId());
            map.put("max_behot_time", "1611053318");
            presenter.VideoShow(videoBean.getName(), "api/news/feed/v62/", map, loadingPage);
        } else {
            Log.e("DDDDDDD", videoBean.getId());
            map = new HashMap<>();
            map.put("iid", "5034850950");
            map.put("device_id", "6096495334");
            map.put("refer", "1");
            map.put("count", "20");
            map.put("aid", "13");
            map.put("category", videoBean.id);
            Log.e("XXX", "" + videoBean.getId());
            map.put("max_behot_time", "1611053318");
            presenter.VideoShow("", "api/news/feed/v62/", map, loadingPage);
        }


    }

    @Override
    protected void ondestroy() {
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onVideoView(com.example.net.bean.VideoBean dataBeans) {

//        for (int i = 0; i < dataBeans.getData().size(); i++) {
//            Gson gson = new Gson();
//            NewsBean newsBean2 = gson.fromJson(dataBeans.getData().get(i).getContent(), NewsBean.class);
    //        News news = new News(newsBean2.getAbstractX(), newsBean2.getArticle_url(), newsBean2.getUser_info().getAvatar_url(), newsBean2.getMedia_name(), newsBean2.getTitle(), newsBean2.getUser_info().getAvatar_url());
//            Log.e("id",""+newsBean2.getItem_id());
//            arrayList.add(news);
//            videoApter.notifyDataSetChanged();
//        }
        for (int i = 0; i < dataBeans.getData().size(); i++) {
            Log.e("=======", "" + dataBeans.getData().get(i).getContent());

            try {
                JSONObject jsonObject = null;
                jsonObject = new JSONObject(dataBeans.getData().get(i).getContent() + "");
                if (jsonObject == null) {
                    Log.e("GGGG", "SSSSS");
                } else {
                    String anAbstract = jsonObject.getString("abstract");//内容
         Log.e("video_anAbstract",""+anAbstract);
         String article_url = jsonObject.getString("article_url");//网址
         Log.e("video_article_urlSSSSSS",""+article_url);
         String media_info = jsonObject.getString("media_info");
         Log.e("video_media_infoAAAAAAA",""+media_info);
         JSONObject jsonObject1=new JSONObject(media_info);
         String avatar_url = jsonObject1.getString("avatar_url");//头像
         Log.e("video_avatar_urlSSSSSS",""+avatar_url);
         String name = jsonObject1.getString("name");//姓名
         Log.e("video_nameSSSSSS",""+name);
         String share_info = jsonObject.getString("share_info");
         JSONObject jsonObject2=new JSONObject(share_info);
         String title = jsonObject2.getString("title");
         Log.e("video_titleSSSSS",""+title);//标题
         String middle_image = jsonObject.getString("middle_image");
         JSONObject jsonObject3=new JSONObject(middle_image);
         String url = jsonObject3.getString("url");//图片
         Log.e("video_url==========",""+url);
         String video_id = jsonObject.getString("video_id");
         Log.e("video_id", "" + video_id);

          news = new News(anAbstract, article_url, avatar_url, name, title, url,video_id);
         arrayList.add(news);
         videoApter.notifyDataSetChanged();
                }

            } catch (JSONException e) {
                e.printStackTrace();

            }


        }
    }

        @Override
        public void loading () {

        }

        @Override
        public void hideloading () {

        }
    }
