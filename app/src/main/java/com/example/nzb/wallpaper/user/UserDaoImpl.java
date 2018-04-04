package com.example.nzb.wallpaper.user;

import android.text.TextUtils;

import com.example.nzb.wallpaper.bmob.User;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by NZB on 2018/3/30.
 */

public class UserDaoImpl implements UserDao {
    @Override
    public void login(String username, String password, final LoginListener loginListener) {
        if (TextUtils.isEmpty(username)){
            loginListener.onUsernameError();
        }

        if (TextUtils.isEmpty(password)){
            loginListener.onPasswordError();
        }


        BmobQuery<User> query = new BmobQuery<>("User");
        query.addWhereEqualTo("name",username);
        query.addWhereEqualTo("pwd",password);

        query.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (e == null){
                    if (list != null&&list.size()>0){
                        loginListener.onSuccess(list.get(0));
                    }
                }else{
                    loginListener.onFail();
                }
            }
        });

    }
}
