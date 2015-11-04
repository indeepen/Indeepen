package com.release.indeepen.blog;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.R;
import com.release.indeepen.blog.simpleList.SimpleSingleUserListActivity;
import com.release.indeepen.blog.simpleList.SimpleTabUserListActivity;
import com.release.indeepen.create.selectMedia.MediaSingleChoiceActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogIntroView extends FrameLayout {

    static ImageView vIMGProBack, vthPro;
    boolean isClick = false;

    private OnFragmentActionListener mListener;

    public interface OnFragmentActionListener {
        void onFragmentActionListener(Fragment fragment, Intent intent, int type);
    }

    public void setOnFragmentAction(OnFragmentActionListener listener) {
        mListener = listener;
    }

    public BlogIntroView(Context context) {
        super(context);
        init();
    }

    public BlogIntroView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_blog_intro, this);

        vIMGProBack = (ImageView) findViewById(R.id.img_blog_background);
        vthPro = (ImageView) findViewById(R.id.img_blog_thProfile);
        vthPro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onProfileDialog();
            }
        });

        vIMGProBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackgroundDialog();
            }
        });

        Button btn = (Button) findViewById(R.id.btn_fanList);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getContext(), SimpleTabUserListActivity.class);
                getContext().startActivity(mIntent);
            }
        });


        btn = (Button) findViewById(R.id.btn_imissyou);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClick) {
                    Intent mIntent = new Intent(getContext(), SimpleSingleUserListActivity.class);
                    getContext().startActivity(mIntent);
                } else {
                    onConfirmDialog(v);
                    isClick = true;
                }
            }
        });

    }

    public void setData(BlogIntroData data) {

    }

    public void onBackgroundDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        //builder.setIcon(android.R.drawable.ic_dialog_alert);
        // builder.setTitle("List Dialog");
        builder.setItems(new String[]{"블로그 배경 등록"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent mIntent = new Intent(getContext(), MediaSingleChoiceActivity.class);
                mIntent.putExtra(DefineContentType.SELECT_IMAGE, DefineContentType.ACTIVITY_TYPE_PROFILE_BACKGROUND);
                mListener.onFragmentActionListener(null, mIntent, DefineContentType.ACTIVITY_TYPE_PROFILE_BACKGROUND);
                //////////////////////

            }
        });
        builder.create().show();
    }

    public void onProfileDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        //builder.setIcon(android.R.drawable.ic_dialog_alert);
        // builder.setTitle("List Dialog");
        builder.setItems(new String[]{"프로필 수정", "프로필 사진 보기", "프로필 사진 등록"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent mIntent;
                switch (which) {
                    case 0: {
                       /* mIntent = new Intent(getContext(), UserInfoActivity.class);
                        if(null != CallbackListener.mActivityListener) {
                            CallbackListener.mActivityListener.onGoActivity(mIntent, DefineContentType.ACTIVITY_TYPE_FIXD_INFO);
                        }
                        break;*/
                    }
                    case 1: {
                       /* mIntent = new Intent(getContext(), ExpandImageActivity.class);
                        if(null != CallbackListener.mActivityListener) {
                            CallbackListener.mActivityListener.onGoActivity(mIntent, DefineContentType.ACTIVITY_TYPE_EXPANED_IMG);
                        }
                        break;*/
                    }
                    case 2: {
                       /* mIntent = new Intent(getContext(), MediaSingleChoiceActivity.class);
                        mIntent.putExtra(DefineContentType.SELECT_IMAGE, DefineContentType.ACTIVITY_TYPE_PROFILE_IMG);
                        if(null != CallbackListener.mActivityListener) {
                            CallbackListener.mActivityListener.onGoActivity(mIntent, DefineContentType.ACTIVITY_TYPE_PROFILE_IMG);
                        }
                        break;*/
                    }
                }

            }
        });
        builder.create().show();
    }

    public void onConfirmDialog(View view) {
        PopupIMissU popup = new PopupIMissU(getContext());
        popup.setOutsideTouchable(true);
        popup.showAtLocation(this, Gravity.CENTER, 0, 0);
    }


    /*public static void setProfileBack(String path){
        Uri uri = Uri.fromFile(new File(path));
        ImageLoader.getInstance().displayImage(uri.toString(), vIMGProBack);
    }

    public static void setProfileIMG(String path){
        Uri uri = Uri.fromFile(new File(path));
        ImageLoader.getInstance().displayImage(uri.toString(), vthPro);
    }*/


}
