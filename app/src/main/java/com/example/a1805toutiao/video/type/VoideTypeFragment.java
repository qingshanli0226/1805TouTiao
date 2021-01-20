package com.example.a1805toutiao.video.type;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1805toutiao.R;
import com.example.common.error.ErrorBean;
import com.example.framework.base.BaseFragment;
import com.example.net.bean.news.MultiNewsArticleBean;

import java.util.ArrayList;
import java.util.List;

public
class VoideTypeFragment extends BaseFragment<VoideTypePresenter,VoideTypeContract.IVoideTypeView> implements VoideTypeContract.IVoideTypeView {
    private String type;
    private RecyclerView rvVoideType;
    private VoideTypeAdaper voideTypeAdaper;
    private List<MultiNewsArticleBean.DataBean>  dataBeans = new ArrayList<>();
    public VoideTypeFragment(String name) {
        this.type = name;
    }

    @Override
    protected void initData() {
        presenter.loadVoide(type,System.currentTimeMillis()/1000+"");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        rvVoideType = (RecyclerView) findViewById(R.id.rv_voide_type);
        rvVoideType.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    protected void initPresenter() {
        presenter = new VoideTypePresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_voide_type;
    }

    @Override
    public void onVoideTypeLoadOk(MultiNewsArticleBean multiNewsArticleBean) {
            dataBeans.addAll(multiNewsArticleBean.getData());

    }

    @Override
    public void showLoadingPage() {
        showLoading();
    }

    @Override
    public void hideLoadingPage(boolean isSuccess, ErrorBean errorBean) {
        hideLoading(isSuccess,errorBean);
    }

    @Override
    public void showEmptyPage() {
        showEmptyContent();
    }

}
