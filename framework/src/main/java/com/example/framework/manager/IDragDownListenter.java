package com.example.framework.manager;

import com.example.framework.dao.DragBean;

import java.util.List;
//使用接口回调来刷新Ui
public interface IDragDownListenter {
    void onresult(boolean isSuccess, List<DragBean> list);
}
