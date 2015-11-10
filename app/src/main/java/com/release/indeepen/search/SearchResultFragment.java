package com.release.indeepen.search;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.content.ContentData;
import com.release.indeepen.content.art.tripleGrid.HeaderGridView;
import com.release.indeepen.content.art.tripleGrid.TripleGridAdapter;
import com.release.indeepen.fan.FanHeaderView;
import com.release.indeepen.fan.PopupCategory;
import com.release.indeepen.fan.PopupEmotion;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResultFragment extends Fragment {

    HeaderGridView vGrid;
    FanHeaderView vHeader;
    TripleGridAdapter mAdapter;
    public PopupEmotion emotion;
    public PopupCategory category;
    ImageView actionRealSearch;



    public SearchResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_result, container, false);

        actionRealSearch = (ImageView) getActivity().findViewById(R.id.img_main_real_search);

        vGrid = (HeaderGridView) view.findViewById(R.id.grid_search);
        vHeader = new FanHeaderView(getContext());
        vGrid.addHeaderView(vHeader);

        mAdapter = new TripleGridAdapter(getContext());
        vGrid.setAdapter(mAdapter);

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
        // Inflate the layout for this fragment
        return view;
    }

    private void init() {
        test1();

        vGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent mIntent = new Intent(getContext(), MainActivity.class);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_FAN_LIST);
                //mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 서버에 Data 받아올 URL
                startActivity(mIntent);

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        actionRealSearch.setVisibility(View.VISIBLE);
    }

    private void onPopupEmotion(View view){
        emotion = new PopupEmotion(getContext());
        emotion.setOutsideTouchable(false);
        emotion.showAsDropDown(view);

    }


    private void onPopupCategory(View view){
        category = new PopupCategory(getContext());
        category.setOutsideTouchable(true);
        category.showAsDropDown(view);
    }

    void test1() {
        mAdapter.removeAll();
        for (int idx = 0; idx < 20; idx++) {
            ContentData data = new ContentData();
            data.thIMG = DefineTest.ARR_IMG[((int) (Math.random() * 10) % 8)];
            mAdapter.add(data);
        }
    }

}
