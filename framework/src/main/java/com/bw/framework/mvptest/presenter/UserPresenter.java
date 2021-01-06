package com.bw.framework.mvptest.presenter;

import com.bw.framework.mvptest.control.Control;
import com.bw.framework.mvptest.repository.UserRepository;

public class UserPresenter extends Control.userControlPresenter {

    public UserPresenter(Control.userControlView userControlView) {
        super(userControlView);
    }

    @Override
    protected void createRepository() {
          mRepository=new UserRepository();
    }
}
