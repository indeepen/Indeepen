package com.release.indeepen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lady on 2015. 11. 2..
 */
public class CommentAdapter  extends BaseAdapter implements  CommentItemView.OnImageClickListener {
    List<CommentItemData> items = new ArrayList<CommentItemData>();

    public interface OnAdapterImageListener {
        public void onAdapterImageClick(CommentAdapter adapter, CommentItemView view, CommentItemData data);
    }
    OnAdapterImageListener mListener;
    public void setOnAdapterImageListener(OnAdapterImageListener listener) {
        mListener = listener;
    }

    CommentItemView.OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(CommentItemView.OnImageClickListener listener) {
        mImageClickListener = listener;
        notifyDataSetChanged();
        notifyDataSetInvalidated();
    }

    public void add(CommentItemData item) {
        items.add(item);
        notifyDataSetChanged();
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
        CommentItemView view;
        if (convertView == null) {
            view =  new CommentItemView(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (CommentItemView) convertView;
        }
        view.setItemData(items.get(position));
        return view;
    }

    @Override
    public void onImageClick(CommentItemView view, CommentItemData data) {
        if (mListener != null) {
            mListener.onAdapterImageClick(this, view, data);
        }
    }
}

