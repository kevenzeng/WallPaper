package com.example.nzb.wallpaper.bmob;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by geek99.com on 2016/8/1.
 */
public class Category extends BmobObject {

    String name;
    BmobFile cover;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BmobFile getCover() {
        return cover;
    }

    public void setCover(BmobFile cover) {
        this.cover = cover;
    }
}
