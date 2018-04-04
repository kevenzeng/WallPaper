package com.example.nzb.wallpaper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class WallpaperDetailActivity extends AppCompatActivity {

    Gallery gallery;
    MyAdapter myAdapter;
    List<String> urlList;
    int index;

    Toolbar toolbar;

    void setting() {
        String urlString = urlList.get(index);
        InputStream in = null;
        try {
            URL url = new URL(urlString);
            in = url.openStream();
            Bitmap bm = BitmapFactory.decodeStream(in);
            setWallpaper(bm);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"设置失败",Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this,"设置成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_detail);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.drawable.btn_back_pressed);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WallpaperDetailActivity.this.finish();
            }
        });

        toolbar.inflateMenu(R.menu.menu_toolbar);


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId()==R.id.setting) {
                    setting();
                }

                return true;
            }
        });

        gallery = (Gallery) findViewById(R.id.gallery);

        Intent intent = getIntent();
        urlList = intent.getStringArrayListExtra("urlList");

        myAdapter = new MyAdapter(this,urlList);

        index = intent.getIntExtra("index",0);

        gallery.setAdapter(myAdapter);
        gallery.setSelection(index);
    }

    class MyAdapter extends BaseAdapter{

        List<String> list;
        Context context;

        public MyAdapter(Context context, List<String> list){
            this.context = context;
            this.list = list;
        }

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
                myView = LayoutInflater.from(context).inflate(R.layout.gallery_item, null);
            }else{
                myView = view;
            }

            ImageView imageView = (ImageView) myView.findViewById(R.id.imageview);

            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

            DisplayMetrics dm = new DisplayMetrics();

            wm.getDefaultDisplay().getMetrics(dm);

            ViewGroup.LayoutParams params = imageView.getLayoutParams();

            params.width = dm.widthPixels;
            params.height = dm.heightPixels;

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);


            Picasso.with(context).load(list.get(i)).resize(params.width, params.height).centerCrop().into(imageView);


            return myView;
        }
    }
}
