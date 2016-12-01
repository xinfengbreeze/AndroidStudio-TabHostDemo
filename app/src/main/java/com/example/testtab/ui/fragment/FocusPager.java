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

public class FocusPager extends Fragment {
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
        String[] titles = new String[]{"数学","语文","英语","计算机","体育","美术","音乐","生物","物理","地理","历史","化学","政治"};
        fragmentInfoList = new ArrayList<>();
        tabItemViewHolders = new ArrayList<>();
        for(String t :titles){
            FragmentInfo info = new FragmentInfo(0,t);
            tabLayout.addTab(tabLayout.newTab().setCustomView(new TabItemViewHolder(getContext(),t,null).getTabView()));
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
    }

}
