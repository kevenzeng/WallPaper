package com.example.nzb.wallpaper.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nzb.wallpaper.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NZB on 2018/3/31.
 */


public class SettingFragment extends Fragment {

    static class Item{
        int rid;
        String name;

        public Item(int rid,String name){
            this.rid = rid;
            this.name = name;
        }
    }

    static List<Item> ITEMS = new ArrayList<>();

    static {
        Item item1 = new Item(R.drawable.wallpaperdd_icon_auto_setting, "自动设置壁纸");
        Item item2 = new Item(R.drawable.wallpaperdd_icon_ddlock_settings, "锁屏设置");
        Item item3 = new Item(R.drawable.wallpaperdd_icon_menu_clear_cache, "清除缓存");
        Item item4 = new Item(R.drawable.wallpaperdd_icon_menu_upload, "我要上传");
        Item item5 = new Item(R.drawable.wallpaperdd_icon_praise, "五星评价");
        Item item6 = new Item(R.drawable.wallpaperdd_icon_menu_feedback, "反馈");
        Item item7 = new Item(R.drawable.wallpaperdd_icon_menu_aboutinfo, "帮助关于");


        ITEMS.add(item1);
        ITEMS.add(item2);
        ITEMS.add(item3);
        ITEMS.add(item4);
        ITEMS.add(item5);
        ITEMS.add(item6);
        ITEMS.add(item7);

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ITEMS.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myView;
            if(view==null){
                myView = getActivity().getLayoutInflater().inflate(R.layout.listview_item, null);
            }else{
                myView = view;
            }

            ImageView iv = (ImageView) myView.findViewById(R.id.imageview);
            TextView tv = (TextView) myView.findViewById(R.id.textview);

            Item item = ITEMS.get(i);

            iv.setImageResource(item.rid);
            tv.setText(item.name);

            return myView;
        }
    }

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting,container,false);
        listView = (ListView) view;

        listView.setAdapter(new MyAdapter());
        return listView;
    }
}
