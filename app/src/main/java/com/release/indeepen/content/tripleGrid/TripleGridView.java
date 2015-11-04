package com.release.indeepen.content.tripleGrid;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.release.indeepen.CallbackListener;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.R;
import com.release.indeepen.blog.BlogInCultureActivity;
import com.release.indeepen.content.ContentData;
import com.release.indeepen.content.singleList.ContentSingListFragment;

/**
 * Created by Tacademy on 2015-10-30.
 */
public class TripleGridView  extends FrameLayout implements View.OnClickListener{


    TripleGridAdapter mAdapter;
    GridView vTripleGrid;
    Button vBtnArt, vBtnFavorite, vBtnMyCulture, vBtnCollabo;
    int cellWidth;
    int cellHeight;
    ContentData mData;
    ContentSingListFragment mSinglListFragment;
    Context mContext;
    CallbackListener.OnReplaceFragmentListener mFragnetListener;

    public TripleGridView(Context context) {
        super(context);
        mContext= context;
        init();
    }


    public TripleGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext= context;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_triple_grid, this);
        vTripleGrid = (GridView)findViewById(R.id.grid_item);
        vBtnArt = (Button) findViewById(R.id.btn_tab_art);
        vBtnFavorite = (Button) findViewById(R.id.btn_tab_favorite);
        vBtnMyCulture = (Button) findViewById(R.id.btn_tab_culture);
        vBtnCollabo = (Button) findViewById(R.id.btn_tab_collabo);

        //mListener = (MainActivity)mContext;

        vBtnArt.setOnClickListener(this);
        vBtnFavorite.setOnClickListener(this);
        vBtnMyCulture.setOnClickListener(this);
        vBtnCollabo.setOnClickListener(this);

        mAdapter = new TripleGridAdapter(getContext());
        vTripleGrid.setAdapter(mAdapter);

        mSinglListFragment = new ContentSingListFragment();



        vTripleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
  //              Bundle bundle = new Bundle();
  //              bundle.putSerializable(DefineContentType.FRAGMENT_SINGLE_LIST, (ContentData)mAdapter.getItem(position));
  //              mSinglListFragment.setArguments(bundle);
                if(null != CallbackListener.mFragnetListener ) {
                    CallbackListener.mFragnetListener.onReplaceFragment(new ContentSingListFragment(), DefineContentType.CALLBACK_TO_SINGLE_LIST);
                }

            }
        });

        test1();
    }

    public void setData(ContentData data){
        mData = data;
    }
    @Override
    public void onClick(View v) {
        mAdapter.removeAll();
        switch (v.getId()){

            case R.id.btn_tab_art:
                test1();
                break;
            case R.id.btn_tab_favorite:
                test2();

                break;
            case R.id.btn_tab_culture:
                Intent mIntent = new Intent(getContext(), BlogInCultureActivity.class);
                CallbackListener.mActivityListener.onGoActivity(mIntent, DefineContentType.ACTIVITY_TYPE_FIXD_INFO);
                break;
            case R.id.btn_tab_collabo:
                Toast.makeText(getContext(), "서비스 준비중입니다.", Toast.LENGTH_SHORT).show();
                break;
            default: return;
        }
    }

    void test1(){

        for(int idx=0; idx<20; idx++){
            ContentData data = new ContentData();
            data.thIMG = DefineTest.ARR_IMG[((int)(Math.random()*10)%8)];
            mAdapter.add(data);
        }
    }

    void test2(){

        for(int idx=0; idx<8; idx++){
            ContentData data = new ContentData();
            data.thIMG = DefineTest.ARR_IMG2[idx];
            mAdapter.add(data);
        }
    }

    /*  public void setItemData(String imgURL) {
        this.imgURL = imgURL;
        if (imgURL.icon != null) {
            iconView.setImageDrawable(data.icon);
        }
        titleView.setText(data.title);
        descView.setText(data.desc);
    }

    public void changeText() {
        if (mData == null) return;
        titleView.setText(mData.desc);
        descView.setText(mData.title);
    }*/

}
