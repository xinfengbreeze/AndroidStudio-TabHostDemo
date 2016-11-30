package com.example.testtab.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentTabHost;
import android.widget.TabHost;

import com.example.testtab.R;
import com.example.testtab.model.TabItem;

import java.util.List;

/**
 * Created by langchou on 11/29/16.
 */

public class TabHostAdapter {
    private List<TabItem> tabItems;
    private FragmentTabHost fragmentTabHost;
    private Context context;
    private int checkedPosition;
    public TabHostAdapter(Context context,FragmentTabHost fragmentTabHost, List<TabItem> tabItems){
        this.context = context;
        this.fragmentTabHost = fragmentTabHost;
        this.tabItems = tabItems;
    }

    public int  getCount(){
        if(tabItems == null){
            return 0 ;
        }
        return tabItems.size();
    }

    public TabItem getTabItem(int position){
        if(tabItems == null || position >= tabItems.size()){
            return null;
        }
        return tabItems.get(position);
    }

    public void notifyTabItemChange(){
        if(getCount() == 0 ||fragmentTabHost == null ||context == null ){
            return;
        }
        for(int i =0 ;i<tabItems.size();i++){
            if(getTabItem(i) == null){
                continue;
            }

            if(getTabItem(i).getFragmentClass() == null){
                continue;
            }

            //设置tabSpec的tag   和view    tag = i
            String tag = i + "";
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tag).setIndicator(getTabItem(i).getTabView());
            //添加fragment的class 所有的fragment对象一开始都被创建了,而且只创建一次,但是每次选择都会走onCreateView方法。
            fragmentTabHost.addTab(tabSpec,getTabItem(i).getFragmentClass(),null);
        }
    }

    public int getCheckedPosition(){
        return checkedPosition;
    }

    public void setCheckedTabByPosition(int index){
        setCheckedTabByTag(index+"");
    }
    public void setCheckedTabByTag(String tag){
        if(getCount() == 0 ||fragmentTabHost == null ||context == null ){
            return;
        }
        for(int i =0 ;i<tabItems.size();i++){
            if((i + "").equals(tag)){
                getTabItem(i).setChecked(true);
                checkedPosition = i;
            }else{
                getTabItem(i).setChecked(false);
            }
        }
    }
}
