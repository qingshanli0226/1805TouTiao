package com.example.news.ui.fragment.presenter;

import android.util.Log;

import com.example.news.ui.fragment.contract.NewsContract;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.NewsBean;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import uitls.Retrofitcreators;

public class NewsPresenterImpl extends NewsContract.NewsPresenter {
    private List<HashMap<String,String>> hashMaps = new ArrayList<>();
    @Override
    public void getNewsInfo(String url, HashMap<String,String> map) {
            Log.e("###","zzzz");

            Retrofitcreators.getBaseInterface().journalis(url, map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<NewsBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(NewsBean newsBean) {
                            Log.i("newsPresenter", "onNext: " + newsBean.getData());
                            List<NewsBean.DataBean> newBeans = newsBean.getData();
                            //使用原声解析数据
                            for (int i = 0; i < newBeans.size(); i++) {
                                String content = newBeans.get(i).getContent();
                                Log.i("ZLD", "onNews: " + content);
                                try {
                                    JSONObject jsonObject = new JSONObject(content);
                                    String anAbstract = jsonObject.getString("abstract");//内容
                                    String article_url = jsonObject.getString("article_url");//网址
                                    String behot_time = jsonObject.getString("behot_time");//时间
                                    String media_info = jsonObject.getString("media_info");
                                    JSONObject jsonObject1 = new JSONObject(media_info);
                                    String avatar_url = jsonObject1.getString("avatar_url");//头像
                                    String name = jsonObject1.getString("name");//姓名
                                    String share_info = jsonObject.getString("share_info");
                                    JSONObject jsonObject2 = new JSONObject(share_info);
                                    String title = jsonObject2.getString("title");//标题
                                    String middle_image = jsonObject.getString("middle_image");
                                    JSONObject jsonObject3 = new JSONObject(middle_image);
                                    String url = jsonObject3.getString("url");//图片
                                    HashMap hashMap = new HashMap<>();
                                    hashMap.put("anAbstract", anAbstract);
                                    hashMap.put("article_url", article_url);
                                    hashMap.put("media_info", media_info);
                                    hashMap.put("avatar_url", avatar_url);
                                    hashMap.put("name", name);
                                    hashMap.put("title", title);
                                    hashMap.put("behot_time", behot_time);
                                    hashMap.put("url", url);
                                    hashMaps.add(hashMap);
                                    iView.onNews(hashMaps);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                                Log.d("ZLD", e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

            }
        }
