package com.release.indeepen.content.singleList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.content.ContentData;
import com.release.indeepen.content.art.ContentImageData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyo on 2015-11-01.
 */
public class ContentSingleListAdapter extends BaseAdapter {

    List<ContentData> items = new ArrayList<ContentData>();

    public void add(ContentData data) {
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {

        switch (((ContentData) getItem(position)).nArtType) {
            case DefineContentType.SINGLE_ART_TYPE_PAINT:
            case DefineContentType.SINGLE_ART_TYPE_PICTURE:
            case DefineContentType.SINGLE_ART_TYPE_MUSIC_PICTURE:
                return DefineContentType.SINGLE_IMAGE;

            case DefineContentType.SINGLE_ART_TYPE_MUSIC:
                return DefineContentType.SINGLE_MUSIC;

            case DefineContentType.SINGLE_ART_TYPE_MUSIC_VIDEO:
                return DefineContentType.SINGLE_VIDEO;

            case DefineContentType.SINGLE_ART_TYPE_VIDEO:
                return DefineContentType.SINGLE_YOUTUBE;
            case DefineContentType.SINGLE_ART_TYPE_CULTURE:
                return DefineContentType.SINGLE_CULTURE;
            default:
                return -1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return DefineContentType.SINGLE_TYPE_COUNT;
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
        int nType = getItemViewType(position);

        switch (nType) {
            case DefineContentType.SINGLE_IMAGE:
            default: {
                SingleImageView view = (SingleImageView) convertView;
                if (null == view) {
                    view = new SingleImageView(parent.getContext());
                }
                view.setData((ContentImageData) items.get(position));

                return view;
            }
            /*case DefineContentType.SINGLE_MUSIC:{
                return;
            }
            case DefineContentType.SINGLE_VIDEO:{
                return;
            }
            case DefineContentType.SINGLE_YOUTUBE:{
                return;
            }*/
        }
    }
}
