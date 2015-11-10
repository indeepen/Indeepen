package com.release.indeepen.fan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.MainActivity;
import com.release.indeepen.MainTab;
import com.release.indeepen.R;
import com.release.indeepen.content.art.singleList.ContentSingListFragment;
import com.release.indeepen.search.SearchResultFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FanFragment extends Fragment implements MainTab, MainActivity.OnKeyBackPressedListener {

    FragmentManager mFM;
    boolean isFirst = false;
    ImageView actionSearch;
    ImageView actionRealSearch;

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
        actionSearch = (ImageView) getActivity().findViewById(R.id.img_main_search);
        actionRealSearch = (ImageView) getActivity().findViewById(R.id.img_main_real_search);
        if (isFirst) {
            init();
            isFirst = false;
        }

        mFM.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                checkBackStack();
            }
        });

        return view;
    }

    private void init() {
        mFM.beginTransaction().replace(R.id.container_fan, new FanMainFragment(), DefineContentType.FRAGMENT_TAG_FAN).commit();
    }
    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setOnKeyBackPressedListener(this);
        checkBackStack();

    }

    private void checkBackStack(){
        int stackHeight = mFM.getBackStackEntryCount();
        if (stackHeight > 0) { // if we have something on the stack (doesn't include the current shown fragment)
            ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
            ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            actionSearch.setVisibility(View.GONE);
        }else {
            ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(false);
            actionSearch.setVisibility(View.VISIBLE);
            actionRealSearch.setVisibility(View.GONE);
        }
    }


    @Override
    public void onBack() {
        boolean isPop = false;
        Fragment fragment = mFM.findFragmentByTag( DefineContentType.FRAGMENT_TAG_FAN);
        if(null != fragment){
            if(null != ((FanMainFragment)fragment).emotion  && ((FanMainFragment)fragment).emotion.isShowing()){
                ((FanMainFragment)fragment).emotion.dismiss();
                isPop =true;
            }
            if(null != ((FanMainFragment)fragment).category  &&((FanMainFragment)fragment).category.isShowing()){
                ((FanMainFragment)fragment).category.dismiss();
                isPop =true;
            }
        }
        fragment =  mFM.findFragmentByTag( DefineContentType.FRAGMENT_TAG_SEARCH);
        if(null != fragment ){
            if(null != ((SearchResultFragment)fragment).emotion  &&  ((SearchResultFragment)fragment).emotion.isShowing()){
                ((SearchResultFragment)fragment).emotion.dismiss();
                isPop =true;
            }
            if(null != ((SearchResultFragment)fragment).category  &&((SearchResultFragment)fragment).category.isShowing()){
                ((SearchResultFragment)fragment).category.dismiss();
                isPop =true;
            }
        }

        if(false == isPop) {
            if (((MainActivity) getActivity()).getOnKeyBackPressedListener() instanceof FanFragment) {
                popFragmentStack();
            }
        }
    }

    private void popFragmentStack(){
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

    @Override
    public int getContainer() {
        return R.id.container_fan;
    }
}
