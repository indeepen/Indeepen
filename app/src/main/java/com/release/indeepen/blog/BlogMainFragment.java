package com.release.indeepen.blog;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.release.indeepen.R;
import com.release.indeepen.content.ContentData;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlogMainFragment extends Fragment implements BlogAdapter.OnIntroAdapterClickListener/*implements CallbackListener.OnGoActivityListener*/{
    ListView vRefreshList;
    BlogAdapter mBlogAdapter;

    @Override
    public void onAdapterItemClick() {
        //activity
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blog_main, container, false);
        vRefreshList = (ListView) view.findViewById(R.id.list_blog);

        mBlogAdapter = new BlogAdapter();
        vRefreshList.setAdapter(mBlogAdapter);

        init();

        return view;
    }

    private void init() {
        //CallbackListener.setOnGoActivityListener(this);
        mBlogAdapter.add(new BlogIntroData());
        mBlogAdapter.add(new ContentData());

        mBlogAdapter.setOnIntroAdapterListener(this);
    }


   /* @Override
    public void onGoActivity(Intent intent, int type) {

       *//* switch(intent.getIntExtra(DefineContentType.SELECT_IMAGE, -1)){
            case DefineContentType.ACTIVITY_TYPE_PROFILE_BACKGROUND:
            case DefineContentType.ACTIVITY_TYPE_PROFILE_IMG:
                startActivity(intent);
                break;
            case DefineContentType.ACTIVITY_TYPE_EXPANED_IMG:



        }*//*
        startActivity(intent);
    }*/


}
