package com.bw.a1805atoutiao.application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bw.framework.manager.NetConnectManager;
import com.bw.framework.manager.ShareManager;
import com.bw.framework.manager.TitleManage;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 打印日志
        ARouter.openLog();
        // 开启调试模式(如果在InstantRun(就是AndroidStudio2.0以后新增的一个可以减少很多编译时间的运行机制)模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.openDebug();
        // 初始化尽可能早，推荐在Application中初始化
        ARouter.init(this);

        //GreenDao初始化
        TitleManage.getInstance().init(this);
        //网络连接状态
        NetConnectManager.getInstance().init(this);
        //初始化sp
        ShareManager.getInstance().init(this);

    }


}
