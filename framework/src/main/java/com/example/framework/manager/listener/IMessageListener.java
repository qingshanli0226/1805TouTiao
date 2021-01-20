package com.example.framework.manager.listener;

import com.example.framework.dao.TouTiaoMessageGreenBean;

import java.util.List;

public interface IMessageListener {
    void OnResult(boolean isSuccess, List<TouTiaoMessageGreenBean> touTiaoMessageGreenBeanDao);
}
