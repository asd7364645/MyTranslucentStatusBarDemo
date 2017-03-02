package com.alexleo.mdstatusbardemo;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.science.mdstatusbar.R;

/**
 * Created by Alex on 2017/2/28.
 * Alex
 */

public class GlideUtils {
    public static final String IMG_URL = "http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-27-tumblr_om1aowIoKa1qbw5qso1_540.jpg";

    public static void setImgUrl(ImageView imageView) {
        Glide.with(imageView.getContext()).load(IMG_URL).placeholder(R.drawable.header_bg)
                .into(imageView);
    }

}
