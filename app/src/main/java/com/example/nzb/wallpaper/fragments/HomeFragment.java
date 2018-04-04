package com.example.nzb.wallpaper.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nzb.wallpaper.R;
import com.example.nzb.wallpaper.WallpaperDetailActivity;
import com.example.nzb.wallpaper.bmob.WallPaper;
import com.example.nzb.wallpaper.wallpaper.WallpaperPresenter;
import com.example.nzb.wallpaper.wallpaper.WallpaperPresenterImpl;
import com.example.nzb.wallpaper.wallpaper.WallpaperView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NZB on 2018/3/31.
 */

public class HomeFragment extends Fragment implements WallpaperView {

    GridView gridView;
    WallpaperPresenter presenter;

    List<WallPaper> list;
    ArrayList<String> urlList;
    myAdapter myAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        urlList = new ArrayList<>();
        presenter = new WallpaperPresenterImpl(this);
        update(null);

        myAdapter = new myAdapter();
    }

    public void update(String cid) {
        presenter.queryWallPaper(cid);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(myAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getActivity(), WallpaperDetailActivity.class);
                intent.putExtra("index",i);
                intent.putStringArrayListExtra("urlList",urlList);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void setWallpaper(List<WallPaper> list) {
        this.list = list;
        this.urlList.clear();
        for (WallPaper wp: list){
            urlList.add(wp.getWallpaper().getFileUrl());
        }

        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void setFail() {
        Toast.makeText(getActivity(), "查询失败！", Toast.LENGTH_SHORT).show();
    }

    class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
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
            if (view == null) {
                myView = getActivity().getLayoutInflater().inflate(R.layout.home_gridview_item, null);
            } else {
                myView = view;
            }

            ImageView iv = (ImageView) myView.findViewById(R.id.imageview);

            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            TextView tv1 = (TextView) myView.findViewById(R.id.textview1);

            WallPaper wp = list.get(i);

            String url = wp.getWallpaper().getFileUrl();
            String name = wp.getName();

            Picasso.with(getActivity()).load(url).into(iv);

            tv1.setText(name);


            return myView;
        }
    }


}







