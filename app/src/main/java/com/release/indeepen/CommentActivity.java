package com.release.indeepen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class CommentActivity extends AppCompatActivity {
    ListView listView;
    CommentAdapter mCommentAdapter;
    EditText input_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        setTitle("댓글");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        listView = (ListView) findViewById(R.id.list_comment);


        listView = (ListView) findViewById(R.id.list_comment);
        mCommentAdapter = new CommentAdapter();
        listView.setAdapter(mCommentAdapter);
        Button btn = (Button) findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "댓글 추가하기", Toast.LENGTH_SHORT).show();

                initData();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = (String) listView.getItemAtPosition(position);
                Toast.makeText(CommentActivity.this, text + "블로그로 이동하기", Toast.LENGTH_SHORT).show();
            }
        });
        return;

    }

    private void initData() {
        for (int item = 0; item < 20; item++) {
            CommentItemData mData = new CommentItemData();
            mData.userimage = getResources().getDrawable(DefineTest.USER_IMG[item % 5]);
            mData.username = "Name: " + item + 1;
       //     String text = input_text.getText().toString();
            mData.comment = "text";

            mCommentAdapter.add(mData);
        }
    }

    public CommentAdapter getCommentAdapter() {
        return mCommentAdapter;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            switch (item.getItemId()) {
                case android.R.id.home:
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
