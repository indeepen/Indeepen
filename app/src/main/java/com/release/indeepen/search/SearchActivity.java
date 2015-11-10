package com.release.indeepen.search;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TabHost;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.R;
import com.release.indeepen.blog.simpleList.SimpleUserListFragment;
import com.release.indeepen.blog.simpleList.TabsAdapter;

public class SearchActivity extends AppCompatActivity {
    TabHost tabHost;
    ViewPager pager;
    TabsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_search));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        pager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new TabsAdapter(this, getSupportFragmentManager(), tabHost, pager);

        mAdapter.addTab(tabHost.newTabSpec(DefineContentType.SEARCH_TAB_ALL).setIndicator(DefineContentType.SEARCH_TAB_ALL), SearchMainFragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec(DefineContentType.SEARCH_TAB_TAG).setIndicator(DefineContentType.SEARCH_TAB_TAG), SearchMainFragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec(DefineContentType.SEARCH_TAB_ARTIST).setIndicator(DefineContentType.SEARCH_TAB_ARTIST), SearchMainFragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec(DefineContentType.SEARCH_TAB_SPACE).setIndicator(DefineContentType.SEARCH_TAB_SPACE), SearchMainFragment.class, null);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
