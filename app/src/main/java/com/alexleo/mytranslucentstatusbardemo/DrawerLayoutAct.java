package com.alexleo.mytranslucentstatusbardemo;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.SeekBar;

public class DrawerLayoutAct extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout activity_drawer_layout;
    private CoordinatorLayout drawer_act_coordinator;
    private Toolbar drawer_act_toolbar;
    private NavigationView drawer_act_nv_view;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private SeekBar drawer_act_seek;
    private TabLayout drawer_act_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        drawer_act_toolbar = (Toolbar) findViewById(R.id.drawer_act_toolbar);
        drawer_act_tab = (TabLayout) findViewById(R.id.drawer_act_tab);
        activity_drawer_layout = (DrawerLayout) findViewById(R.id.activity_drawer_layout);
        drawer_act_seek = (SeekBar) findViewById(R.id.drawer_act_seek);
        drawer_act_nv_view = (NavigationView) findViewById(R.id.drawer_act_nv_view);
        drawer_act_coordinator = (CoordinatorLayout) findViewById(R.id.drawer_act_coordinator);

        setSupportActionBar(drawer_act_toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, activity_drawer_layout, drawer_act_toolbar, R.string.OPEN, R.string.CLOSE);
        activity_drawer_layout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        drawer_act_nv_view.setNavigationItemSelectedListener(this);

        AlexStatusBarUtils.setDrawerStatusAlpha(this,0);
//        AlexStatusBarUtils.setDrawerStatusColor(this,drawer_act_coordinator);
//        AlexStatusBarUtils.setDrawerStatusColor(this,activity_drawer_layout,getResources().getColor(R.color.colorAccent),0);
        drawer_act_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                AlexStatusBarUtils.setDrawerStatusAlpha(DrawerLayoutAct.this,progress);
//                AlexStatusBarUtils.setDrawerStatusColor(DrawerLayoutAct.this,drawer_act_coordinator);
//                AlexStatusBarUtils.setDrawerStatusColor(DrawerLayoutAct.this,activity_drawer_layout,getResources().getColor(R.color.colorAccent),progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        drawer_act_tab.addTab(drawer_act_tab.newTab().setText("one"));
        drawer_act_tab.addTab(drawer_act_tab.newTab().setText("two"));
        drawer_act_tab.addTab(drawer_act_tab.newTab().setText("three"));
        drawer_act_tab.addTab(drawer_act_tab.newTab().setText("four"));
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        return true;
    }
}
