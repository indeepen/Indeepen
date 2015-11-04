package com.release.indeepen.blog.simpleList;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.user.UserData;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleUserListFragment extends Fragment {

    ListView vList;
    SimpleUserListAdapter mAdapter;

    public SimpleUserListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_user_list, container, false);
        vList = (ListView) view.findViewById(R.id.list_simple_user);
        mAdapter = new SimpleUserListAdapter();
        vList.setAdapter(mAdapter);
        init();

        vList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(getContext(), MainActivity.class);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_BLOG);
                //mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
                startActivity(mIntent);
            }
        });


        return view;
    }


    private void init() {
        // mAdapter.removeAll();
        for (int idx = 0; idx < 13; idx++) {
            UserData data = new UserData();
            data.thProfile = DefineTest.ARR_IMG2[(int) (Math.random() * 10) % 8];
            data.sArtist = "이름 - " + idx;
            mAdapter.add(data);
        }
    }


}
