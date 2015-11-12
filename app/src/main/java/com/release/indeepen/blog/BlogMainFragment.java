package com.release.indeepen.blog;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.blog.simpleList.SimpleSingleUserListActivity;
import com.release.indeepen.blog.simpleList.SimpleTabUserListActivity;
import com.release.indeepen.content.ContentData;
import com.release.indeepen.content.art.detail.ExpandImageActivity;
import com.release.indeepen.content.art.tripleGrid.HeaderGridView;
import com.release.indeepen.content.art.tripleGrid.TripleGridAdapter;
import com.release.indeepen.create.selectMedia.MediaSingleChoiceActivity;
import com.release.indeepen.user.UserInfoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogMainFragment extends Fragment  implements View.OnClickListener  /*implements CallbackListener.OnGoActivityListener*/ {
    HeaderGridView vTripleGrid;
    TripleGridAdapter mAdapter;
    ImageView vIMGProBack, vthPro;
    Button vBtnArt, vBtnFavorite, vBtnMyCulture, vBtnCollabo;
    BlogIntroView vIntroView;
    boolean isClick = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blog_main, container, false);

        vTripleGrid = (HeaderGridView) view.findViewById(R.id.grid_item);
        mAdapter = new TripleGridAdapter(getContext());
        vIntroView = new BlogIntroView(getContext());
        vTripleGrid.addHeaderView(vIntroView);
        vTripleGrid.setAdapter(mAdapter);

        vIMGProBack = (ImageView) vIntroView.findViewById(R.id.img_blog_background);
        vthPro = (ImageView) vIntroView.findViewById(R.id.img_blog_thProfile);
        vBtnArt = (Button) vIntroView.findViewById(R.id.btn_tab_art);
        vBtnFavorite = (Button) vIntroView.findViewById(R.id.btn_tab_favorite);
        vBtnMyCulture = (Button) vIntroView.findViewById(R.id.btn_tab_culture);
        vBtnCollabo = (Button) vIntroView.findViewById(R.id.btn_tab_collabo);

        vIMGProBack.setOnClickListener(this);
         vthPro.setOnClickListener(this);
        vBtnArt.setOnClickListener(this);
        vBtnFavorite.setOnClickListener(this);
        vBtnMyCulture.setOnClickListener(this);
        vBtnCollabo.setOnClickListener(this);

        Button btn = (Button) vIntroView.findViewById(R.id.btn_fanList);
        btn.setOnClickListener(this);

        btn = (Button) vIntroView.findViewById(R.id.btn_imissyou);
        btn.setOnClickListener(this);
        vTripleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent mIntent = new Intent(getContext(), MainActivity.class);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
                //mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 서버에 Data 받아올 URL
                startActivity(mIntent);

            }
        });

        init();

        return view;
    }

    private void init() {
        test1();

    }

    public void onBackgroundDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        //builder.setIcon(android.R.drawable.ic_dialog_alert);
        // builder.setTitle("List Dialog");
        builder.setItems(new String[]{"블로그 배경 등록"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent mIntent = new Intent(getContext(), MediaSingleChoiceActivity.class);
                mIntent.putExtra(DefineContentType.SELECT_IMAGE, DefineContentType.ACTIVITY_TYPE_PROFILE_BACKGROUND); // 사진 선택 구별을 위한 타입
                startActivity(mIntent);

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
                        mIntent = new Intent(getContext(), UserInfoActivity.class);
                       /* if(null != CallbackListener.mActivityListener) {
                            CallbackListener.mActivityListener.onGoActivity(mIntent, DefineContentType.ACTIVITY_TYPE_FIXD_INFO);
                        }*/
                        startActivity(mIntent);
                        break;
                    }
                    case 1: {
                        mIntent = new Intent(getContext(), ExpandImageActivity.class);
                       /* if(null != CallbackListener.mActivityListener) {
                            CallbackListener.mActivityListener.onGoActivity(mIntent, DefineContentType.ACTIVITY_TYPE_EXPANED_IMG);
                        }*/
                        startActivity(mIntent);
                        break;
                    }
                    case 2: {
                        mIntent = new Intent(getContext(), MediaSingleChoiceActivity.class);
                        mIntent.putExtra(DefineContentType.SELECT_IMAGE, DefineContentType.ACTIVITY_TYPE_PROFILE_IMG);
                       /* if(null != CallbackListener.mActivityListener) {
                            CallbackListener.mActivityListener.onGoActivity(mIntent, DefineContentType.ACTIVITY_TYPE_PROFILE_IMG);
                        }*/
                        startActivity(mIntent);
                        break;
                    }
                }

            }
        });
        builder.create().show();
    }

    public void onConfirmDialog(View view) {
      /*  PopupIMissU popup = new PopupIMissU(getContext());
        popup.setOutsideTouchable(true);
        popup.showAtLocation(getView(), Gravity.CENTER, 0, 0);*/

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("응원 하시겠습니까?");
       // builder.setMessage("응원 하시겠습니까?");
        builder.setPositiveButton("아니", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "안함", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNeutralButton("응원한다", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "사랑한다", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.create().show();

    }

    public interface OnFragmentActionListener {
        void onFragmentActionListener(Fragment fragment, Intent intent, int type);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.img_blog_thProfile:
                onProfileDialog();
                break;
            case R.id.img_blog_background:
                onBackgroundDialog();
                break;
            case R.id.btn_tab_art:
                test1();
                break;
            case R.id.btn_tab_favorite:
                test2();

                break;
            case R.id.btn_tab_culture:{
                Intent mIntent = new Intent(getContext(), BlogInCultureActivity.class);
                startActivity(mIntent);
                //CallbackListener.mActivityListener.onGoActivity(mIntent, DefineContentType.ACTIVITY_TYPE_FIXD_INFO);
                break;
            }
            case R.id.btn_tab_collabo: {
                //Toast.makeText(getContext(), "서비스 준비중입니다.", Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(getContext(), MainActivity.class);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SPACE);
                //mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
                startActivity(mIntent);
                break;
            }

            case R.id.btn_fanList:{
                Intent mIntent = new Intent(getContext(), SimpleTabUserListActivity.class);
                startActivity(mIntent);
                break;
            }
            case R.id.btn_imissyou:{
                if (isClick) {
                    Intent mIntent = new Intent(getContext(), SimpleSingleUserListActivity.class);
                    startActivity(mIntent);
                } else {
                    onConfirmDialog(v);
                    isClick = true;
                }
                break;
            }
            default:
                return;
        }
    }

    void test1() {
        mAdapter.removeAll();
        for (int idx = 0; idx < 20; idx++) {
            ContentData data = new ContentData();
            //data.thIMG = DefineTest.ARR_IMG[((int) (Math.random() * 10) % 8)];
            mAdapter.add(data);
        }
    }

    void test2() {
        mAdapter.removeAll();
        for (int idx = 0; idx < 8; idx++) {
            ContentData data = new ContentData();
            //data.thIMG = DefineTest.ARR_IMG2[idx];
            mAdapter.add(data);
        }
    }


}
