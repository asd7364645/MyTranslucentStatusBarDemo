package com.alexleo.mytranslucentstatusbardemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * 先设置状态栏透明属性；
 * 给根布局加上一个和状态栏一样大小的矩形View（色块），添加到顶上；
 * 然后设置根布局的 FitsSystemWindows 属性为 true,此时根布局会延伸到状态栏，
 * 处在状态栏位置的就是之前添加的色块，这样就给状态栏设置上颜色了。
 */
public class PuTongToolBarTranslucent extends AppCompatActivity {

    private Toolbar pu_tong_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_tong_tool_bar_translucent);
        pu_tong_toolbar = (Toolbar) findViewById(R.id.pu_tong_toolbar);
        setSupportActionBar(pu_tong_toolbar);
        setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

    }

    private void setStatusBarColor(int color) {
        //判断版本，如果大于5.0
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //取消透明状态栏属性，因为5.0以上没必要了
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(color);
        }else if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            //设置window的透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //得到decorView
            ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
            //生成一个和状态栏大小一样的矩形区域（View）,然后添加到decorView中
            View statusView = createStatusView(color);
            decorView.addView(statusView);
            //得到根布局
            ViewGroup rootView = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }
    }

    private View createStatusView( int color) {
        View statusView = new View(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,getStatusBarHeight());
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }

    private int getStatusBarHeight() {
        //得到statusbar高度
        int resourceId = getResources().getIdentifier("status_bar_height","dimen","android");
        return getResources().getDimensionPixelSize(resourceId);
    }
}
