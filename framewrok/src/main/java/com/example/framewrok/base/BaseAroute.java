package com.example.framewrok.base;

public class BaseAroute<PView extends IView> implements IPrine<PView>  {
    public PView pView;
    @Override
    public void attach(PView pView) {
        this.pView=pView;
    }

    @Override
    public void onDestroy() {
             pView=null;
    }
}
