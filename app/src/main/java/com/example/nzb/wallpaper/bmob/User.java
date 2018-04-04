package com.example.nzb.wallpaper.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by geek99.com on 2016/8/1.
 */
public class User extends BmobObject {
    String name;
    String pwd;

    /*public User() {
        this.setTableName("UserTbl");
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
