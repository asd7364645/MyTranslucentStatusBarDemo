package com.alexleo.mytranslucentstatusbardemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

/**
 *
 * 薄荷透明状态栏解决方案：
 *
 * 这种方法适用于只有toolbar的时候，
 * 需要的条件：1.需要在values中的dimens添加<dimen name="bohe_toolbar_padding_top">0dp</dimen>
 *              values-v19中的dimens添加<dimen name="bohe_toolbar_padding_top">25dp</dimen>
 *            2. toolbar需要设置android:layout_height="wrap_content"
 *              android:minHeight="?android:actionBarSize"
 *              android:paddingTop="@dimen/bohe_toolbar_padding_top"
 *            3.代码中需要设置
 *          private void initStatusBar() {
                //设置状态栏透明
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
                    localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
                }
 */
public class BoHeTranslucent extends AppCompatActivity {

    private Toolbar bohe_toolbar;
    private DrawerLayout activity_bo_he_translucent;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bo_he_translucent);
        initStatusBar();
        initToolBar();
        activity_bo_he_translucent = (DrawerLayout) findViewById(R.id.activity_bo_he_translucent);
        toggle = new ActionBarDrawerToggle(this, activity_bo_he_translucent, bohe_toolbar, R.string.OPEN, R.string.CLOSE);
        activity_bo_he_translucent.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initToolBar() {
        bohe_toolbar = (Toolbar) findViewById(R.id.bohe_toolbar);
        if (bohe_toolbar != null) {
            setSupportActionBar(bohe_toolbar);
        }
    }

    private void initStatusBar() {
        //设置状态栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

    }
}
