package com.example.testtab;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class CollapsingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        View view = findViewById(R.id.bottom_sheet);
        final BottomSheetBehavior bottomSheetBehavior =  BottomSheetBehavior.from(view);
        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ykf","float click---"+bottomSheetBehavior.getState());
                if(bottomSheetBehavior.getState() !=  BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    Log.i("ykf","float click1");
                }else{
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                    Log.i("ykf","float click2");
                }
            }
        });
    }
}
