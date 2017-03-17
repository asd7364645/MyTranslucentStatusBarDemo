package com.alexleo.mytranslucentstatusbardemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;


public class WangYiMusicDemo extends AppCompatActivity {
    private static final int FAKE_TRANSLUCENT_VIEW_ID = R.id.translucent_view;
    private Toolbar wang_yi_toolbar;
    private DrawerLayout wang_yi_drawer;

    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang_yi_music_demo);


        wang_yi_toolbar = (Toolbar) findViewById(R.id.wang_yi_toolbar);
        wang_yi_drawer = (DrawerLayout) findViewById(R.id.wang_yi_drawer);

        toggle = new ActionBarDrawerToggle(this, wang_yi_drawer, wang_yi_toolbar, R.string.OPEN, R.string.CLOSE);
        wang_yi_drawer.setDrawerListener(toggle);
        toggle.syncState();

        setStatusColorAndCAlphaForDrawer(this, wang_yi_drawer, wang_yi_toolbar, 0x000000, 0);

    }

    public static void setStatusColorAndCAlphaForDrawer(Activity activity, DrawerLayout drawerLayout, View topView, @ColorInt int color, int statusBarAlpha) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            drawerLayout.setFitsSystemWindows(true);
            drawerLayout.setClipToPadding(false);
        }
        setStatusColorAndCAlpha(activity, topView, color, statusBarAlpha);
    }

    /**
     * 顶部控件设置statusbar高度的padding版本
     * 设置状态栏颜色和那个颜色的透明度
     *
     * @param activity
     * @param topView
     * @param color
     * @param statusBarAlpha
     */
    public static void setStatusColorAndCAlpha(Activity activity, View topView, @ColorInt int color, int statusBarAlpha) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().setStatusBarColor(Color.argb(statusBarAlpha, 0, 0, 0));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //Android 4.4 statusBar半透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setARGBStatusViewToAct(activity, color, statusBarAlpha);
        }
        topView.setPadding(topView.getPaddingLeft(), topView.getPaddingTop() + getStatusBarHeight(activity), topView.getPaddingRight(), topView.getPaddingBottom());
//        topView.setFitsSystemWindows(true);
    }


    private static void setARGBStatusViewToAct(Activity activity, @ColorInt int color, int statusBarAlpha) {

        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);

        ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
        View fakeStatusBarView = contentView.findViewById(FAKE_TRANSLUCENT_VIEW_ID);
        if (fakeStatusBarView != null) {
            if (fakeStatusBarView.getVisibility() == View.GONE) {
                fakeStatusBarView.setVisibility(View.VISIBLE);
            }
            fakeStatusBarView.setBackgroundColor(Color.argb(statusBarAlpha, r, g, b));
        } else {
            contentView.addView(createARGBStatusBarView(activity, r, g, b, statusBarAlpha));
        }
    }

    private static View createARGBStatusBarView(Activity activity, int r, int g, int b, int alpha) {
        // 绘制一个和状态栏一样高的矩形
        View statusBarView = new View(activity);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(Color.argb(alpha, r, g, b));
        statusBarView.setId(FAKE_TRANSLUCENT_VIEW_ID);
        return statusBarView;
    }

    private static int getStatusBarHeight(Activity activity) {
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return activity.getResources().getDimensionPixelSize(resourceId);
    }

}
