package com.release.indeepen.fan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.R;
import com.release.indeepen.content.singleList.ContentSingListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FanMainFragment extends Fragment {

    FragmentManager mFM;
    ContentSingListFragment mSLFragment;

    public FanMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fan_main, container, false);
        mFM = getChildFragmentManager();
        mFM.beginTransaction().add(R.id.container_fan, new ContentSingListFragment(), DefineContentType.FRAGMENT_SINGLE_LIST).commit();
        mSLFragment = (ContentSingListFragment) mFM.findFragmentByTag(DefineContentType.FRAGMENT_SINGLE_LIST);

        return view;
    }


}
