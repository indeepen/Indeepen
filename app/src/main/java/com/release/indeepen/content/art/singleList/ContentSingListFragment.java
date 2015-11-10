package com.release.indeepen.content.art.singleList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.R;
import com.release.indeepen.content.art.ContentImageData;
import com.release.indeepen.content.art.ContentMusicData;
import com.release.indeepen.content.art.ContentVideoData;
import com.release.indeepen.content.art.ContentYoutubeData;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentSingListFragment extends Fragment {

    ListView vList;
    ContentSingleListAdapter mAdapter;

    public ContentSingListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content_sing_list, container, false);

        vList = (ListView) view.findViewById(R.id.list_single);

        mAdapter = new ContentSingleListAdapter();
        vList.setAdapter(mAdapter);


        init();
        return view;
    }

    private void init() {
        ContentYoutubeData youtubeData = new ContentYoutubeData();
        youtubeData.nArtType = DefineContentType.SINGLE_ART_TYPE_YOUTUBE;
        youtubeData.thProfile = DefineTest.ARR_IMG2[3];
        youtubeData.sPath = "YQHsXMglC9A";
        mAdapter.add(youtubeData);


        ContentMusicData musicData = new ContentMusicData();
        musicData.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC;
        musicData.thProfile = DefineTest.ARR_IMG2[3];
        musicData.sMusicBackIMG = DefineTest.ARR_IMG2[5];
        musicData.sMusicPath = "android.resource://com.release.indeepen/raw/sample";
        mAdapter.add(musicData);

        musicData = new ContentMusicData();
        musicData.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC;
        musicData.thProfile = DefineTest.ARR_IMG2[3];
        musicData.sMusicBackIMG = DefineTest.ARR_IMG2[2];
        musicData.sMusicPath = "android.resource://com.release.indeepen/raw/holdon";
        mAdapter.add(musicData);

        ContentVideoData data = new ContentVideoData();
        data.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC_VIDEO;
        data.thProfile = DefineTest.ARR_IMG2[2];
       // data.videoData = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, 7389);
        mAdapter.add(data);

        data = new ContentVideoData();
        data.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC_VIDEO;
        data.thProfile = DefineTest.ARR_IMG2[2];
       // data.videoData = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, 7391);
        mAdapter.add(data);


        for (int idx = 0; idx < 11; idx++) {
            ContentImageData mData = new ContentImageData();
            mData.nArtType = DefineContentType.SINGLE_ART_TYPE_PAINT;
            mData.thProfile = DefineTest.ARR_IMG2[idx % 8];
            mData.arrIMGs = Arrays.asList(DefineTest.ARR_PATH);
            mAdapter.add(mData);
        }
    }

}
