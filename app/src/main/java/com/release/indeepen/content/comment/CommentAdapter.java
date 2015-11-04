package com.release.indeepen.content.comment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyo on 2015-11-03.
 */
public class CommentAdapter extends BaseAdapter {

    List<CommentData> items = new ArrayList<CommentData>();

    public void add(CommentData data){
        items.add(data);
        notifyDataSetChanged();
    }

    public void removeAll(){
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
        CommentView view = (CommentView)convertView;
        if(null == view){
            view = new CommentView(parent.getContext());
        }

        view.setData((CommentData)getItem(position));

        return view;
    }
}
