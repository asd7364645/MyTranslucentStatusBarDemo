package com.alexleo.mytranslucentstatusbardemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

public class TransparentImgAct extends AppCompatActivity {
private Toolbar transparent_img_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent_img);
//        transparent_img_toolbar = (Toolbar) findViewById(R.id.transparent_img_toolbar);
//        setSupportActionBar(transparent_img_toolbar);
        setTransparentStatus();

    }

    private void setTransparentStatus() {
        //判断版本号
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(0xff887676);
        }else if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        //得到根布局
        ViewGroup rootView = (ViewGroup) findViewById(android.R.id.content);
        for (int i = 0; i < rootView.getChildCount(); i++) {
            View child = rootView.getChildAt(i);
            if (child instanceof ImageView){
                child.setFitsSystemWindows(true);
            }
        }

    }
}
