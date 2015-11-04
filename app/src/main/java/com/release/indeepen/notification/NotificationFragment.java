package com.release.indeepen.notification;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.release.indeepen.CallbackListener;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment implements MainActivity.OnKeyBackPressedListener, CallbackListener.OnGoActivityListener {
    FragmentManager mFM;
    boolean isFirst = false;

    public NotificationFragment() {
        // Required empty public constructor
    }

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
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        if (isFirst) {
            init();
            isFirst = false;
        }
        return view;
    }

    private void init() {
        mFM.beginTransaction().replace(R.id.container_notify, new NotificationMainFragment()).commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setOnKeyBackPressedListener(this);
        //CallbackListener.mFragnetListener = this;
    }

    @Override
    public void onBack() {
        if (((MainActivity) getActivity()).getOnKeyBackPressedListener() instanceof NotificationFragment) {
            if (mFM.getBackStackEntryCount() > 0) {
                mFM.popBackStack();
            } else {
                MainActivity activity = (MainActivity) getActivity();
                activity.setOnKeyBackPressedListener(null);
                activity.onBackPressed();
            }
        }
    }

    /*@Override
    public void onReplaceFragment(Fragment fragment, int Type) {
        switch (Type) {
            case DefineContentType.CALLBACK_TO_SINGLE_LIST: {
                mFM.beginTransaction().addToBackStack(null).replace(R.id.container_notify, fragment).commitAllowingStateLoss();
                break;
            }
            case DefineContentType.CALLBACK_TO_BLOG: {
                mFM.beginTransaction().addToBackStack(null).replace(R.id.container_notify, fragment).commitAllowingStateLoss();
                break;
            }
        }
    }*/

    @Override
    public void onGoActivity(Intent intent, int type) {
        switch (type) {

            case DefineContentType.CALLBACK_TO_BLOG: {
                startActivity(intent);
                break;
            }
        }
    }
}
