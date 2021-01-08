package com.example.sevenlandh.contract;

import com.example.freamwork.mvp.BasePresenter;
import com.example.freamwork.mvp.IView;

public class BringContract {
    public interface BringView extends IView{

    }
    public static abstract class BringPresenter extends BasePresenter<BringContract.BringView>{

    }
}
