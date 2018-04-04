package com.example.nzb.wallpaper.bmob;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by geek99.com on 2016/8/1.
 */
public class WallPaper extends BmobObject {

    String name;
    String cid;
    BmobFile wallpaper;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public BmobFile getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(BmobFile wallpaper) {
        this.wallpaper = wallpaper;
    }
}
