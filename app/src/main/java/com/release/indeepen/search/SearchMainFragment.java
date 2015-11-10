package com.release.indeepen.search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.release.indeepen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchMainFragment extends Fragment {


    public SearchMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_main, container, false);
    }


}
