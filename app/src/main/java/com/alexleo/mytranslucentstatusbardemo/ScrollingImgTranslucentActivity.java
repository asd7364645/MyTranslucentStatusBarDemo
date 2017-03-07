package com.alexleo.mytranslucentstatusbardemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class ScrollingImgTranslucentActivity extends AppCompatActivity {

    private CoordinatorLayout scroll_coorlayout;
    private AppBarLayout app_bar;
    private ImageView scroll_img;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_img_translucent);
        app_bar = (AppBarLayout) findViewById(R.id.app_bar);
        scroll_coorlayout = (CoordinatorLayout) findViewById(R.id.scroll_coorlayout);
        scroll_img = (ImageView) findViewById(R.id.scroll_img);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        AlexStatusBarUtils.setCollapsingToolbar(this,scroll_coorlayout,app_bar,scroll_img,toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
