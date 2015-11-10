package com.release.indeepen.culture;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.release.indeepen.CallbackListener;
import com.release.indeepen.CommentActivity;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.blog.BlogMainFragment;

/**
 * Created by Lady on 2015. 11. 2..
 */
public class CultureItemView extends LinearLayout implements View.OnClickListener {

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

        image_user.setOnClickListener(this);
        text_username.setOnClickListener(this);
        text_uploadtime.setOnClickListener(this);
        image_fee.setOnClickListener(this);
        image_ing.setOnClickListener(this);
        text_title.setOnClickListener(this);
        image_main.setOnClickListener(this);
        text_date.setOnClickListener(this);
        text_time.setOnClickListener(this);
        text_like.setOnClickListener(this);
        text_comment.setOnClickListener(this);
        text_tag.setOnClickListener(this);
        text_option.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_main: {
                Intent mIntent = new Intent(getContext(), CultureDetailActivity.class);
                getContext().startActivity(mIntent);
                Toast.makeText(getContext(), "선택부분 click", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.text_username:
            case R.id.image_user: {
                Intent mIntent = new Intent(getContext(), MainActivity.class);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_BLOG);
                getContext().startActivity(mIntent);
                break;
            }
            case R.id.text_comment: {
                Intent mIntent = new Intent(getContext(), CommentActivity.class);
                getContext().startActivity(mIntent);
                break;
            }

        }
    }


    public void setItemData(CultureItemData data) {
        mData = data;
        image_user.setImageResource(data.thIMG);
        text_username.setText(data.sArtist);
        text_comment.setText(data.nCommentCount+"");
        //   text_uploadtime.setText(data.dWriteDate);
    }


}
