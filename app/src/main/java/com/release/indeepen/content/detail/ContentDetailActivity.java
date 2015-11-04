package com.release.indeepen.content.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.release.indeepen.R;

public class ContentDetailActivity extends AppCompatActivity {


    ContentDetailImageFragment vfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_detail);

        vfragment = new ContentDetailImageFragment();
        vfragment.setArguments(getIntent().getExtras());

        getSupportFragmentManager().beginTransaction().replace(R.id.container_single_content, vfragment).commit();
    }
}
