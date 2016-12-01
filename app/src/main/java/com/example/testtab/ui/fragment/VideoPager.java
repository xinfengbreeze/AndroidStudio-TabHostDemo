package com.example.testtab.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testtab.R;
import com.example.testtab.model.FragmentInfo;
import com.example.testtab.model.TabItemViewHolder;
import com.example.testtab.ui.adapter.FragmentViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuankaifeng on 11/29/16.
 */

public class VideoPager extends Fragment {
    private View  rootView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<FragmentInfo> fragmentInfoList;
    private List<TabItemViewHolder> tabItemViewHolders;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return initView();
    }

    public View initView(){
        if(rootView == null){
            rootView = View.inflate(getActivity(), R.layout.fragment_first_pager,null);
            tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout_title);
            viewPager = (ViewPager) rootView.findViewById(R.id.view_pager_content);
            initViewPager();
        }else{
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if(parent != null){//防止已经被添加过父view了，但是一般不会的
                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    public  List<FragmentInfo>  initFragmentInfo(){
        String[] titles = new String[]{"电子","人文","软件","文传","旅游","经管","体育"};
        fragmentInfoList = new ArrayList<>();
        tabItemViewHolders = new ArrayList<>();
        for(String t :titles){
            FragmentInfo info = new FragmentInfo(0,t);
            tabLayout.addTab(tabLayout.newTab().setCustomView(new TabItemViewHolder(getContext(),null,R.drawable.tab_icon_selector).getTabView()));
            fragmentInfoList.add(info);
        }
        return fragmentInfoList;
    }

    public void initViewPager(){
        initFragmentInfo();
        FragmentViewPagerAdapter pagerAdapter = new FragmentViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.setFragmentInfo(fragmentInfoList);
        viewPager.setAdapter(pagerAdapter);
        //        tabLayout.setupWithViewPager(viewPager);这个不建议使用了 他只能从Pager中获取title
        //通过相互添加监听器来进行互动-----关键
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                Log.i("SSS","tab选中");
//                //当tab被选中的时候调用，tab是这次被选中的那个tab
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                Log.i("SSS","tab未选中");
//                //当tab被选中的时候调用，在onTabSelected之前调用  tab是 选择前 被选中的tab
////                tab.getText();
////                tab.getIcon();
////                tab.getPosition();
////                tab.getCustomView();
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                Log.i("SSS","tab再次选中");
//                //tab 选择的是同一个tab的时候调用，其他两个方法不回调
//            }
//        });
    }
}
