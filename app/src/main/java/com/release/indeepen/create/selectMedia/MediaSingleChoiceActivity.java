package com.release.indeepen.create.selectMedia;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.MainActivity;
import com.release.indeepen.R;

import java.io.File;

public class MediaSingleChoiceActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    String[] projection = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA};
    String sortOrder = MediaStore.Images.Media.DATE_ADDED + " ASC";

    GridView vGridView;
    SimpleCursorAdapter mAdapter;

    int nCase;

    int dataColumnIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_single_choice);
        vGridView = (GridView) findViewById(R.id.grid_single_choice);
        nCase = getIntent().getIntExtra(DefineContentType.SELECT_IMAGE, -1);
        Button btn = (Button) findViewById(R.id.btn_select);

        getSupportLoaderManager().initLoader(0, null, this);

        String[] from = {MediaStore.Images.Media.DATA};
        int[] to = {R.id.image_icon};

        mAdapter = new SimpleCursorAdapter(this, R.layout.view_checked_item, null, from, to, 0);

        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
                if (columnIndex == dataColumnIndex) {
                    ImageView iv = (ImageView) view;

                    String path = cursor.getString(columnIndex);
                    Uri uri = Uri.fromFile(new File(path));
                    ImageLoader.getInstance().displayImage(uri.toString(), iv);
                    return true;
                }
                return false;
            }
        });

        vGridView.setAdapter(mAdapter);

        switch (nCase) {
            case DefineContentType.ACTIVITY_TYPE_PROFILE_BACKGROUND:
            case DefineContentType.ACTIVITY_TYPE_PROFILE_IMG: {
                vGridView.setChoiceMode(GridView.CHOICE_MODE_SINGLE);
            }
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (nCase) {
                    case DefineContentType.ACTIVITY_TYPE_PROFILE_BACKGROUND: {
                        String path = getSingleImage();

                        Intent mIntent = new Intent(MediaSingleChoiceActivity.this, MainActivity.class);
                        mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.ACTIVITY_TYPE_PROFILE_BACKGROUND);
                        mIntent.putExtra(DefineContentType.KEY_ON_NEW_PUT_DATA, path); // 서버에 요청할 Data URL
                        //mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
                        startActivity(mIntent);
                        finish();
                        break;
                    }
                    case DefineContentType.ACTIVITY_TYPE_PROFILE_IMG: {
                        String path = getSingleImage();

                        Intent mIntent = new Intent(MediaSingleChoiceActivity.this, MainActivity.class);
                       // mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.ACTIVITY_TYPE_PROFILE_IMG);
                       // mIntent.putExtra(DefineContentType.KEY_ON_NEW_WHERE, DefineContentType.TO_BLOG);
                        mIntent.putExtra(DefineContentType.KEY_ON_NEW_REQUEST, DefineContentType.ACTIVITY_TYPE_PROFILE_IMG);
                        mIntent.putExtra(DefineContentType.KEY_ON_NEW_PUT_DATA, path); // 서버에 요청할 Data URL
                        //mIntent.putExtra(DefineContentType.KEY_ON_NEW_GET_DATA_URL, ); // 이동시 다시 받아올 Data URL
                        startActivity(mIntent);
                        finish();
                        break;
                    }
                }

              /*  SparseBooleanArray array = vGridView.getCheckedItemPositions();
                List<String> pathList = new ArrayList<String>();
                for (int index = 0; index < array.size(); index++) {
                    int position = array.keyAt(index);
                    if (array.get(position)) {
                        Cursor c = (Cursor) vGridView.getItemAtPosition(position);
                        String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
                        pathList.add(path);
                    }
                }*/

            }
        });
    }

    private String getSingleImage() {
        Cursor c = (Cursor) vGridView.getItemAtPosition(vGridView.getCheckedItemPosition());
        return c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        return new CursorLoader(this, uri, projection, null, null, sortOrder);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        dataColumnIndex = data.getColumnIndex(MediaStore.Images.Media.DATA);
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
