package com.release.indeepen.culture;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.release.indeepen.R;

public class CultureDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);


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
        /*@Override
        public void onBackPressed () {
            super.onBackPressed();

        }*/

}
