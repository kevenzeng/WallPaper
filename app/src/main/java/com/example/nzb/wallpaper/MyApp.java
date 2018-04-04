package com.example.nzb.wallpaper;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by NZB on 2018/3/30.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Bmob.initialize(this,"ea0f18cc86e30cc608eac4638ac62167");
    }
}
