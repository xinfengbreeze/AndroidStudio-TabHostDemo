package com.example.testtab.model;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testtab.R;

/**
 * Created by yuankaifeng on 11/29/16.
 */

public class TabItem {
    private Context context;
    private String title;//tab的标题
    private int iconNormalId;//tab未选中的图片
    private int iconPressId;//tab选中时的图片
    private Class<? extends Fragment> fragmentClass;//对应的fragment的class
    private int colorNormalId;//文字未选中时的颜色
    private int colorPressId;//文字选中时候的颜色

    private View iconView;//icon的view
    private TextView tvTitle;
    private ImageView imageView;
    public TabItem(){

    }
    public TabItem(Context context, String title, int colorNormalId, int colorPressId, int iconNormalId, int iconPressId, Class<? extends Fragment> fragmentClass){
        this.context = context;
        this.title = title;
        this.colorNormalId = colorNormalId;
        this.colorPressId = colorPressId;
        this.iconNormalId = iconNormalId;
        this.iconPressId = iconPressId;
        this.fragmentClass = fragmentClass;
    }

    public String getTitle() {
        return title == null ? "":title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconNormalId() {
        return iconNormalId;
    }

    public void setIconNormalId(int iconNormalId) {
        this.iconNormalId = iconNormalId;
    }

    public int getIconPressId() {
        return iconPressId;
    }

    public void setIconPressId(int iconPressId) {
        this.iconPressId = iconPressId;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class<? extends Fragment> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }

    public int getColorNormalId() {
        return colorNormalId;
    }

    public void setColorNormalId(int colorNormalId) {
        this.colorNormalId = colorNormalId;
    }

    public int getColorPressId() {
        return colorPressId;
    }

    public void setColorPressId(int colorPress) {
        this.colorPressId = colorPress;
    }

    public View getTabView(){
        if(iconView == null){
            iconView =   View.inflate(context, R.layout.tabview_layout,null);
            tvTitle = (TextView) iconView.findViewById(R.id.title);
            imageView = (ImageView) iconView.findViewById(R.id.icon);
        }
        if(TextUtils.isEmpty(title)){
            tvTitle.setVisibility(View.GONE);
        }else{
            tvTitle.setText(title);
            if(colorNormalId >0){
                tvTitle.setTextColor(context.getResources().getColor(colorNormalId));
            }
        }

        if(iconNormalId > 0 ){
            imageView.setImageDrawable(context.getResources().getDrawable(iconNormalId));
        }else{
            imageView.setVisibility(View.GONE);
        }
        return iconView;
    }

    public void setChecked(boolean flag){
        if(iconView !=null){
            if(flag){
                if(colorPressId >0){
                    tvTitle.setTextColor(context.getResources().getColor(colorPressId));
                }
                if(iconPressId > 0 ){
                    imageView.setImageResource(iconPressId);
                }
            }else{
                if(colorNormalId >0){
                    tvTitle.setTextColor(context.getResources().getColor(colorNormalId));
                }
                if(iconNormalId > 0 ){
                    imageView.setImageResource(iconNormalId);
                }
            }
        }
    }
}
