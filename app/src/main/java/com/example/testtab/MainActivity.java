package com.example.testtab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.example.testtab.model.TabItem;
import com.example.testtab.ui.adapter.TabHostAdapter;
import com.example.testtab.ui.fragment.FirstPager;
import com.example.testtab.ui.fragment.FocusPager;
import com.example.testtab.ui.fragment.SettingPager;
import com.example.testtab.ui.fragment.VideoPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
    }
    public List<TabItem>  initTabItems(){
        List<TabItem> tabItems = new ArrayList<>();
        tabItems.add(new TabItem(MainActivity.this,"首页",R.color.colorPrimary,R.color.colorAccent,R.mipmap.ic_launcher,R.mipmap.ic_launcher, FirstPager.class));
        tabItems.add(new TabItem(MainActivity.this,"视频",R.color.colorPrimary,R.color.colorAccent,R.mipmap.ic_launcher,R.mipmap.ic_launcher, VideoPager.class));
        tabItems.add(new TabItem(MainActivity.this,"关注",R.color.colorPrimary,R.color.colorAccent,R.mipmap.ic_launcher,R.mipmap.ic_launcher, FocusPager.class));
        tabItems.add(new TabItem(MainActivity.this,"未登录",R.color.colorPrimary,R.color.colorAccent,R.mipmap.ic_launcher,R.mipmap.ic_launcher, SettingPager.class));
        return tabItems;
    }

    public void initFragments(){
        List<TabItem> tabItems = initTabItems();
        FragmentTabHost mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);
        mTabHost.getTabWidget().setBackgroundColor(Color.WHITE);//设置背景颜色
        mTabHost.getTabWidget().setDividerDrawable(null);//设置分割线
        final TabHostAdapter tabHostAdapter = new TabHostAdapter(MainActivity.this,mTabHost,tabItems);
        tabHostAdapter.notifyTabItemChange();
        tabHostAdapter.setCheckedTabByPosition(0);
//        设置选择监听器
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                tabHostAdapter.setCheckedTabByTag(s);
            }
        });
    }

}
