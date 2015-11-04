package com.release.indeepen.blog.simpleList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.release.indeepen.CallbackListener;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.DefineTest;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;
import com.release.indeepen.blog.BlogMainFragment;
import com.release.indeepen.user.UserData;

public class SimpleSingleUserListActivity extends AppCompatActivity {

    ListView vList;
    SimpleUserListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_single_user_list);
        vList = (ListView) findViewById(R.id.list_simple_single);

        mAdapter = new SimpleUserListAdapter();

        vList.setAdapter(mAdapter);

        vList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //CallbackListener.mFragnetListener.onReplaceFragment(new BlogMainFragment(), DefineContentType.CALLBACK_TO_BLOG);
                Intent mIntent = new Intent(SimpleSingleUserListActivity.this, MainActivity.class);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.TYPE_ON_NEW_REPLACE);
                mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_BLOG);
                //mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
                startActivity(mIntent);

                finish();
            }
        });
        init();
    }

    private void init() {
        // mAdapter.removeAll();
        for (int idx = 0; idx < 13; idx++) {
            UserData data = new UserData();
            data.thProfile = DefineTest.ARR_IMG2[(int) (Math.random() * 10) % 8];
            data.sArtist = "이름 - " + idx;
            mAdapter.add(data);
        }
    }

}
