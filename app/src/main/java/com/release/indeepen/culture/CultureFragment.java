package com.release.indeepen.culture;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.release.indeepen.MainActivity;
import com.release.indeepen.MainTab;
import com.release.indeepen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CultureFragment extends Fragment
        implements MainActivity.OnKeyBackPressedListener,MainTab {

    CultureListFragment mListF;
    FragmentManager mFM;
    boolean isFirst = false;
    CultureLocalFragment mLocalF;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFirst = true;
        mFM = getChildFragmentManager();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_culture, container, false);
        mListF = new CultureListFragment();

        if (isFirst) {
            init();
            isFirst = false;
        }


        //임시


        Button btn = (Button) view.findViewById(R.id.btn_local);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLocalF = new CultureLocalFragment();
                mFM.beginTransaction().addToBackStack(null).replace(R.id.container_culture, mLocalF).commit();
            }
        });

        btn = (Button) view.findViewById(R.id.btn_date);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "달력넣기(dialog)", Toast.LENGTH_SHORT).show();
            }
        });

        btn = (Button) view.findViewById(R.id.btn_type);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), " popupwindow 추가", Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }

    private void init() {
        mFM.beginTransaction().replace(R.id.container_culture, mListF).commit();
    }


    @Override
    public void onResume() {
        super.onResume();
        if(getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).setOnKeyBackPressedListener(this);
        }
    }

    @Override
    public void onBack() {
        if (((MainActivity) getActivity()).getOnKeyBackPressedListener() instanceof CultureFragment) {
            if (mFM.getBackStackEntryCount() > 0) {
                mFM.popBackStack();
            } else {
                MainActivity activity = (MainActivity) getActivity();
                activity.setOnKeyBackPressedListener(null);
                activity.onBackPressed();
            }
        }
    }


    @Override
    public int getContainer() {
        return R.id.container_culture;
    }
}
