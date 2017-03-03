package com.alexleo.mytranslucentstatusbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.SeekBar;

public class TransparentImgAct extends AppCompatActivity {
    private Toolbar transparent_img_toolbar;
    private SeekBar transparent_img_seek_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent_img);
        transparent_img_toolbar = (Toolbar) findViewById(R.id.transparent_img_toolbar);
        transparent_img_seek_bar = (SeekBar) findViewById(R.id.transparent_img_seek_bar);
        setSupportActionBar(transparent_img_toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AlexStatusBarUtils.setImageViewTransparent(this);
        transparent_img_seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                AlexStatusBarUtils.setImageViewTranslucent(TransparentImgAct.this,i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
