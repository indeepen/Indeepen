package com.release.indeepen.blog;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.release.indeepen.CallbackListener;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.R;
import com.release.indeepen.blog.simpleList.SimpleSingleUserListActivity;
import com.release.indeepen.blog.simpleList.SimpleTabUserListActivity;
import com.release.indeepen.content.ContentData;
import com.release.indeepen.create.selectMedia.MediaSingleChoiceActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogIntroView extends FrameLayout{


    public BlogIntroView(Context context) {
        super(context);
        init();
    }

    public BlogIntroView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_blog_intro, this);

    }

}
