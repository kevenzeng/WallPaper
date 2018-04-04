package com.example.nzb.wallpaper.wallpaper;

import com.example.nzb.wallpaper.bmob.WallPaper;

import java.util.List;

/**
 * Created by NZB on 2018/3/31.
 */

public interface WallpaperDao {

    interface WallpaperListener{
        public void onSuccess(List<WallPaper> list);
        public void onFail();
    }

    public void queryWallpaper(String cid,WallpaperListener listener);
}
