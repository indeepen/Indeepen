package com.release.indeepen.content.singleList;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.release.indeepen.CallbackListener;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.R;
import com.release.indeepen.blog.BlogFragment;
import com.release.indeepen.blog.BlogMainFragment;
import com.release.indeepen.content.art.ContentImageData;
import com.release.indeepen.content.comment.CommentListActivity;
import com.release.indeepen.content.detail.ContentDetailActivity;
import com.release.indeepen.content.detail.ContentDetailFragment;

/**
 * Created by lyo on 2015-11-01.
 */
public class ImageSingleListView extends LinearLayout implements View.OnClickListener{

    ImageView vThPro, vIMGContent, vIMGEmotion ;
    TextView vTextLike, vTextComm, vTextOption, vTextArtist, vTextDate, vText, vTextCommUser1, vTextCommUser2, vTextCommCon1, vTextCommCon2;
    ContentImageData mData;
    ContentDetailFragment mContentDetailFragment;
    BlogFragment mBlogF;
   // Bundle mBundle;

    public ImageSingleListView(Context context) {
        super(context);
        init();
    }

    public ImageSingleListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.view_image_single_list, this);
        vThPro = (ImageView) findViewById(R.id.img_image_single_thpro);
        vIMGContent = (ImageView) findViewById(R.id.img_image_single_contents);
        vIMGEmotion =  (ImageView) findViewById(R.id.img_image_single_emotion);

        vTextLike = (TextView)findViewById(R.id.text_image_single_like);
        vTextComm = (TextView)findViewById(R.id.text_image_single_comm);
        vTextOption = (TextView)findViewById(R.id.text_image_single_option);
        vTextArtist = (TextView)findViewById(R.id.text_image_single_artist);
        vTextDate  = (TextView)findViewById(R.id.text_image_single_date);
        vText = (TextView)findViewById(R.id.text_image_single_text);
        vTextCommUser1 = (TextView)findViewById(R.id.text_image_single_nick1);
        vTextCommUser2 = (TextView)findViewById(R.id.text_image_single_nick2);
        vTextCommCon1 = (TextView)findViewById(R.id.text_image_single_comm1);
        vTextCommCon2 = (TextView)findViewById(R.id.text_image_single_comm2);

        mContentDetailFragment = new ContentDetailFragment();
        mBlogF = new BlogFragment();
        if(null != mData) {
          //  mBundle = new Bundle();
           // mBundle.putSerializable(DefineContentType.BUNDLE_DATA_DETAIL_IMAGE, mData);
            //mContentDetailFragment.setArguments(mBundle);
        }

        vIMGContent.setOnClickListener(this);
        vThPro.setOnClickListener(this);
        vTextLike.setOnClickListener(this);
        vTextComm.setOnClickListener(this);
        vTextOption.setOnClickListener(this);
        vTextArtist.setOnClickListener(this);
        vTextDate.setOnClickListener(this);
        vText.setOnClickListener(this);
        vTextCommUser1.setOnClickListener(this);
        vTextCommUser2.setOnClickListener(this);
        vTextCommCon1.setOnClickListener(this);
        vTextCommCon2.setOnClickListener(this);

/*        vIMGContent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//              if(null != CallbackListener.mActivityListener){
//                    Intent mIntent = new Intent(getContext(), ContentSingleListActivity.class);
//                    mIntent.putExtra(DefineContentType.BUNDLE_DATA_DETAIL_IMAGE, mData);
//                    CallbackListener.mActivityListener.onGoActivity(mIntent, DefineContentType.CALLBACK_TO_DETAIL_IMGAE);

                Intent mIntent = new Intent(getContext(), ContentDetailActivity.class);
                mIntent.putExtra(DefineContentType.BUNDLE_DATA_DETAIL_IMAGE, mData);

                getContext().startActivity(mIntent);


//              if(null != CallbackListener.mListener){
//                    switch(mData.nArtType) {
//                        case DefineContentType.SINGLE_IMAGE : {
//
//                           // CallbackListener.mListener.onReplaceFragment(mContentDetailFragment, DefineContentType.CALLBACK_TO_DETAIL_IMGAE, mData);
//                        }
//                    }
//                }
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.img_image_single_contents:{
                Intent mIntent = new Intent(getContext(), ContentDetailActivity.class);
                mIntent.putExtra(DefineContentType.BUNDLE_DATA_DETAIL_IMAGE, mData);
                getContext().startActivity(mIntent);
                break;
            }
            case R.id.text_image_single_artist:
            case R.id.img_image_single_thpro:{
                if(null != CallbackListener.mFragnetListener ) {
                    CallbackListener.mFragnetListener.onReplaceFragment(new BlogMainFragment(), DefineContentType.CALLBACK_TO_BLOG);
                }
                break;
            }
            case R.id.text_image_single_like:{
                Toast.makeText(getContext(), "좋다", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.text_image_single_comm:{
                Intent mIntent = new Intent(getContext(), CommentListActivity.class);
                getContext().startActivity(mIntent);
                break;
            }

        }
    }

    public void setData(ContentImageData data){
        if(null == data) return;
        mData = data;
        vThPro.setImageResource(data.thProfile);
        vIMGContent.setImageResource(DefineTest.ARR_IMG[(int)(Math.random()*10)%8]);
    }



}
