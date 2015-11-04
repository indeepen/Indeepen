package com.release.indeepen.content.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.release.indeepen.R;

/**
 * Created by lyo on 2015-11-01.
 */
public class SimpleImageView extends RelativeLayout {

    ImageView vIMG;

    public SimpleImageView(Context context) {
        super(context);
        init();
    }

    public SimpleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_simple_image, this);
        vIMG = (ImageView) findViewById(R.id.img_detail_img);
    }

    public void setData(int data) {
        vIMG.setImageResource(data);
    }
}
