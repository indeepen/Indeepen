package com.release.indeepen.blog;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.R;
import com.release.indeepen.blog.simpleList.TabsAdapter;
import com.release.indeepen.content.singleList.ContentSingListFragment;

public class BlogInCultureActivity extends AppCompatActivity {


    TabHost tabHost;
    ViewPager pager;
    TabsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_in_culture);

        tabHost = (TabHost)findViewById(R.id.tabHost_in_blog);
        tabHost.setup();
        pager = (ViewPager)findViewById(R.id.pager_in_blog);
        mAdapter = new TabsAdapter(this, getSupportFragmentManager(), tabHost, pager);

        mAdapter.addTab(tabHost.newTabSpec(DefineContentType.BLOG_MY_CULTURE).setIndicator(DefineContentType.BLOG_MY_CULTURE),ContentSingListFragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec(DefineContentType.BLOG_LIKE_CULTURE).setIndicator(DefineContentType.BLOG_LIKE_CULTURE), ContentSingListFragment.class, null);

        if (savedInstanceState != null) {
            tabHost.setCurrentTab(savedInstanceState.getInt("tabIndex"));
            mAdapter.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("tabIndex", tabHost.getCurrentTab());
        mAdapter.onSaveInstanceState(outState);
    }
}
