package com.example.nzb.wallpaper.fragments;


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

import com.example.nzb.wallpaper.MainActivity;
import com.example.nzb.wallpaper.R;
import com.example.nzb.wallpaper.bmob.Category;
import com.example.nzb.wallpaper.category.CategoryPresenter;
import com.example.nzb.wallpaper.category.CategoryPresenterImpl;
import com.example.nzb.wallpaper.category.CategoryView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NZB on 2018/3/31.
 */

public class CatFragment extends Fragment implements CategoryView {

    CategoryPresenter presenter;
    List<Category> list;
    GridView gridView;
    MyAdapter myAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CategoryPresenterImpl(this);
        presenter.getCategory();
        list = new ArrayList<>();
        myAdapter = new MyAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cat,container,false);
        gridView = (GridView) view;
        gridView.setAdapter(myAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Category c = list.get(i);
                String cid = c.getObjectId();

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.viewPager.setCurrentItem(0);
                mainActivity.controller.setSelect(0);

                HomeFragment homeFragment = (HomeFragment) mainActivity.fragmentList.get(0);
                homeFragment.update(cid);



            }
        });


        return view;
    }

    class MyAdapter extends BaseAdapter{

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
            if(view==null){
                myView = getActivity().getLayoutInflater().inflate(R.layout.cat_gridview_item,null);
            }else{
                myView = view;
            }

            ImageView iv = (ImageView) myView.findViewById(R.id.imageview);
            TextView tv = (TextView) myView.findViewById(R.id.textview);

            Category c = list.get(i);

            tv.setText(c.getName());

            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

            String url = c.getCover().getFileUrl();

            Picasso.with(getActivity()).load(url).into(iv);

            return myView;
        }
        }

    @Override
    public void setCategory(List<Category> list) {
        this.list = list;
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void setFail() {
        Toast.makeText(getActivity(), "加载失败！", Toast.LENGTH_SHORT).show();
    }
}
