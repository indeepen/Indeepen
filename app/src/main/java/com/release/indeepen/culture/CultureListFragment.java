package com.release.indeepen.culture;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.release.indeepen.DefineTest;
import com.release.indeepen.R;
import com.release.indeepen.culture.CultureAdapter;
import com.release.indeepen.culture.CultureItemData;

/**
 * Created by Lady on 2015. 11. 5..
 */
public class CultureListFragment extends Fragment {

    ListView vList;
    CultureAdapter mAdapter;

    public CultureListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content_sing_list, container, false);


        vList = (ListView) view.findViewById(R.id.list_single);
        /*vList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), CultureDetailActivity.class);
                startActivity(intent);
            }
        })*/
        ;
        mAdapter = new CultureAdapter();
        vList.setAdapter(mAdapter);
        initData();
        return view;
    }


    private void initData() {
        for (int i = 0; i < 20; i++) {
            CultureItemData mData = new CultureItemData();
            mData.thIMG = DefineTest.USER_IMG[i % 5];
            mData.sArtist= "";
           // mData.dWriteDate = "11:00";
            mData.feeimage = getResources().getDrawable(R.drawable.th1);
            mData.ingimage = getResources().getDrawable(R.drawable.th2);
            mData.title = "";
            mData.mainimage = getResources().getDrawable(R.drawable.backsample);
            mData.date = "";
            mData.time = "";
            mData.address = "";
            mData.nLikeCount = i;
            mData.nCommentCount = i;
            // mData.tag = "";
            // mData.option = "";

            mAdapter.add(mData);
        }
    }


    public CultureAdapter getAdapter() {
        return mAdapter;
    }



}
