package com.example.nzb.wallpaper.wallpaper;
import com.example.nzb.wallpaper.bmob.WallPaper;

import java.util.List;

/**
 * Created by NZB on 2018/3/31.
 */

public interface WallpaperView {

    public void setWallpaper(List<WallPaper> list);
    public void setFail();
}
