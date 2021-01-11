package com.bw.framework.url;

import java.util.HashMap;

public class SetUrl{
     private static volatile SetUrl setUrl=null;

     public static SetUrl getInstance(){
           if (setUrl==null){
               synchronized (SetUrl.class){
                   if (null==setUrl){
                       setUrl=new SetUrl();
                   }
               }
           }
          return setUrl;
     }

     public HashMap<String,String> seturl(String address){
         HashMap<String,String> map=new HashMap<>();
         map.put("iid","12507202490");
         map.put("device_id","37487219424");
         map.put("count","20");
         map.put("category",address);
         map.put("max_behot_time",System.currentTimeMillis()+"");

         return map;
     }
}
