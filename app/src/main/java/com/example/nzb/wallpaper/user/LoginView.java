package com.example.nzb.wallpaper.user;

import com.example.nzb.wallpaper.bmob.User;

/**
 * Created by NZB on 2018/3/30.
 */

public interface LoginView {

    public void setUsernameError();
    public void setPasswordError();

    public void fail();
    public void success(User user);
}
