package com.release.indeepen.culture;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.release.indeepen.R;

/**
 * Created by Lady on 2015. 11. 2..
 */
public class CultureItemView extends LinearLayout {

    public CultureItemView(Context context) {
        super(context);
        init();
    }

    public CultureItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    ImageView image_user, image_fee, image_ing, image_main;
    TextView text_username, text_uploadtime, text_title, text_date, text_time, text_like, text_comment, text_tag, text_option;
    CultureItemData mData;

    public interface OnImageClickListener {
        public void onImageClick(CultureItemView view, CultureItemData date);
    }

    OnImageClickListener mListener;

    public void setOnImageClickListener(OnImageClickListener listener) {
        mListener = listener;
    }

    private void init() {
        inflate(getContext(), R.layout.view_list_culture, this);

        image_user = (ImageView) findViewById(R.id.image_user);
        text_username = (TextView) findViewById(R.id.text_username);
        text_uploadtime = (TextView) findViewById(R.id.text_uploadtime);
        image_fee = (ImageView) findViewById(R.id.image_fee);
        image_ing = (ImageView) findViewById(R.id.image_ing);
        text_title = (TextView) findViewById(R.id.text_title);
        image_main = (ImageView) findViewById(R.id.image_main);
        text_date = (TextView) findViewById(R.id.text_date);
        text_time = (TextView) findViewById(R.id.text_time);
        text_like = (TextView) findViewById(R.id.text_like);
        text_comment = (TextView) findViewById(R.id.text_comment);
        text_tag = (TextView) findViewById(R.id.text_tag);
        text_option = (TextView) findViewById(R.id.text_option);


    }

    public void setItemData(CultureItemData data) {
        mData = data;
        if (data.userimage != null) {
            image_user.setImageDrawable(data.userimage);
        }
        text_username.setText(data.username);
        text_comment.setText(data.comment);
        text_uploadtime.setText(data.uploadtime);
    }

    public void changeData() {
        if (mData == null) return;
        image_user.setImageDrawable(mData.userimage);
        text_username.setText(mData.username);
        text_comment.setText(mData.comment);
        text_uploadtime.setText(mData.uploadtime);
    }
}
