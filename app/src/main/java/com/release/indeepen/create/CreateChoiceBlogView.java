package com.release.indeepen.create;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.release.indeepen.R;

import java.io.File;

/**
 * Created by lyo on 2015-11-08.
 */
public class CreateChoiceBlogView extends LinearLayout{
    TextView vTextBlog;
    ImageView vImgBlog;

    public CreateChoiceBlogView(Context context) {
        super(context);
        init();
    }

    public CreateChoiceBlogView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.view_create_choice_blog, this);
        vTextBlog = (TextView) findViewById(R.id.text_create_choice_blog);
        vImgBlog =(ImageView) findViewById(R.id.img_create_choice_blog);
    }

    public void setData(BlogData data){
        vTextBlog.setText(data.sName);

        if(!TextUtils.isEmpty(data.sIMGPath)) {
            //Uri uri = Uri.fromFile(new File(data.sIMGPath));
            Uri uri = Uri.parse(data.sIMGPath);
            ImageLoader.getInstance().displayImage(uri.toString(), vImgBlog);
        }
    }
}
