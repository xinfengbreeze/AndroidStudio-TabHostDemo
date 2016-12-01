package com.example.testtab.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testtab.R;
import com.example.testtab.model.FragmentInfo;

/**
 * Created by yuankaifeng on 11/29/16.
 */

public class ContentPager extends Fragment {
    private View  rootView;
    private TextView tv;
    private FragmentInfo baseInfo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    public View initView(){
        if(rootView == null){
            rootView = View.inflate(getActivity(), R.layout.fragment_content_pager,null);
            tv = (TextView) rootView.findViewById(R.id.textView);
            tv.setText(this.getClass().getSimpleName()+"----"+baseInfo.getTitle());
        }else{
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if(parent != null){
                parent.removeView(rootView);
            }
            tv.setTextColor(Color.BLUE);
        }
        return rootView;
    }

    public ContentPager setBaseInfo(FragmentInfo baseInfo){
        this.baseInfo = baseInfo;
        return this;
    }

    public FragmentInfo getBaseInfo() {
        return baseInfo;
    }
}
