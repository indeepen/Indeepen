package com.release.indeepen.content.tripleGrid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.release.indeepen.content.ContentData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyo on 2015-10-31.
 */
public class TripleGridAdapter extends BaseAdapter {

    List<ContentData> items = new ArrayList<ContentData>();
    Context mContext;

    public TripleGridAdapter(Context context) {
        this.mContext = context;
    }

    public void add(ContentData data) {
        items.add(data);
        notifyDataSetChanged();
    }

    public void removeAll() {
        items.clear();
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
        ThumbImageView view = (ThumbImageView) convertView;
        if (null == view) {
            view = new ThumbImageView(parent.getContext());
        }

        //view.setIMG(items.get(position).thIMG);

        view.setIMG(items.get(position).thIMG);
        return view;
    }


}