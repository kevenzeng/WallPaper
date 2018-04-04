package com.example.nzb.wallpaper.wallpaper;

import com.example.nzb.wallpaper.bmob.WallPaper;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by NZB on 2018/3/31.
 */

public class WallpaperDaoImpl implements WallpaperDao {
    @Override
    public void queryWallpaper(String cid, final WallpaperListener listener) {
        BmobQuery<WallPaper> query = new BmobQuery<>("WallPaper");

        if (cid != null){
            query.addWhereEqualTo("cid",cid);
        }


        query.findObjects(new FindListener<WallPaper>() {
            @Override
            public void done(List<WallPaper> list, BmobException e) {
                if (e == null){
                    listener.onSuccess(list);
                }else{
                    listener.onFail();
                }
            }
        });
    }
}
