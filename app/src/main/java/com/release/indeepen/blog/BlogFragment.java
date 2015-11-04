package com.release.indeepen.blog;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.MainTab;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends Fragment implements MainTab, MainActivity.OnKeyBackPressedListener {

    FragmentManager mFM;
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
        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        //CallbackListener.setOnReplaceFragmentListener(this);
        if (isFirst) {
            init();
            isFirst = false;
        }

        return view;
    }

    private void init() {
        mFM.beginTransaction().replace(R.id.container_blog, new BlogMainFragment()).commit();

    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setOnKeyBackPressedListener(this);
       // CallbackListener.mFragnetListener = this;
    }

  /*  @Override
    public void onReplaceFragment(Fragment fragment, int Type) {
        switch (Type) {

            case DefineContentType.CALLBACK_TO_SINGLE_LIST: {
                if (CallbackListener.mFragnetListener instanceof BlogFragment) {
                    mFM.beginTransaction().addToBackStack(null).replace(R.id.container_blog, fragment).commitAllowingStateLoss();
                }
                break;
            }
            case DefineContentType.CALLBACK_TO_BLOG: {
                if (CallbackListener.mFragnetListener instanceof BlogFragment) {
                    mFM.beginTransaction().addToBackStack(null).replace(R.id.container_blog, fragment).commitAllowingStateLoss();
                }
                break;
            }
        }
    }*/

    @Override
    public void onBack() {
        if (((MainActivity) getActivity()).getOnKeyBackPressedListener() instanceof BlogFragment) {
            if (mFM.getBackStackEntryCount() > 0) {
                mFM.popBackStack();
            } else {
                MainActivity activity = (MainActivity) getActivity();
                activity.setOnKeyBackPressedListener(null);
                activity.onBackPressed();
            }
        }
    }

    public int getContainer(){
        return R.id.container_blog;
    }

}
