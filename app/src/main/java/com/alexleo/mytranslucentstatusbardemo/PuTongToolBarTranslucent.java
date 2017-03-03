package com.alexleo.mytranslucentstatusbardemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.SeekBar;

/**
 * 先设置状态栏透明属性；
 * 给根布局加上一个和状态栏一样大小的矩形View（色块），添加到顶上；
 * 然后设置根布局的 FitsSystemWindows 属性为 true,此时根布局会延伸到状态栏，
 * 处在状态栏位置的就是之前添加的色块，这样就给状态栏设置上颜色了。
 */
public class PuTongToolBarTranslucent extends AppCompatActivity {

    private Toolbar pu_tong_toolbar;
    private SeekBar pu_tong_seek_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_tong_tool_bar_translucent);
        pu_tong_toolbar = (Toolbar) findViewById(R.id.pu_tong_toolbar);
        setSupportActionBar(pu_tong_toolbar);
        AlexStatusBarUtils.setStatusColor(this, Color.BLUE,122);
        pu_tong_seek_bar = (SeekBar) findViewById(R.id.pu_tong_seek_bar);
        pu_tong_seek_bar.setProgress(122);
        pu_tong_seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                AlexStatusBarUtils.setStatusColor(PuTongToolBarTranslucent.this, getResources().getColor(R.color.colorPrimary),i);
                System.out.println("i = " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
