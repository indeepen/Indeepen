package com.release.indeepen.content.art.detail;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.content.art.ContentMusicData;
import com.release.indeepen.content.comment.CommentListActivity;
import com.release.indeepen.management.musicManager.MusicManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentDetailMusicFragment extends Fragment  implements View.OnClickListener {
    ContentMusicData mData;
    ImageView vThPro, vThEmotion, vBackground, vForeground;
    TextView vTextArtist, vTextDate, vText, vTextOption, vTextComment, vTextLike;

    SeekBar vSeek;
    AudioManager mAM;

    MusicManager playerManager;

    public ContentDetailMusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_detail_music, container, false);
        vThPro = (ImageView) view.findViewById(R.id.img_detail_image_thPro);
        vThEmotion = (ImageView) view.findViewById(R.id.img_detail_image_emotion);
        vTextArtist = (TextView) view.findViewById(R.id.text_detail_image_artist);
        vTextDate = (TextView) view.findViewById(R.id.text_detail_image_date);
        vText = (TextView) view.findViewById(R.id.text_detail_image_text);
        vTextComment = (TextView) view.findViewById(R.id.text_detail_image_comm_count);
        vTextLike = (TextView) view.findViewById(R.id.text_detail_image_like_count);
        vTextOption = (TextView) view.findViewById(R.id.text_detail_image_option);

        vSeek = (SeekBar) view.findViewById(R.id.seekBar_detail_music);
        vBackground = (ImageView) view.findViewById(R.id.img_detail_music);
        vForeground = (ImageView) view.findViewById(R.id.img_detail_foreground);
        FrameLayout.LayoutParams imgParam = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, getContext().getResources().getDisplayMetrics().widthPixels);
        vBackground.setLayoutParams(imgParam);
        vBackground.setOnClickListener(this);
        vForeground.setOnClickListener(this);

        vThPro.setOnClickListener(this);
        vTextArtist.setOnClickListener(this);
        vTextComment.setOnClickListener(this);
        vTextLike.setOnClickListener(this);
        vTextOption.setOnClickListener(this);


        init();
        return view;
    }

    private void init() {
        if (null != getArguments()) {
            mData = (ContentMusicData) getArguments().getSerializable(DefineContentType.BUNDLE_DATA_REQUEST);
            setData(mData);
        }

    }

    private void setData(ContentMusicData data) {
        if (null == data) return;
        mData = data;
        vThPro.setImageResource(data.thProfile);
        vBackground.setImageResource(data.sMusicBackIMG);
        vForeground.setVisibility(View.VISIBLE);
        playerManager = MusicManager.getMusicManager();
        //String UrlPath = "android.resource://com.release.indeepen/raw/sample";
        Uri video_uri = Uri.parse(data.sMusicPath);
        playerManager.setMyURI(video_uri);
        playerManager.init(vSeek);
        vSeek.setProgress(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_detail_image_thPro:
            case R.id.text_detail_image_artist:
            case R.id.text_detail_image_date: {
                Intent mIntent = new Intent(getContext(), MainActivity.class);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_BLOG);
                //mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
                startActivity(mIntent);
                getActivity().finish();
                break;
            }
            case R.id.text_detail_image_comm_count: {
                Intent mIntent = new Intent(getContext(), CommentListActivity.class);
                startActivity(mIntent);

                break;
            }
            case R.id.text_detail_image_like_count: {
                Toast.makeText(getContext(), "좋다", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.text_detail_image_option: {
                onOptionDialog();
                break;
            }
            case R.id.img_detail_music:
            case R.id.img_detail_foreground: {
                if (playerManager.getState() == MusicManager.PlayState.STARTED) {
                    playerManager.pause();
                    vForeground.setVisibility(View.VISIBLE);
                } else {
                    Uri video_uri = Uri.parse(mData.sMusicPath);
                    playerManager.setMyURI(video_uri);
                    //playerManager.init(vSeek);
                    playerManager.play();
                    playerManager.seekbarReset(vSeek);
                    vForeground.setVisibility(View.INVISIBLE);
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


}
