package com.release.indeepen.content.art.singleList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.content.art.ContentVideoData;
import com.release.indeepen.content.art.ContentYoutubeData;
import com.release.indeepen.content.art.detail.ContentDetailActivity;
import com.release.indeepen.content.comment.CommentListActivity;
import com.release.indeepen.youtube.DeveloperKey;
import com.release.indeepen.youtube.MyYoutubeFragment;

/**
 * Created by lyo on 2015-11-05.
 */
public class SingleYoutubeView  extends LinearLayout implements View.OnClickListener, YouTubeThumbnailView.OnInitializedListener {

    ImageView vThPro, vIMGEmotion;
    TextView  vTextArtist, vTextDate, vText, vTextLike, vTextComm, vTextOption, vTextCommUser1, vTextCommUser2, vTextCommCon1, vTextCommCon2;;
    ContentYoutubeData mData;
    SingleHeaderView vHeader;
    SingleFooterView vFooter;
    YouTubeThumbnailView vYoutub;
    private YouTubeThumbnailLoader thumbnailLoader;

    public SingleYoutubeView(Context context) {
        super(context);
        init();
    }

    public SingleYoutubeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.view_single_youtube, this);

        vHeader = (SingleHeaderView) findViewById(R.id.view_single_youtube_header);
        vFooter = (SingleFooterView) findViewById(R.id.view_single_youtube_footer);

        vThPro = (ImageView) vHeader.findViewById(R.id.img_image_single_thpro);
        vIMGEmotion = (ImageView) vHeader.findViewById(R.id.img_image_single_emotion);
        vTextArtist = (TextView) vHeader.findViewById(R.id.text_image_single_artist);
        vTextDate = (TextView) vHeader.findViewById(R.id.text_image_single_date);
        vText = (TextView) vHeader.findViewById(R.id.text_image_single_text);

        vThPro.setOnClickListener(this);
        vTextArtist.setOnClickListener(this);
        vTextDate.setOnClickListener(this);
        vText.setOnClickListener(this);

        vYoutub = (YouTubeThumbnailView) findViewById(R.id.youtub_single);
        vYoutub.initialize(DeveloperKey.DEVELOPER_KEY, this);
        vYoutub.setOnClickListener(this);

        vTextLike = (TextView) vFooter.findViewById(R.id.text_image_single_like);
        vTextComm = (TextView) vFooter.findViewById(R.id.text_image_single_comm);
        vTextOption = (TextView) vFooter.findViewById(R.id.text_image_single_option);
        vTextCommUser1 = (TextView) vFooter.findViewById(R.id.text_image_single_nick1);
        vTextCommUser2 = (TextView) vFooter.findViewById(R.id.text_image_single_nick2);
        vTextCommCon1 = (TextView) vFooter.findViewById(R.id.text_image_single_comm1);
        vTextCommCon2 = (TextView) vFooter.findViewById(R.id.text_image_single_comm2);

        vTextCommUser1.setOnClickListener(this);
        vTextCommUser2.setOnClickListener(this);
        vTextCommCon1.setOnClickListener(this);
        vTextCommCon2.setOnClickListener(this);
        vTextLike.setOnClickListener(this);
        vTextComm.setOnClickListener(this);
        vTextOption.setOnClickListener(this);

    }
    final YouTubeThumbnailLoader.OnThumbnailLoadedListener  onThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener(){
        @Override
        public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

        }

        @Override
        public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
            youTubeThumbnailView.setVisibility(View.VISIBLE);
        }
    };

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
        thumbnailLoader = youTubeThumbnailLoader;
        thumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
        thumbnailLoader.setVideo(mData.sPath);
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

    }

    public YouTubeThumbnailView getYoutube(){
        return vYoutub;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.youtub_single:
            case R.id.text_image_single_text:
            case R.id.img_image_single_emotion:
            case R.id.text_image_single_nick1:
            case R.id.text_image_single_nick2:
            case R.id.text_image_single_comm1:
            case R.id.text_image_single_comm2: {
                Intent mIntent = new Intent(getContext(), ContentDetailActivity.class);
                mIntent.putExtra(DefineContentType.BUNDLE_DATA_REQUEST, mData);
                mIntent.putExtra(DefineContentType.BUNDLE_DATA_TYPE, mData.nArtType);
                getContext().startActivity(mIntent);
                break;
            }
            case R.id.text_image_single_artist:
            case R.id.img_image_single_thpro: {
                Intent mIntent = new Intent(getContext(), MainActivity.class);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_BLOG);
                //mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
                getContext().startActivity(mIntent);
                break;
            }
            case R.id.text_image_single_like: {
                Toast.makeText(getContext(), "좋다", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.text_image_single_comm: {
                Intent mIntent = new Intent(getContext(), CommentListActivity.class);
                getContext().startActivity(mIntent);
                break;
            }
            case R.id.text_image_single_option: {
                onOptionDialog();
                break;
            }

        }
    }
    public void onOptionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        //builder.setIcon(android.R.drawable.ic_dialog_alert);
        // builder.setTitle("List Dialog");
        builder.setItems(new String[]{"싫어요", "공유", "수정", "삭제"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent mIntent;
                switch (which) {
                    case 0: {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        //builder.setIcon(android.R.drawable.ic_dialog_alert);
                        //builder.setTitle("Alert Dialog");
                        builder.setMessage("이 게시물을 정말 싫어요 하시겠습니까?");
                        builder.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "봐줌", Toast.LENGTH_SHORT).show();

                            }
                        });
                        builder.setNeutralButton("싫어요", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "넌 신고", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setCancelable(false);
                        builder.create().show();
                        break;
                    }
                    case 1: {

                        break;
                    }
                    case 2: {
                        //mIntent = new Intent(getContext(), MediaSingleChoiceActivity.class);
                        //mIntent.putExtra(DefineContentType.SELECT_IMAGE, DefineContentType.ACTIVITY_TYPE_PROFILE_IMG);
                        //startActivity(mIntent);
                        break;
                    }
                    case 3: {
                        // mIntent = new Intent(getContext(), MediaSingleChoiceActivity.class);
                        //mIntent.putExtra(DefineContentType.SELECT_IMAGE, DefineContentType.ACTIVITY_TYPE_PROFILE_IMG);
                        // startActivity(mIntent);
                        break;
                    }
                }

            }
        });
        builder.create().show();
    }

    public void setData(ContentYoutubeData data) {
        if (null == data) return;
        mData = data;
        //vThPro.setImageResource(data.thProfile);

      /*  final YouTubeThumbnailLoader.OnThumbnailLoadedListener  onThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener(){
            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

            }

            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                youTubeThumbnailView.setVisibility(View.VISIBLE);
            }
        };

        vYoutub.initialize(DeveloperKey.DEVELOPER_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(mData.sPath);
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //write something for failure
            }
        });*/

    }


}
