package com.release.indeepen.blog;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.content.ContentData;
import com.release.indeepen.content.tripleGrid.TripleGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyo on 2015-10-31.
 */
public class BlogAdapter extends BaseAdapter implements BlogIntroView.OnFragmentActionListener {

    List<ListData> items = new ArrayList<ListData>();
    OnIntroAdapterClickListener mListener;

    public BlogAdapter() {

    }

    @Override
    public void onFragmentActionListener(Fragment fragment, Intent intent, int type) {
//
    }

    public void setOnIntroAdapterListener(OnIntroAdapterClickListener listener) {
        mListener = listener;
    }

    public void add(ListData data) {
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof BlogIntroData) {
            return DefineContentType.BLOG_INTRO_PROFILE;
        } else {
            return DefineContentType.BLOG_INTRO_ART;
        }
    }

    @Override
    public int getViewTypeCount() {
        return DefineContentType.BLOG_TYPE_COUNT;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        switch (getItemViewType(position)) {
            case DefineContentType.BLOG_INTRO_PROFILE: {
                BlogIntroView view = (BlogIntroView) convertView;
                if (null == view) {
                    view = new BlogIntroView(parent.getContext());
                }
                view.setData((BlogIntroData) getItem(position));
                view.setOnFragmentAction(this);
                return view;
            }
            case DefineContentType.BLOG_INTRO_ART:
            default: {
                TripleGridView view = (TripleGridView) convertView;
                if (null == view) {
                    view = new TripleGridView(parent.getContext());
                }
                view.setData((ContentData) getItem(position));
                return view;
            }
        }
    }

    interface OnIntroAdapterClickListener {
        void onAdapterItemClick();
    }


}
