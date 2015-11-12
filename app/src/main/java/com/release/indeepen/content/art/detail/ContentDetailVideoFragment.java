package com.release.indeepen.content.art.detail;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.content.art.ContentVideoData;
import com.release.indeepen.content.comment.CommentListActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentDetailVideoFragment extends Fragment implements View.OnClickListener {
    ContentVideoData mData;
    ImageView vThPro, vThEmotion;
    TextView vTextArtist, vTextDate, vText, vTextOption, vTextComment, vTextLike;
    VideoView vPlayer;

    public ContentDetailVideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content_detail_video, container, false);

        vThPro = (ImageView) view.findViewById(R.id.img_detail_image_thPro);
        vThEmotion = (ImageView) view.findViewById(R.id.img_detail_image_emotion);
        vTextArtist = (TextView) view.findViewById(R.id.text_detail_image_artist);
        vTextDate = (TextView) view.findViewById(R.id.text_detail_image_date);
        vText = (TextView) view.findViewById(R.id.text_detail_image_text);
        vTextComment = (TextView) view.findViewById(R.id.text_detail_image_comm_count);
        vTextLike = (TextView) view.findViewById(R.id.text_detail_image_like_count);
        vTextOption = (TextView) view.findViewById(R.id.text_detail_image_option);

        vThPro.setOnClickListener(this);
        //vThEmotion.setOnClickListener(this);
        vTextArtist.setOnClickListener(this);
        //vTextDate.setOnClickListener(this);
        //vText = (TextView) view.findViewById(R.id.text_detail_image_text);
        vTextComment.setOnClickListener(this);
        vTextLike.setOnClickListener(this);
        vTextOption.setOnClickListener(this);

        MediaController controller = new MediaController(getContext());
        vPlayer = (VideoView) view.findViewById(R.id.videoView_detail);

       // LinearLayout.LayoutParams imgParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, getContext().getResources().getDisplayMetrics().widthPixels);

        //imgParam.gravity = Gravity.CENTER;
       // vPlayer.setLayoutParams(imgParam);
        vPlayer.setMediaController(controller);
        vPlayer.setOnPreparedListener(onPrepared);
        vPlayer.setOnClickListener(this);

        init();
        return view;
    }

    private void init() {
        if (null != getArguments()) {
            mData = (ContentVideoData) getArguments().getSerializable(DefineContentType.BUNDLE_DATA_REQUEST);
            setData(mData);
        }

    }

    private void setData(ContentVideoData data) {
        //vThPro.setImageResource(data.thProfile);
        String UrlPath = "android.resource://com.release.indeepen/raw/video";
        Uri video_uri = Uri.parse(UrlPath);
        vPlayer.setVideoURI(video_uri);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        vPlayer.stopPlayback();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vPlayer.stopPlayback();
    }

    @Override
    public void onPause() {
        super.onPause();
        vPlayer.stopPlayback();
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


    private MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener =
            new MediaPlayer.OnVideoSizeChangedListener() {
                public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT);
                    vPlayer.setLayoutParams(lp);
                }
            };

    private MediaPlayer.OnPreparedListener onPrepared = new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mp) {
            mp.setOnVideoSizeChangedListener(onVideoSizeChangedListener);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getContext().getResources().getDisplayMetrics().widthPixels);
            vPlayer.setLayoutParams(lp);
        }
    };



}
