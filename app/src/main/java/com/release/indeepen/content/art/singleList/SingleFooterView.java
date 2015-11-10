package com.release.indeepen.content.art.singleList;

import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.content.ContentData;
import com.release.indeepen.content.art.ContentImageData;
import com.release.indeepen.content.art.ContentVideoData;
import com.release.indeepen.content.art.detail.ContentDetailActivity;
import com.release.indeepen.content.comment.CommentListActivity;

/**
 * Created by lyo on 2015-11-05.
 */
public class SingleFooterView extends LinearLayout{



    public SingleFooterView(Context context) {
        super(context);
        init();
    }

    public SingleFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.view_single_footer, this);
    }

}
