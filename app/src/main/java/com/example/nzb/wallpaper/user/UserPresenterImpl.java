package com.example.nzb.wallpaper.user;

import com.example.nzb.wallpaper.bmob.User;

/**
 * Created by NZB on 2018/3/30.
 */

public class UserPresenterImpl implements UserPresenter,UserDao.LoginListener{

    LoginView loginView;
    UserDao dao;

    public UserPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        dao = new UserDaoImpl();
    }

    @Override
    public void login(String username, String pwd) {
        dao.login(username,pwd,this);
    }

    @Override
    public void onUsernameError() {
        loginView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
    }

    @Override
    public void onSuccess(User user) {
        loginView.success(user);
    }

    @Override
    public void onFail() {
        loginView.fail();
    }
}
