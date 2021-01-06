package com.example.framewrok.base;

public interface IPrine <PView extends IView> {
    void attach(PView pView);
    void onDestroy();
}
