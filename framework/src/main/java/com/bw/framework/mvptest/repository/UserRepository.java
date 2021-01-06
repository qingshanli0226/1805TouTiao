package com.bw.framework.mvptest.repository;

import com.bw.framework.mvptest.control.Control;
import com.bw.framework.mvptest.model.UserModel;

public class UserRepository extends Control.userControlRepository {


    @Override
    protected void createModel() {
          mModel=new UserModel();
    }
}
