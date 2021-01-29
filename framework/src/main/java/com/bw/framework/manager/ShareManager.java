package com.bw.framework.manager;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;

      private static volatile ShareManager shareManager;
      public static ShareManager getInstance(){
          if (shareManager==null){
              synchronized (ShareManager.class){
                  shareManager=new ShareManager();
              }
          }
          return shareManager;
      }
      //SP初始化
      public void init(Context context){
          sharedPreferences=context.getSharedPreferences("theme",0);
          edit = sharedPreferences.edit();
      }


      public int getShareValues(){
          int theme = sharedPreferences.getInt("matter", 0);

          return theme;
      }

      public void setShareValues(int theme){
          edit.putInt("matter",theme);
          edit.commit();
      }
}
