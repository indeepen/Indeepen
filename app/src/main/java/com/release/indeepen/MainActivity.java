package com.release.indeepen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.release.indeepen.blog.BlogMainFragment;
import com.release.indeepen.content.detail.ContentDetailImageFragment;
import com.release.indeepen.content.singleList.ContentSingListFragment;
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
        Toast.makeText(MainActivity.this, "메인확인", Toast.LENGTH_SHORT).show();
        String sGetURL = null;
        Serializable mPutData = null;
        Serializable mGetData = null;


        if (null != intent) {

            mPutData = intent.getStringExtra(DefineContentType.KEY_ON_NEW_PUT_DATA);
            sGetURL = intent.getStringExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL);

            if(null != mPutData) {
               // 서버에게 업데이트할 데이터 보내는 작업

            }
            if(null != sGetURL){
                // 페이지 이동시 페이지에 보일 Data 서버로부터 가져오는 작업
               // mGetData = ;  // json 파싱한 결과물
            }

            switch(intent.getIntExtra(DefineContentType.KEY_ON_NEW_REQUEST,-1)){
                case DefineContentType.TYPE_ON_NEW_REPLACE:{ // 리플레이스 요청
                    goFragment(intent, mGetData);
                    break;
                }
                case DefineContentType.TYPE_ON_NEW_ACTIVITY:{ // 스타트 액티비티 요청
                    //goActivity(intent.getSerializableExtra(DefineContentType.KEY_ON_NEW_ACTIVITY_DATA));
                    break;
                }
                case DefineContentType.ACTIVITY_TYPE_PROFILE_BACKGROUND:{ //
                    Toast.makeText(MainActivity.this, mPutData+"", Toast.LENGTH_SHORT).show();

                    break;
                }
                case DefineContentType.ACTIVITY_TYPE_FIXD_INFO:{ //
                    Toast.makeText(MainActivity.this, "프로필수정처리", Toast.LENGTH_SHORT).show();
                    break;
                }
                case DefineContentType.ACTIVITY_TYPE_PROFILE_IMG:{ //
                    Toast.makeText(MainActivity.this, mPutData+"", Toast.LENGTH_SHORT).show();

                    break;
                }

            }
        }
    }

    private void goActivity(Intent intent, Serializable data) {
        switch (intent.getIntExtra(DefineContentType.KEY_ON_NEW_WHERE , -1)){

        }

    }

    private void goFragment(Intent intent, Serializable data) {
        Fragment fragment = mFM.findFragmentByTag(vTabHost.getCurrentTabTag());


        switch (intent.getIntExtra(DefineContentType.KEY_ON_NEW_WHERE , -1)){
            case DefineContentType.TO_SINGLE_LIST:
                fragment.getChildFragmentManager().beginTransaction().addToBackStack(null).replace(((MainTab)fragment).getContainer(), new ContentSingListFragment()).commitAllowingStateLoss();
                break;
            case DefineContentType.TO_BLOG: {
                fragment.getChildFragmentManager().beginTransaction().addToBackStack(null).replace(((MainTab)fragment).getContainer(), new BlogMainFragment()).commitAllowingStateLoss();
                break;
            }
            /*case DefineContentType.ACTIVITY_TYPE_PROFILE_BACKGROUND: {
                fragment.getChildFragmentManager().beginTransaction().replace(((BlogFragment) fragment).getContainer(), new BlogMainFragment()).commit();
                break;
            }case DefineContentType.ACTIVITY_TYPE_PROFILE_IMG: {
                fragment.getChildFragmentManager().beginTransaction().replace(((BlogFragment) fragment).getContainer(), new BlogMainFragment()).commit();
                break;
            }*/
            case DefineContentType.TO_DETAIL_IMGAE:{
                fragment.getChildFragmentManager().beginTransaction().addToBackStack(null).replace(((MainTab)fragment).getContainer(), new ContentDetailImageFragment()).commitAllowingStateLoss();
                break;
            }
            case DefineContentType.TO_DETAIL_MUSIC_VIDEO:{
                break;
            }
            case DefineContentType.TO_DETAIL_MUSIC:{
                break;
            }
            case DefineContentType.TO_DETAIL_YOUTUBE:{
                break;
            }
            case DefineContentType.TO_DETAIL_CULTURE:{
                break;
            }
        }

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
