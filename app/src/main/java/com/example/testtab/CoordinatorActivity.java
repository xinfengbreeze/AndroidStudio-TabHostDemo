package com.example.testtab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.example.testtab.model.TabItemViewHolder;

public class CoordinatorActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setCustomView(new TabItemViewHolder(this,"视频",R.drawable.tab_icon_selector).getTabView()));
        tabLayout.addTab(tabLayout.newTab().setCustomView(new TabItemViewHolder(this,"音乐",R.drawable.tab_icon_selector).getTabView()));
        tabLayout.addTab(tabLayout.newTab().setCustomView(new TabItemViewHolder(this,"美食",R.drawable.tab_icon_selector).getTabView()));
        tabLayout.addTab(tabLayout.newTab().setCustomView(new TabItemViewHolder(this,"游戏",R.drawable.tab_icon_selector).getTabView()));
    }
}
