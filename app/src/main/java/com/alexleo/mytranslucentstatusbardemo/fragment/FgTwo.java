package com.alexleo.mytranslucentstatusbardemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexleo.mytranslucentstatusbardemo.R;

/**
 * Created by Alex on 2017/3/6.
 * Alex
 */

public class FgTwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fg_two,container,false);
    }
}
