package com.release.indeepen.content.art.tripleGrid;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.release.indeepen.R;

/**
 * Created by lyo on 2015-10-31.
 */
public class ThumbImageView extends FrameLayout {

    ImageView thIMG;

    public ThumbImageView(Context context) {
        super(context);
        init();
    }

    public ThumbImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_thumb_image, this);
        thIMG = (ImageView) findViewById(R.id.img_item);
    }

    void setIMG(int path) {
        thIMG.setImageResource(path);
    }

}
