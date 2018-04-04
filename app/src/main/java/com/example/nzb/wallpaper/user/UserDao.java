package com.example.nzb.wallpaper.user;

import com.example.nzb.wallpaper.bmob.User;

/**
 * Created by NZB on 2018/3/30.
 */

public interface UserDao {

    interface LoginListener{

        void onUsernameError();
        void onPasswordError();

        void onSuccess(User user);
        void onFail();
    }

    public void login(String username,String password,LoginListener loginListener);

}
