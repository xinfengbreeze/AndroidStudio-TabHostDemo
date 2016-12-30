package com.example.testtab.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.testtab.CollapsingActivity;
import com.example.testtab.CoordinatorActivity;
import com.example.testtab.R;

/**
 * Created by yuankaifeng on 11/29/16.
 */

public class SettingPager extends Fragment {
    private View  rootView;
    private TextView tv;
    private Button btCoordinator;
    private Button btCollapsing;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    public View initView(){
        if(rootView == null){
            rootView = View.inflate(getActivity(), R.layout.fragment_setting_pager,null);
            btCoordinator = (Button) rootView.findViewById(R.id.bt_coordinatorLayout);
            btCollapsing = (Button) rootView.findViewById(R.id.bt_collapsingLayout);
            btCoordinator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getContext(),CoordinatorActivity.class));
                }
            });
            btCollapsing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getContext(),CollapsingActivity.class));
                }
            });
            tv = (TextView) rootView.findViewById(R.id.textView);
            tv.setText(this.getClass().getSimpleName());
        }else{
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if(parent != null){
                parent.removeView(rootView);
            }
            tv.setTextColor(Color.BLUE);
        }
        return rootView;
    }


}
