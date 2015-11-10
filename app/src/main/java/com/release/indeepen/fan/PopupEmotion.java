package com.release.indeepen.fan;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
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
public class PopupEmotion extends PopupWindow {
    Context mContext;

    public PopupEmotion(Context context) {
        super(context);
        // super(LayoutInflater.from(context).inflate(R.layout.popup_imissu, null), ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.popup_emotion, null);

        Button btn = (Button) view.findViewById(R.id.pop_emo_all);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.emo_all, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
                dismiss();
            }
        });

        btn = (Button) view.findViewById(R.id.pop_emo_empty);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.emo_empty, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
                dismiss();
            }
        });

        btn = (Button) view.findViewById(R.id.pop_emo_happy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.emo_happy, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
                dismiss();
            }
        });

        btn = (Button) view.findViewById(R.id.pop_emo_love);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.emo_love, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
            }
        });

        btn = (Button) view.findViewById(R.id.pop_emo_sad);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.emo_sad, Toast.LENGTH_SHORT).show();
//                Intent mIntent = new Intent(mContext, MainActivity.class);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_SINGLE_LIST);
//                mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
//                mContext.startActivity(mIntent);
                dismiss();
            }
        });

        btn = (Button) view.findViewById(R.id.pop_emo_angry);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.emo_angry, Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(mContext, MainActivity.class);
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

