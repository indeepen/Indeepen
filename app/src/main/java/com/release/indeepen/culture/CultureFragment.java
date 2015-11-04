package com.release.indeepen.culture;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.release.indeepen.MainTab;
import com.release.indeepen.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CultureFragment extends Fragment implements MainTab {


    public CultureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_culture, container, false);
        return view;
    }

    @Override
    public int getContainer() {
        return 0; // frameLayout 아이디로 수정
    }
}
