package com.example.nzb.wallpaper.wallpaper;

import com.example.nzb.wallpaper.bmob.WallPaper;

import java.util.List;

/**
 * Created by NZB on 2018/3/31.
 */

public class WallpaperPresenterImpl implements WallpaperPresenter,WallpaperDao.WallpaperListener {

    WallpaperView wallpaperView;
    WallpaperDao dao;

    public WallpaperPresenterImpl(WallpaperView wallpaperView) {
        this.wallpaperView = wallpaperView;
        dao = new WallpaperDaoImpl();
    }

    @Override
    public void queryWallPaper(String cid) {
        dao.queryWallpaper(cid,this);
    }

    @Override
    public void onSuccess(List<WallPaper> list) {
        wallpaperView.setWallpaper(list);
    }

    @Override
    public void onFail() {
        wallpaperView.setFail();
    }
}
