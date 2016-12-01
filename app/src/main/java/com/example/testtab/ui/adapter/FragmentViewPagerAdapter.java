package com.example.testtab.ui.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.testtab.model.FragmentInfo;
import com.example.testtab.ui.fragment.ContentPager;

import java.util.List;

/**
 * Created by langchou on 11/30/16.
 */

public class FragmentViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> fragmentInfoList;

    public FragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragmentInfo(List<FragmentInfo> fragmentInfoList){
        this.fragmentInfoList = fragmentInfoList;
    }
    @Override
    public ContentPager getItem(int position) {
        if(fragmentInfoList == null || position >= fragmentInfoList.size()){
            return null;
        }
        return new ContentPager().setBaseInfo(fragmentInfoList.get(position));
    }

    @Override
    public int getCount() {
        if(fragmentInfoList == null){
            return 0;
        }
        return fragmentInfoList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentInfoList.get(position).getTitle();
    }
}
