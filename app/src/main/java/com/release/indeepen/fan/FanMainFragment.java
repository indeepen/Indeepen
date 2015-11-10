package com.release.indeepen.fan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.R;
import com.release.indeepen.content.art.ContentImageData;
import com.release.indeepen.content.art.ContentMusicData;
import com.release.indeepen.content.art.ContentVideoData;
import com.release.indeepen.content.art.singleList.ContentSingListFragment;
import com.release.indeepen.content.art.singleList.ContentSingleListAdapter;
import com.release.indeepen.content.art.tripleGrid.HeaderGridView;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class FanMainFragment extends Fragment {

    ListView vList;
    ContentSingleListAdapter mAdapter;
    FanHeaderView vHeader;
    PopupEmotion emotion;
    PopupCategory category;
    public FanMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fan_main, container, false);
        vList = (ListView) view.findViewById(R.id.list_fan);
        vHeader = new FanHeaderView(getContext());
        vList.getHeaderViewsCount();
        vList.addHeaderView(vHeader);
        vList.setHeaderDividersEnabled(false);
        mAdapter = new ContentSingleListAdapter();
        vList.setAdapter(mAdapter);


        Button btn = (Button) vHeader.findViewById(R.id.btn_fan_emotion);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPopupEmotion(v);
            }
        });

        btn = (Button) vHeader.findViewById(R.id.btn_fan_category);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPopupCategory(v);
            }
        });

        init();
        return view;
    }

    private void init() {


        for (int idx = 0; idx < 3; idx++) {
            ContentImageData mData = new ContentImageData();
            mData.nArtType = DefineContentType.SINGLE_ART_TYPE_PAINT;
            mData.thProfile = DefineTest.ARR_IMG2[idx % 8];
            mData.arrIMGs = Arrays.asList(DefineTest.ARR_PATH);
            mAdapter.add(mData);
        }

        ContentMusicData musicData = new ContentMusicData();
        musicData.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC;
        musicData.thProfile = DefineTest.ARR_IMG2[3];
        musicData.sMusicBackIMG = DefineTest.ARR_IMG2[1];
        musicData.sMusicPath = "android.resource://com.release.indeepen/raw/sample";
        mAdapter.add(musicData);

        musicData = new ContentMusicData();
        musicData.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC;
        musicData.thProfile = DefineTest.ARR_IMG2[3];
        musicData.sMusicBackIMG = DefineTest.ARR_IMG2[7];
        musicData.sMusicPath = "android.resource://com.release.indeepen/raw/holdon";
        mAdapter.add(musicData);

        ContentVideoData data = new ContentVideoData();
        data.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC_VIDEO;
        data.thProfile = DefineTest.ARR_IMG2[2];
        // data.videoData = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, 7389);
        mAdapter.add(data);
    }

    private void onPopupEmotion(View view){
        emotion = new PopupEmotion(getContext());
        emotion.setOutsideTouchable(true);
        emotion.showAsDropDown(view);

    }

    private void onPopupCategory(View view){
        category = new PopupCategory(getContext());
        category.setOutsideTouchable(true);
        category.showAsDropDown(view);
    }

}
