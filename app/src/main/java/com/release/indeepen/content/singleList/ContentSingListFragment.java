package com.release.indeepen.content.singleList;


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

    private void init(){
        for(int idx=0; idx< 5; idx++) {
            ContentImageData mData = new ContentImageData();
            mData.nArtType = DefineContentType.SINGLE_ART_TYPE_PAINT;
            mData.thProfile = DefineTest.ARR_IMG2[idx%8];
            mData.arrIMGs = Arrays.asList(DefineTest.ARR_IMG);
            mAdapter.add(mData);
        }
    }

    public ContentSingleListAdapter getAdapter(){
        return mAdapter;
    }

}
