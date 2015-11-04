package com.release.indeepen.fan;


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
import com.release.indeepen.content.singleList.ContentSingListFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FanFragment extends Fragment implements CallbackListener.OnReplaceFragmentListener, MainActivity.OnKeyBackPressedListener {

    FragmentManager mFM;
    ContentSingListFragment mSingleListF;
    boolean isFirst = false;

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
        View view = inflater.inflate(R.layout.fragment_fan, container, false);
        mSingleListF = new ContentSingListFragment();


        if (isFirst) {
            init();
            isFirst = false;
        }

        return view;
    }

    private void init() {
        mFM.beginTransaction().replace(R.id.container_fan, mSingleListF).commit();
    }

    @Override
    public void onReplaceFragment(Fragment fragment, int Type) {
        switch (Type) {

            case DefineContentType.CALLBACK_TO_SINGLE_LIST: {
                if (CallbackListener.mFragnetListener instanceof FanFragment) {
                    mFM.beginTransaction().addToBackStack(null).replace(R.id.container_fan, fragment).commitAllowingStateLoss();
                }
                break;
            }
            case DefineContentType.CALLBACK_TO_BLOG: {
                if (CallbackListener.mFragnetListener instanceof FanFragment) {
                    mFM.beginTransaction().addToBackStack(null).replace(R.id.container_fan, fragment).commitAllowingStateLoss();
                }
                break;
            }
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setOnKeyBackPressedListener(this);
        CallbackListener.mFragnetListener = this;
    }

    @Override
    public void onBack() {
        if (((MainActivity) getActivity()).getOnKeyBackPressedListener() instanceof FanFragment) {
            if (mFM.getBackStackEntryCount() > 0) {
                mFM.popBackStack();
            } else {
                MainActivity activity = (MainActivity) getActivity();
                activity.setOnKeyBackPressedListener(null);
                activity.onBackPressed();
            }
        }
    }
}
