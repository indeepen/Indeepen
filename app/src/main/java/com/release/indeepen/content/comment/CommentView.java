package com.release.indeepen.content.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.release.indeepen.R;

/**
 * Created by lyo on 2015-11-03.
 */
public class CommentView extends RelativeLayout {

    ImageView vThPro;
    TextView vTextArtist, vText, vTextDate;

    public CommentView(Context context) {
        super(context);
        init();
    }

    public CommentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_comment, this);
        vThPro = (ImageView) findViewById(R.id.img_comm_user_thPro);
        vTextArtist = (TextView) findViewById(R.id.text_comm_artist);
        vText = (TextView) findViewById(R.id.text_comm_text);
        vTextDate = (TextView) findViewById(R.id.text_comm_date);
    }

    public void setData(CommentData data) {
        vThPro.setImageResource(data.sThPro);
        vTextArtist.setText(data.sArtist);
        vText.setText(data.sComment);
        vTextDate.setText(data.sDate);
    }
}
