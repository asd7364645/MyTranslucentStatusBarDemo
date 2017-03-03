package com.alexleo.mytranslucentstatusbardemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by Alex on 2017/3/2.
 * Alex
 */

public class AlexStatusBarUtils {

    private static final int FAKE_TRANSLUCENT_VIEW_ID = R.id.status_view;

    /**
     * 设置状态栏颜色
     * @param activity
     * @param color
     * @param statusBarAlpha
     */
    public static void setStatusColor(Activity activity, @ColorInt int color, int statusBarAlpha) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().setStatusBarColor(calculateStatusColor(color, statusBarAlpha));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setStatusViewToAct(activity, color, statusBarAlpha);
            setRootView(activity);
        }
    }
    /**
     * 设置状态栏透明，设置透明度
     * @param activity
     * @param statusBarAlpha
     */
    public static void setStatusColor(Activity activity, int statusBarAlpha) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().setStatusBarColor(Color.argb(statusBarAlpha,0,0,0));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setTranslucentStatusViewToAct(activity,statusBarAlpha);
        }
    }


    /**
     * 隐藏statusView
     * @param activity
     */
    public static void hideStatusView(Activity activity){
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        View fakeStatusBarView = decorView.findViewById(FAKE_TRANSLUCENT_VIEW_ID);
        if (fakeStatusBarView != null) {
            fakeStatusBarView.setVisibility(View.GONE);
        }
    }

    /**
     * 设置ImageView为第一控件的全透明状态栏
     * 注意：需要在下方的控件例如:ToolBar设置android:fitsSystemWindows="true"属性
     *      否则toolbar会被挤到上边
     * @param activity
     */
    public static void setImageViewTransparent(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().setStatusBarColor(Color.argb(0,0,0,0));
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setTranslucentStatusViewToAct(activity,0);
        }
    }
    /**
     * 设置ImageView为第一控件的可以调整透明度的状态栏
     * 注意：需要在下方的控件例如:ToolBar设置android:fitsSystemWindows="true"属性
     *      否则toolbar会被挤到上边
     * @param activity
     */
    public static void setImageViewTranslucent(Activity activity,int alpha){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().setStatusBarColor(Color.argb(alpha,0,0,0));
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setTranslucentStatusViewToAct(activity,alpha);
        }
    }

    /**
     * 设置状态栏view的颜色，如果找到状态栏view则直接设置，否则创建一个再设置
     * @param activity
     * @param color
     * @param statusBarAlpha
     */
    private static void setStatusViewToAct(Activity activity, @ColorInt int color, int statusBarAlpha) {
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        View fakeStatusBarView = decorView.findViewById(FAKE_TRANSLUCENT_VIEW_ID);
        if (fakeStatusBarView != null) {
            if (fakeStatusBarView.getVisibility() == View.GONE) {
                fakeStatusBarView.setVisibility(View.VISIBLE);
            }
            fakeStatusBarView.setBackgroundColor(calculateStatusColor(color, statusBarAlpha));
        } else {
            decorView.addView(createStatusBarView(activity, color, statusBarAlpha));
        }
    }
    /**
     * 设置状态栏view的颜色，如果找到状态栏view则直接设置，否则创建一个再设置
     * @param activity
     * @param statusBarAlpha
     */
    private static void setTranslucentStatusViewToAct(Activity activity, int statusBarAlpha) {
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        View fakeStatusBarView = decorView.findViewById(FAKE_TRANSLUCENT_VIEW_ID);
        if (fakeStatusBarView != null) {
            if (fakeStatusBarView.getVisibility() == View.GONE) {
                fakeStatusBarView.setVisibility(View.VISIBLE);
            }
            fakeStatusBarView.setBackgroundColor(Color.argb(statusBarAlpha,0,0,0));
        } else {
            decorView.addView(createTranslucentStatusBarView(activity,statusBarAlpha));
        }
    }

    /**
     * 创建和状态栏一样高的矩形，用于改变状态栏颜色和透明度
     * @param activity
     * @param color
     * @param alpha
     * @return
     */
    private static View createStatusBarView(Activity activity, @ColorInt int color, int alpha) {
        // 绘制一个和状态栏一样高的矩形
        View statusBarView = new View(activity);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(calculateStatusColor(color,alpha));
        statusBarView.setId(FAKE_TRANSLUCENT_VIEW_ID);
        return statusBarView;
    }
    /**
     * 创建和状态栏一样高的矩形，用于改变状态栏颜色和透明度
     * @param activity
     * @param alpha
     * @return
     */
    private static View createTranslucentStatusBarView(Activity activity, int alpha) {
        // 绘制一个和状态栏一样高的矩形
        View statusBarView = new View(activity);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(Color.argb(alpha,0,0,0));
        statusBarView.setId(FAKE_TRANSLUCENT_VIEW_ID);
        return statusBarView;
    }

    /**
     * 得到statusbar高度
     *
     * @param activity
     * @return
     */
    private static int getStatusBarHeight(Activity activity) {
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return activity.getResources().getDimensionPixelSize(resourceId);
    }

    /**
     * 计算状态栏颜色
     *
     * @param color color值
     * @param alpha alpha值
     * @return 最终的状态栏颜色
     */
    private static int calculateStatusColor(@ColorInt int color, int alpha) {
        if (alpha == 0) {
            return color;
        }
        float a = 1 - alpha / 255f;
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color & 0xff;
        red = (int) (red * a + 0.5);
        green = (int) (green * a + 0.5);
        blue = (int) (blue * a + 0.5);
        return 0xff << 24 | red << 16 | green << 8 | blue;
    }

    /**
     * 配置状态栏之下的View
     * @param activity
     */
    public static void setRootView(Activity activity) {
        ViewGroup parent = (ViewGroup) activity.findViewById(android.R.id.content);
//        for (int i = 0 ,count = parent.getChildCount();i<count;i++){
            View childView = parent.getChildAt(0);
//            if (childView instanceof ViewGroup){
                childView.setFitsSystemWindows(true);
                ((ViewGroup) childView).setClipToPadding(true);
//            }
//        }
    }
}
