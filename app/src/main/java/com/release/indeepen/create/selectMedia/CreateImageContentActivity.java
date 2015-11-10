package com.release.indeepen.create.selectMedia;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.R;
import com.release.indeepen.content.art.ContentImageData;
import com.release.indeepen.content.art.detail.SimpleImageAdapter;
import com.release.indeepen.create.BlogData;
import com.release.indeepen.create.CreateHeader;

import java.io.File;

public class CreateImageContentActivity extends AppCompatActivity implements View.OnClickListener {

    ListView vListContent;
    CreateHeader vHeader;
    ImageView vImgBlog;
    TextView vTextBlog;
    EditText vInput_Content;
    PopupSelectBlog popupSelectBlog;
    BlogData mBlogData;
    SimpleImageAdapter mContentAdapter;
    Intent intent;
    RadioGroup vGruop;
    ContentImageData mCreateData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_image_content);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_create));
        getSupportActionBar().setTitle("이미지 선택");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vListContent = (ListView) findViewById(R.id.list_create_content_imgae);
        vHeader = new CreateHeader(this);
        vListContent.addHeaderView(vHeader);
        mContentAdapter = new SimpleImageAdapter();
        vListContent.setAdapter(mContentAdapter);

        vInput_Content = (EditText) vHeader.findViewById(R.id.input_create_content);
        vImgBlog = (ImageView) vHeader.findViewById(R.id.img_create_selected_blog);
        vTextBlog = (TextView) vHeader.findViewById(R.id.text_create_selected_blog);
        vGruop = (RadioGroup) vHeader.findViewById(R.id.group_emo);

        vImgBlog.setOnClickListener(this);
        vTextBlog.setOnClickListener(this);

        vGruop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int nEmo = 0;
                switch (checkedId) {
                    case R.id.img_create_emo_none: {
                        nEmo = 0;
                        break;
                    }
                    case R.id.img_create_emo_happy: {
                        nEmo = 1;
                        break;
                    }
                    case R.id.img_create_emo_love: {
                        nEmo = 2;
                        break;
                    }
                    case R.id.img_create_emo_sad: {
                        nEmo = 3;
                        break;
                    }
                    case R.id.img_create_emo_angry: {
                        nEmo = 4;
                        break;
                    }
                }
                mCreateData.nEmotion = nEmo;
            }
        });

        if(null != savedInstanceState){
            Bundle bundle = savedInstanceState.getBundle(DefineContentType.CREATE_SAVE);
            mCreateData =(ContentImageData) bundle.getSerializable(DefineContentType.CREATE_IMAGE_DATA);
            bundle.putSerializable(DefineContentType.CREATE_IMAGE_DATA, mCreateData);

            //복원 작업
        }

        init();
    }

    private void init() {
        mCreateData = new ContentImageData();
        intent = getIntent();

        mCreateData.arrIMGs = intent.getStringArrayListExtra(DefineContentType.BUNDLE_DATA_REQUEST);
        for (String path : mCreateData.arrIMGs) {
            Uri uri = Uri.fromFile(new File(path));
            mContentAdapter.add(uri.toString());

        }

                //Text
        vTextBlog.setText("블로그0");
       // Uri uri = Uri.fromFile(new File("android.resource://com.release.indeepen/drawable/dog"));
        /*Uri uri = Uri.parse("android.resource://com.release.indeepen/drawable/"+R.drawable.dog);*/
        String uri ="drawable://" + R.drawable.dog;
        ImageLoader.getInstance().displayImage(uri.toString(), vImgBlog);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_select_blog:
            case R.id.img_create_selected_blog:
            case R.id.text_create_selected_blog: {
                onPopupSelectBlog(findViewById(R.id.layout_select_blog));
                break;
            }
        }
    }

    private void onPopupSelectBlog(View view) {
        popupSelectBlog = new PopupSelectBlog(this);
        popupSelectBlog.setOutsideTouchable(true);
        popupSelectBlog.showAsDropDown(view);
        popupSelectBlog.vList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mBlogData = (BlogData) popupSelectBlog.mAdapter.getItem(position);
                mCreateData.sActiveBlogKey = mBlogData.sBlogkey;
                mCreateData.sArtist = mBlogData.sName;
                vTextBlog.setText(mBlogData.sName);
                if (!TextUtils.isEmpty(mBlogData.sIMGPath)) {
                    ImageLoader.getInstance().displayImage(mBlogData.sIMGPath.toString(), vImgBlog);
                }
                popupSelectBlog.dismiss();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case android.R.id.home: {
                super.onBackPressed();
            }
            case R.id.action_create: {
                mCreateData.nArtType = intent.getIntExtra(DefineContentType.BUNDLE_DATA_TYPE, -1);
                if(-1 != mCreateData.nArtType){
                    //정상등록
                }
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mCreateData.sText = vInput_Content.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DefineContentType.CREATE_IMAGE_DATA, mCreateData);
        outState.putBundle(DefineContentType.CREATE_SAVE, bundle);
    }

    @Override
    public void onBackPressed() {
        if (null != popupSelectBlog && popupSelectBlog.isShowing()) {
            popupSelectBlog.dismiss();
        } else {
            super.onBackPressed();
        }
    }
}
