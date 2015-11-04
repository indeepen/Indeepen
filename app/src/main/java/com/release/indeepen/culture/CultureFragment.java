package com.release.indeepen.culture;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.release.indeepen.DefineTest;
import com.release.indeepen.MainTab;
import com.release.indeepen.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CultureFragment extends Fragment implements MainTab {


    ListView listView;
    CultureAdapter mAdapter;
    TextView text;

    public CultureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_culture, container, false);

        //임시
        Button btn = (Button) view.findViewById(R.id.btn_local);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), " fragment change", Toast.LENGTH_SHORT).show();
            }
        });

        btn = (Button)view.findViewById(R.id.btn_date);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"달력넣기(dialog)", Toast.LENGTH_SHORT).show();
            }
        });

        btn = (Button)view.findViewById(R.id.btn_type);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext()," popupwindow 추가", Toast.LENGTH_SHORT).show();
            }
        });


//                Intent intent = new Intent(getActivity(), CommentActivity.class);
//                startActivity(intent);

        listView = (ListView) view.findViewById(R.id.list_culture);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), CultureDetailActivity.class);
                startActivity(intent);
            }
        });
        mAdapter = new CultureAdapter();
        listView.setAdapter(mAdapter);
        initData();
        return view;

    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            CultureItemData mData = new CultureItemData();
            mData.userimage = getResources().getDrawable(DefineTest.USER_IMG[i % 5]);
            mData.username = "이름"+(i+1);
            mData.uploadtime = "11:00";
            mData.feeimage = getResources().getDrawable(R.drawable.th1);
            mData.ingimage = getResources().getDrawable(R.drawable.th2);
            mData.title = "";
            mData.mainimage = getResources().getDrawable(R.drawable.backsample);
            mData.date = "";
            mData.time = "";
            mData.address = "";
            mData.like = "";
            mData.comment = "댓글 "+i;
            // mData.tag = "";
            // mData.option = "";

            mAdapter.add(mData);
        }
    }

    @Override
    public int getContainer() {
        return 0; // frameLayout 아이디로 수정
    }
}
