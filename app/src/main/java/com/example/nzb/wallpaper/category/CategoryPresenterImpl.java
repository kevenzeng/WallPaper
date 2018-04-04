package com.example.nzb.wallpaper.category;

import com.example.nzb.wallpaper.bmob.Category;

import java.util.List;

/**
 * Created by NZB on 2018/3/31.
 */

public class CategoryPresenterImpl implements CategoryPresenter,CategoryDao.CategoryListener {
    CategoryView categoryView;
    CategoryDao dao;

    public CategoryPresenterImpl(CategoryView categoryView){
        this.categoryView = categoryView;
        dao = new CategoryDaoImpl();
    }

    @Override
    public void getCategory() {
        dao.queryCategory(this);
    }

    @Override
    public void onSuccess(List<Category> list) {
        categoryView.setCategory(list);
    }

    @Override
    public void onFail() {
        categoryView.setFail();
    }
}
