package com.example.nzb.wallpaper.category;

import com.example.nzb.wallpaper.bmob.Category;

import java.util.List;

/**
 * Created by NZB on 2018/3/31.
 */

public interface CategoryView {

    public void setCategory(List<Category> list);
    public void setFail();
}
