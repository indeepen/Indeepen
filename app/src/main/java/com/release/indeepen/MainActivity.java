package com.release.indeepen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.Toast;

import com.release.indeepen.blog.BlogFragment;
import com.release.indeepen.create.CreateFragment;
import com.release.indeepen.culture.CultureFragment;
import com.release.indeepen.fan.FanFragment;
import com.release.indeepen.notification.NotificationFragment;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity { //implements CallbackListener.OnGoActivityListener{

    FragmentTabHost vTabHost;
    FrameLayout vContainer;
    FragmentManager mFM;

    boolean isClose = false;
    private OnKeyBackPressedListener mOnKeyBackPressedListener;

    public static MainActivity getInstance() {
        return new MainActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (null != savedInstanceState) {

        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vContainer = (FrameLayout) findViewById(R.id.realtabcontent);
        mFM = getSupportFragmentManager();
        vTabHost = (FragmentTabHost) findViewById(R.id.tabHost);
        vTabHost.setup(this, mFM, R.id.realtabcontent);

        vTabHost.addTab(vTabHost.newTabSpec(DefineContentType.MAIN_TAB_CULTURE).setIndicator(DefineContentType.MAIN_TAB_CULTURE), CultureFragment.class, null);
        vTabHost.addTab(vTabHost.newTabSpec(DefineContentType.MAIN_TAB_FAN).setIndicator(DefineContentType.MAIN_TAB_FAN), FanFragment.class, null);
        vTabHost.addTab(vTabHost.newTabSpec(DefineContentType.MAIN_TAB_CREATE).setIndicator(DefineContentType.MAIN_TAB_CREATE), CreateFragment.class, null);
        vTabHost.addTab(vTabHost.newTabSpec(DefineContentType.MAIN_TAB_NOTIFICATION).setIndicator(DefineContentType.MAIN_TAB_NOTIFICATION), NotificationFragment.class, null);
        vTabHost.addTab(vTabHost.newTabSpec(DefineContentType.MAIN_TAB_MYBLOG).setIndicator(DefineContentType.MAIN_TAB_MYBLOG), BlogFragment.class, null);

        vTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // Toast.makeText(MainActivity.this, tabId, Toast.LENGTH_SHORT).show();

                //mFM.popBackStackImmediate(null, mFM.POP_BACK_STACK_INCLUSIVE);

                // mFM.beginTransaction().attach(mFM.findFragmentByTag(tabId));

            }
        });

        //CallbackListener.mActivityListener = this;

        vTabHost.getTabWidget().setBackgroundColor(Color.parseColor("#4a3d63"));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (null != intent) {
            Toast.makeText(MainActivity.this, intent.getStringExtra("path"), Toast.LENGTH_SHORT).show();
            /*switch(intent.getIntExtra(DefineContentType.KEY_ON_NEW_REQUEST,-1)){
                case DefineContentType.TYPE_ON_NEW_REPLACE:{ // 리플레이스 요청
                    goActivity(intent.getSerializableExtra(DefineContentType.KEY_ON_NEW_ACTIVITY_DATA));
                    break;
                }
                case DefineContentType.TYPE_ON_NEW_ACTIVITI:{ // 스타트 액티비티 요청
                    goFragment(intent.getSerializableExtra(DefineContentType.KEY_ON_NEW_FRAGMENT_DATA));
                    break;
                }
            }*/
        }
    }

    private void goActivity(Serializable data) {

    }

    private void goFragment(Serializable data) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mOnKeyBackPressedListener != null) {
            mOnKeyBackPressedListener.onBack();
            return;
        }
        if (mFM.getBackStackEntryCount() > 0) {
            mFM.popBackStack();
        } else if (mFM.getBackStackEntryCount() == 0) {
            if (isClose) {
                super.onBackPressed();
            } else {
                vTabHost.setCurrentTabByTag(DefineContentType.MAIN_TAB_CULTURE);
                isClose = true;
            }

        }
    }

    public OnKeyBackPressedListener getOnKeyBackPressedListener() {
        return mOnKeyBackPressedListener;
    }

    public void setOnKeyBackPressedListener(OnKeyBackPressedListener listener) {
        mOnKeyBackPressedListener = listener;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public interface OnKeyBackPressedListener {
        void onBack();
    }


}
