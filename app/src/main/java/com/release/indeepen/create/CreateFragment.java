package com.release.indeepen.create;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.release.indeepen.MainTab;
import com.release.indeepen.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFragment extends Fragment implements MainTab {


    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create, container, false);
        LinearLayout btn = (LinearLayout) view.findViewById(R.id.btn_create_image);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateInputCultureActivity.class);
                startActivity(intent);
            }
        });
        btn = (LinearLayout) view.findViewById(R.id.btn_create_picture);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateInputCultureActivity.class);
                startActivity(intent);
            }
        });
        btn = (LinearLayout) view.findViewById(R.id.btn_create_music);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateInputCultureActivity.class);
                startActivity(intent);
            }
        });
        btn = (LinearLayout) view.findViewById(R.id.btn_create_media);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateInputCultureActivity.class);
                startActivity(intent);
            }
        });
        btn = (LinearLayout) view.findViewById(R.id.btn_create_culture);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateInputCultureActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public int getContainer() {
        return 0;
    }
}
