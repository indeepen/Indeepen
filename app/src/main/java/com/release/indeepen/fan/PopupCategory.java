package com.release.indeepen.fan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;

/**
 * Created by lyo on 2015-11-05.
 */
public class PopupCategory extends PopupWindow {
    Context mContext;

    public PopupCategory(Context context) {
        super(context);
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.popup_category, null);

        Button btn = (Button) view.findViewById(R.id.pop_cate_all);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.cate_all, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
                dismiss();
            }
        });

        btn = (Button) view.findViewById(R.id.pop_cate_paint);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.cate_paint, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
                dismiss();
            }
        });

        btn = (Button) view.findViewById(R.id.pop_cate_picture);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.cate_picture, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
                dismiss();
            }
        });

        btn = (Button) view.findViewById(R.id.pop_cate_music);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.cate_music, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
                dismiss();
            }
        });

        btn = (Button) view.findViewById(R.id.pop_cate_video);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.cate_video, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
                dismiss();
            }
        });

        btn = (Button) view.findViewById(R.id.pop_cate_culture);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.cate_culture, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
                dismiss();
            }
        });
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
    }
}

