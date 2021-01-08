package com.kuaishou.bawei.net;

import com.kuaishou.bawei.net.bean.ErrorBean;

import io.reactivex.functions.Function;

//实现类型转换的，将R类型转换成T类型
public class NetKuaishouFunction<R extends BaseBean<T>, T> implements Function<R,T> {
    @Override
    public T apply(R r) throws Exception {
        if (r.getCode().equals("200")) {
            return r.getResult();
        } else {
            ErrorBean errorBean = new ErrorBean();
            errorBean.setErrorCode(r.getCode());
            errorBean.setErrorMessage(r.getMessage());
            throw new BusinessException(errorBean);
        }
    }
}
