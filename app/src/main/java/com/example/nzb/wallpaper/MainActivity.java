package com.example.nzb.wallpaper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.nzb.wallpaper.bmob.User;
import com.example.nzb.wallpaper.fragments.CatFragment;
import com.example.nzb.wallpaper.fragments.HomeFragment;
import com.example.nzb.wallpaper.fragments.MyFragment;
import com.example.nzb.wallpaper.fragments.SettingFragment;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.TabItemBuild;
import me.majiajie.pagerbottomtabstrip.TabItemBuilder;
import me.majiajie.pagerbottomtabstrip.TabLayoutMode;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

public class MainActivity extends AppCompatActivity {

   /* public void query(View view){
        BmobQuery<User> query = new BmobQuery<>("User");
        query.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                for (User u:list){
                    Log.i("test",u.getName());
                }
            }
        });
    }*/

    PagerBottomTabLayout pagerBottomTabLayout;

   public ViewPager viewPager;

    public List<Fragment> fragmentList;

   public Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initFragments();

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
    }


    class FragmentAdapter extends FragmentPagerAdapter{

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    private void initFragments() {
        HomeFragment home = new HomeFragment();
        CatFragment cat = new CatFragment();
        MyFragment my = new MyFragment();
        SettingFragment setting = new SettingFragment();

        fragmentList = new ArrayList<>();
        fragmentList.add(home);
        fragmentList.add(cat);
        fragmentList.add(my);
        fragmentList.add(setting);

    }

    private void initViews() {

        viewPager = (ViewPager) findViewById(R.id.viewPager);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    controller.setSelect(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        pagerBottomTabLayout = (PagerBottomTabLayout) findViewById(R.id.tab);

        TabItemBuilder homeTab = (TabItemBuilder) new TabItemBuilder(this).create()
                .setSelectedColor(0xff00796b)
                .setDefaultIcon(R.drawable.wallpaperdd_tab_btn_homepage_normal)
                .setText("首页")
                .setTag("home")
                .build();

        TabItemBuilder catTab = (TabItemBuilder) new TabItemBuilder(this).create()
                .setSelectedColor(0xfff57c00)
                .setDefaultIcon(R.drawable.wallpaperdd_tab_btn_category_normal)
                .setText("分类")
                .setTag("cat")
                .build();

        TabItemBuilder myTab = (TabItemBuilder) new TabItemBuilder(this).create()
                .setSelectedColor(0xff607d8b)
                .setDefaultIcon(R.drawable.wallpaperdd_tab_btn_mypictures_normal)
                .setText("我的")
                .setTag("my")
                .build();

        TabItemBuilder settingTab = (TabItemBuilder) new TabItemBuilder(this).create()
                .setSelectedColor(0xfff35a4a)
                .setDefaultIcon(R.drawable.wallpaperdd_setting_icon_normal)
                .setText("设置")
                .setTag("setting")
                .build();


        controller= pagerBottomTabLayout.builder()
                .addTabItem(homeTab)
                .addTabItem(catTab)
                .addTabItem(myTab)
                .addTabItem(settingTab)
                .setMode(TabLayoutMode.HIDE_TEXT|TabLayoutMode.CHANGE_BACKGROUND_COLOR).build();

        controller.addTabItemClickListener(new OnTabItemSelectListener() {
            @Override
            public void onSelected(int index, Object tag) {
                viewPager.setCurrentItem(index);
            }

            @Override
            public void onRepeatClick(int index, Object tag) {

            }
        });
    }
}
