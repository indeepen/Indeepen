package com.release.indeepen.notification;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.release.indeepen.CallbackListener;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.R;
import com.release.indeepen.content.detail.ContentDetailFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationMainFragment extends Fragment {

    NotiAdapter mNotiAdapter;
    ListView vNotiList;

    public NotificationMainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_notification, container, false);
        vNotiList = (ListView) view.findViewById(R.id.list_noti);

        mNotiAdapter = new NotiAdapter();
        vNotiList.setAdapter(mNotiAdapter);

        vNotiList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (CallbackListener.mFragnetListener instanceof NotificationFragment) {
                    CallbackListener.mFragnetListener.onReplaceFragment(new ContentDetailFragment(), DefineContentType.CALLBACK_TO_BLOG);
                }
            }
        });

        init();
        return view;
    }


    private void init() {

        for (int idx = 0; idx < 8; idx++) {
            PushData mData = new PushData();
            mData.nPushType = 1;
            mData.thProfile = DefineTest.ARR_IMG[idx];
            mData.sMSG = idx + "";
            mNotiAdapter.add(mData);
        }
    }


}
