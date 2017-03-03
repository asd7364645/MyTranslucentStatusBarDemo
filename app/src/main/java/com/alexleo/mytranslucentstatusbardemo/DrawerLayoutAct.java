package com.alexleo.mytranslucentstatusbardemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class DrawerLayoutAct extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout activity_drawer_layout;
    private Toolbar drawer_act_toolbar;
    private NavigationView drawer_act_nv_view;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        drawer_act_toolbar = (Toolbar) findViewById(R.id.drawer_act_toolbar);
        setSupportActionBar(drawer_act_toolbar);
        activity_drawer_layout = (DrawerLayout) findViewById(R.id.activity_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,activity_drawer_layout,drawer_act_toolbar,R.string.OPEN,R.string.CLOSE);
        activity_drawer_layout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        drawer_act_nv_view = (NavigationView) findViewById(R.id.drawer_act_nv_view);
        drawer_act_nv_view.setNavigationItemSelectedListener(this);

        AlexStatusBarUtils.setStatusColor(this,122);
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
