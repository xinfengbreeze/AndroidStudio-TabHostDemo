package com.example.testtab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.example.testtab.model.TabItemViewHolder;
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
    public List<TabItemViewHolder>  initTabItems(){
        List<TabItemViewHolder> tabItems = new ArrayList<>();
        tabItems.add(new TabItemViewHolder(MainActivity.this,"首页",R.drawable.tab_icon_selector, FirstPager.class));
        tabItems.add(new TabItemViewHolder(MainActivity.this,"视频",R.drawable.tab_icon_selector, VideoPager.class));
        tabItems.add(new TabItemViewHolder(MainActivity.this,"关注",R.drawable.tab_icon_selector, FocusPager.class));
        tabItems.add(new TabItemViewHolder(MainActivity.this,"未登录",R.drawable.tab_icon_selector, SettingPager.class));
        return tabItems;
    }

    public void initFragments(){
        List<TabItemViewHolder> tabItems = initTabItems();
        FragmentTabHost mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);
        mTabHost.getTabWidget().setBackgroundColor(Color.WHITE);//设置背景颜色
        mTabHost.getTabWidget().setDividerDrawable(null);//设置分割线
        //设置自定义的adapter
        final TabHostAdapter tabHostAdapter = new TabHostAdapter(MainActivity.this,mTabHost,tabItems);
        tabHostAdapter.notifyTabItemChange();
        tabHostAdapter.setSelectedTabByPosition(0);
//        设置选择监听器
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                tabHostAdapter.setSelectedTabByTag(s);
            }
        });
    }

}
