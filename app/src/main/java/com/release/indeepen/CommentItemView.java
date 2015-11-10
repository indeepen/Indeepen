package com.release.indeepen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Lady on 2015. 11. 2..
 */
public class CommentItemView extends LinearLayout {

    public CommentItemView(Context context) {
        super(context);
        init();
    }

    public CommentItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    ImageView image_user;
    TextView text_username, text_comment, text_uploadtime;
    CommentItemData mData;
    EditText text_input;

    public interface OnImageClickListener {
        public void onImageClick(CommentItemView view, CommentItemData date);
    }

    OnImageClickListener mListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mListener = listener;
    }

    private void init() {
        inflate(getContext(), R.layout.view_list_comment, this);
        image_user = (ImageView)findViewById(R.id.image_user);
        image_user.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onImageClick(CommentItemView.this, mData);
                }
            }
        });

        text_username = (TextView)findViewById(R.id.text_username);
        text_comment = (TextView)findViewById(R.id.text_comment);
        text_uploadtime = (TextView)findViewById(R.id.text_uploadtime);

    }

    public void setItemData(CommentItemData data) {
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

    /*private void initData() {
        String[] items = getResources().getStringArray(R.array.list_item);
        for (String s : items) {
            mAdapter.add(s);
        }
    }*/
}
