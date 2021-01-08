package com.bw.common;

public class Constants {
    public static final String BASE = "http://toutiao.com/";
    /**
    * 获取新闻标题等信息
    * "http://toutiao.com/api/article/recent/?source=2&category=类型&as=A105177907376A5&cp=5797C7865AD54E1&_=时间&count=30";
    * 其他 API
    * "http://www.toutiao.com/api/article/feed/?category=类型&as=A115C8457F69B85&cp=585F294B8845EE1&_=时间&count=30";
    * "http://www.toutiao.com/api/pc/feed/?category=类型&utm_source=toutiao&widen=1&max_behot_time=时间&max_behot_time_tmp=时间&tadrequire=true&as=A1C598BB87BE7DA&cp=58B72ED7AD3A0E1";
    */
    public static final String BASE_ARTICLE_RECENT = "api/article/recent/";

    public static final String BASE2 = "http://is.snssdk.com/";
    public static final String BASE3 = "http://lf.snssdk.com/";
    /**
     * 获取个性化新闻
     * 深圳 http://is.snssdk.com/api/news/feed/v58/?iid=5034850950&device_id=6096495334&category=news_society
     * 深圳 http://lf.snssdk.com/api/news/feed/v58/?iid=12507202490&device_id=37487219424&category=news_society
     * 天津 http://ib.snssdk.com/api/news/feed/v58/?
     * 北京 http://iu.snssdk.com/api/news/feed/v58/?
     *
     *http://is.snssdk.com/api/news/feed/v62/?refer=1&count=20&loc_mode=4&device_id=34960436458&iid=13136511752
     *
     * http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=&max_behot_time=1609986645
     * http://lf.snssdk.com/api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13&category=&max_behot_time=1609986247
     *
     * http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13
     * http://lf.snssdk.com/api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13
     *
     * @param iid      用户ID
     * @param deviceId 设备ID
     * @param category 新闻/图片/视频栏目
     */

    public static final String BASE_NEWS_FEED = "api/news/feed/v58/";
    public static final String BASE_NEWS_FEED2 = "api/news/feed/v62/";

}
