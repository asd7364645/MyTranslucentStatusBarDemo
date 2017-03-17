package com.alexleo.mytranslucentstatusbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button main_go_bohe,main_go_scrollingimgtranslucent
            ,main_go_putongtoolbar,main_go_transparentimg,main_go_drawer_translucent
            ,main_go_fragment,main_go_wangyi;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_go_bohe = (Button) findViewById(R.id.main_go_bohe);
        main_go_drawer_translucent = (Button) findViewById(R.id.main_go_drawer_translucent);
        main_go_fragment = (Button) findViewById(R.id.main_go_fragment);
        main_go_wangyi = (Button) findViewById(R.id.main_go_wangyi);
        main_go_putongtoolbar = (Button) findViewById(R.id.main_go_putongtoolbar);
        main_go_transparentimg = (Button) findViewById(R.id.main_go_transparentimg);
        main_go_scrollingimgtranslucent = (Button) findViewById(R.id.main_go_scrollingimgtranslucent);
        main_go_bohe.setOnClickListener(this);
        main_go_scrollingimgtranslucent.setOnClickListener(this);
        main_go_wangyi.setOnClickListener(this);
        main_go_transparentimg.setOnClickListener(this);
        main_go_putongtoolbar.setOnClickListener(this);
        main_go_drawer_translucent.setOnClickListener(this);
        main_go_fragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_go_bohe:
                intent = new Intent(this,BoHeTranslucent.class);
                startActivity(intent);
                break;
            case R.id.main_go_putongtoolbar:
                intent = new Intent(this,PuTongToolBarTranslucent.class);
                startActivity(intent);
                break;
            case R.id.main_go_drawer_translucent:
                intent = new Intent(this,DrawerLayoutAct.class);
                startActivity(intent);
                break;
            case R.id.main_go_transparentimg:
                intent = new Intent(this,TransparentImgAct.class);
                startActivity(intent);
                break;
            case R.id.main_go_scrollingimgtranslucent:
                intent = new Intent(this,ScrollingImgTranslucentActivity.class);
                startActivity(intent);
                break;
            case R.id.main_go_fragment:
                intent = new Intent(this,FragmentStatusAct.class);
                startActivity(intent);
                break;
            case R.id.main_go_wangyi:
                intent = new Intent(this,WangYiMusicDemo.class);
                startActivity(intent);
                break;
        }
    }
}
