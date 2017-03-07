package com.alexleo.mytranslucentstatusbardemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.alexleo.mytranslucentstatusbardemo.fragment.FgOne;
import com.alexleo.mytranslucentstatusbardemo.fragment.FgTwo;

import java.util.ArrayList;
import java.util.List;

public class FragmentStatusAct extends AppCompatActivity {

    private ViewPager fragment_status_vp;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_status);

        fragment_status_vp = (ViewPager) findViewById(R.id.fragment_status_vp);

        fragments = new ArrayList<>();
        fragments.add(new FgOne());
        fragments.add(new FgTwo());
        fragments.add(new FgTwo());
        fragments.add(new FgTwo());
        fragment_status_vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),fragments));

        AlexStatusBarUtils.setTranslucentForImageViewInFragment(this,122);

    }

    class MyPagerAdapter extends FragmentStatePagerAdapter{

        private List<Fragment> fragments;

        public MyPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
