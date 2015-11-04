package com.release.indeepen.blog.simpleList;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.release.indeepen.R;
import com.release.indeepen.user.UserData;

/**
 * Created by lyo on 2015-11-02.
 */
public class SimpleUserView extends RelativeLayout{

    ImageView vThPro;
    TextView vTextArtist;

    public SimpleUserView(Context context) {
        super(context);
        init();
    }

    public SimpleUserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.view_simple_user, this);
        vThPro = (ImageView) findViewById(R.id.img_simple_thPro);
        vTextArtist = (TextView) findViewById(R.id.text_simple_artist);

    }

    public void setData(UserData data){
        vThPro.setImageResource(data.thProfile);
        vTextArtist.setText(data.sArtist);
    }
}
