package com.release.indeepen.content.comment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.release.indeepen.CallbackListener;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.blog.BlogMainFragment;

public class CommentListActivity extends AppCompatActivity {
    CommentAdapter mAdatper;
    ListView vList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);
        vList = (ListView) findViewById(R.id.list_comment);

        mAdatper = new CommentAdapter();

        vList.setAdapter(mAdatper);

        vList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //CallbackListener.mFragnetListener.onReplaceFragment(new BlogMainFragment(), DefineContentType.CALLBACK_TO_BLOG);
                Intent mIntent = new Intent(CommentListActivity.this, MainActivity.class);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_BLOG);
                //mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
                startActivity(mIntent);
                finish();
            }
        });

        init();
    }

    public void init() {
        for (int idx = 0; idx < 10; idx++) {
            CommentData data = new CommentData();
            data.sThPro = R.drawable.dog;
            data.sArtist = "예술가이름" + idx;
            data.sComment = "    훌륭합니다" + idx;
            data.sDate = "오늘";
            mAdatper.add(data);
        }
    }
}
