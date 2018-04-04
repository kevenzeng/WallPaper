package com.example.nzb.wallpaper.category;

import com.example.nzb.wallpaper.bmob.Category;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by NZB on 2018/3/31.
 */

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public void queryCategory(final CategoryListener listener) {
        BmobQuery<Category> query = new BmobQuery<>("Category");
        query.findObjects(new FindListener<Category>() {
            @Override
            public void done(List<Category> list, BmobException e) {
                if (e == null){
                    listener.onSuccess(list);
                }else{
                    listener.onFail();
                }
            }
        });
    }
}
