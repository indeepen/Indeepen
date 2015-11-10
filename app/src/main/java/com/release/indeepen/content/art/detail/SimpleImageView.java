package com.release.indeepen.content.art.detail;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.release.indeepen.R;

import java.io.File;

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

    public void setData(String path) {
        //Uri uri = Uri.fromFile(new File(path));
        ImageLoader.getInstance().displayImage(path.toString(), vIMG);
    }
}
