package com.release.indeepen.content.art.singleList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.content.art.ContentMusicData;
import com.release.indeepen.content.art.detail.ContentDetailActivity;
import com.release.indeepen.content.comment.CommentListActivity;
import com.release.indeepen.management.dateManager.DateManager;
import com.release.indeepen.management.musicManager.MusicManager;
import com.release.indeepen.management.networkManager.netArt.data.Comments;

/**
 * Created by lyo on 2015-11-05.
 */
public class SingleMusicView extends LinearLayout implements View.OnClickListener {


    ImageView vThPro, vIMGEmotion, vBackground, vForeground;
    TextView vTextArtist, vTextDate, vText, vTextLike, vTextComm, vTextOption, vTextCommUser1, vTextCommUser2, vTextCommCon1, vTextCommCon2;
    ContentMusicData mData;
    SingleHeaderView vHeader;
    SingleFooterView vFooter;
    SeekBar vSeek;
    AudioManager mAM;

    MusicManager playerManager;
    TextView[] comments;
    TextView[] commentUser;
    public SingleMusicView(Context context) {
        super(context);
        init();
    }

    public SingleMusicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        inflate(getContext(), R.layout.view_single_music, this);

        vHeader = (SingleHeaderView) findViewById(R.id.view_single_music_header);
        vFooter = (SingleFooterView) findViewById(R.id.view_single_music_footer);

        vThPro = (ImageView) vHeader.findViewById(R.id.img_image_single_thpro);
        vIMGEmotion = (ImageView) vHeader.findViewById(R.id.img_image_single_emotion);
        vTextArtist = (TextView) vHeader.findViewById(R.id.text_image_single_artist);
        vTextDate = (TextView) vHeader.findViewById(R.id.text_image_single_date);
        vText = (TextView) vHeader.findViewById(R.id.text_image_single_text);

        vThPro.setOnClickListener(this);
        vTextArtist.setOnClickListener(this);
        vTextDate.setOnClickListener(this);
        vText.setOnClickListener(this);

        vSeek = (SeekBar) findViewById(R.id.seekBar_single_music);
        vBackground = (ImageView) findViewById(R.id.img_single_music);
        vForeground = (ImageView) findViewById(R.id.img_single_forground);
        vBackground.setOnClickListener(this);
        vForeground.setOnClickListener(this);

        FrameLayout.LayoutParams imgParam = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, getContext().getResources().getDisplayMetrics().widthPixels);
        vBackground.setLayoutParams(imgParam);
        mAM = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        vTextLike = (TextView) vFooter.findViewById(R.id.text_image_single_like);
        vTextComm = (TextView) vFooter.findViewById(R.id.text_image_single_comm);
        vTextOption = (TextView) vFooter.findViewById(R.id.text_image_single_option);
        vTextCommUser1 = (TextView) vFooter.findViewById(R.id.text_image_single_nick1);
        vTextCommUser2 = (TextView) vFooter.findViewById(R.id.text_image_single_nick2);
        vTextCommCon1 = (TextView) vFooter.findViewById(R.id.text_image_single_comm1);
        vTextCommCon2 = (TextView) vFooter.findViewById(R.id.text_image_single_comm2);

        comments = new TextView[]{vTextCommCon1, vTextCommCon2};
        commentUser = new TextView[]{vTextCommUser1, vTextCommUser2};

        vTextCommUser1.setOnClickListener(this);
        vTextCommUser2.setOnClickListener(this);
        vTextCommCon1.setOnClickListener(this);
        vTextCommCon2.setOnClickListener(this);
        vTextLike.setOnClickListener(this);
        vTextComm.setOnClickListener(this);
        vTextOption.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
            case R.id.img_single_music:
            case R.id.img_single_forground: {
                if (playerManager.getState() == MusicManager.PlayState.STARTED) {
                    playerManager.pause();
                    vForeground.setVisibility(VISIBLE);
                } else {
                    Uri video_uri = Uri.parse(mData.sMusicPath);
                    playerManager.setMyURI(video_uri);
                    //playerManager.init(vSeek);
                    playerManager.play();
                    playerManager.seekbarReset(vSeek);
                    vForeground.setVisibility(INVISIBLE);
                }
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

    public void setData(ContentMusicData data) {
        if (null == data) return;
        mData = data;
        vTextArtist.setText(mData.mUserData.sArtist);
        ImageLoader.getInstance().displayImage(mData.mUserData.thProfile, vThPro);
        ImageLoader.getInstance().displayImage(mData.sMusicBackIMG, vBackground);
        vForeground.setVisibility(VISIBLE);
        playerManager = MusicManager.getMusicManager();
        playerManager.setMyURL(mData.sMusicPath);
        playerManager.init(vSeek);
        vSeek.setProgress(0);
        vTextDate.setText(DateManager.getInstance().getTime(System.currentTimeMillis() - (8000 * 1000))); // test
        vText.setText(mData.sText);
        if(0 < mData.arrComment.size()) {
            int idx=0;
            for(Comments comm : mData.arrComment) {
                commentUser [idx].setVisibility(VISIBLE);
                comments[idx].setVisibility(VISIBLE);
                commentUser [idx].setText(comm.mWriter.sArtist);
                comments[idx].setText(comm.sComm);
                idx++;
            }
        }
    }

}
