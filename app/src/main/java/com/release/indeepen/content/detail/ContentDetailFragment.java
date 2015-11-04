package com.release.indeepen.content.detail;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.release.indeepen.CallbackListener;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.R;
import com.release.indeepen.blog.BlogMainFragment;
import com.release.indeepen.content.art.ContentImageData;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentDetailFragment extends Fragment implements View.OnClickListener {

    ContentImageData mData;
    ListView vList;
    ImageView vThPro;
    TextView vTextArtist;
    SimpleImageAdapter mAdapter;

    public ContentDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content_detail, container, false);

        vList = (ListView) view.findViewById(R.id.list_detail_imgs);
        vThPro = (ImageView) view.findViewById(R.id.img_detail_image_thPro);
        vTextArtist = (TextView) view.findViewById(R.id.text_detail_image_artist);

        mAdapter = new SimpleImageAdapter();
        vList.setAdapter(mAdapter);

        vList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(getContext(), ExpandImageActivity.class);
                mIntent.putExtra(DefineContentType.EXPAND_IMG, (int) mAdapter.getItem(position));
                startActivity(mIntent);
            }
        });

        vThPro.setOnClickListener(this);

        init();
        return view;
    }

    private void init() {
        if (null != getArguments()) {
            mData = (ContentImageData) getArguments().getSerializable(DefineContentType.BUNDLE_DATA_DETAIL_IMAGE);
            setData(mData);
        }
    }

    private void setData(ContentImageData data) {

        vThPro.setImageResource(mData.thProfile);

        for (int idx = 0; idx < mData.arrIMGs.size(); idx++) {
            mAdapter.add(mData.arrIMGs.get(idx));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_detail_image_thPro:
            case R.id.text_detail_image_artist: {
                CallbackListener.mFragnetListener.onReplaceFragment(new BlogMainFragment(), DefineContentType.CALLBACK_TO_BLOG);
                getActivity().finish();
                break;
            }
        }
    }
}
