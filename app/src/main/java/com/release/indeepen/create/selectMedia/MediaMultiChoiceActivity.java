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
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.release.indeepen.DefineContentType;
import com.release.indeepen.R;

import java.io.File;
import java.util.ArrayList;

public class MediaMultiChoiceActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
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
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_select));
        getSupportActionBar().setTitle("이미지 선택");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vGridView = (GridView) findViewById(R.id.grid_single_choice);
        nCase = getIntent().getIntExtra(DefineContentType.SELECT_IMAGE, -1);
       // Button btn = (Button) findViewById(R.id.btn_select);

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

        vGridView.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE);
        vGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(6 == vGridView.getCheckedItemCount()){
                    vGridView.setItemChecked(position, false);
                    Toast.makeText(MediaMultiChoiceActivity.this, "한번에 최대 5장까지 선택 가능합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray array = vGridView.getCheckedItemPositions();
                ArrayList<String> arrPaths = new ArrayList<String>();
                for (int index = 0; index < array.size(); index++) {
                    int position = array.keyAt(index);
                    if (array.get(position)) {
                        Cursor c = (Cursor) vGridView.getItemAtPosition(position);
                        String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
                        arrPaths.add(path);
                    }
                }

                Intent mIntent = new Intent(MediaMultiChoiceActivity.this, CreateImageContentActivity.class);
                mIntent.putStringArrayListExtra(DefineContentType.BUNDLE_DATA_REQUEST, arrPaths);

                switch (nCase) {
                    case DefineContentType.SINGLE_ART_TYPE_PAINT: {
                        mIntent.putExtra(DefineContentType.BUNDLE_DATA_TYPE, DefineContentType.SINGLE_ART_TYPE_PAINT);
                        break;
                    }
                    case DefineContentType.SINGLE_ART_TYPE_PICTURE: {
                        mIntent.putExtra(DefineContentType.BUNDLE_DATA_TYPE, DefineContentType.SINGLE_ART_TYPE_PICTURE);
                        break;
                    }
                    case DefineContentType.SINGLE_ART_TYPE_MUSIC_PICTURE: {
                        mIntent.putExtra(DefineContentType.BUNDLE_DATA_TYPE, DefineContentType.SINGLE_ART_TYPE_MUSIC_PICTURE);
                        break;
                    }

                }
                startActivity(mIntent);
            }
        });*/
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
        getMenuInflater().inflate(R.menu.menu_select, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }else if (id == R.id.action_next) {
            SparseBooleanArray array = vGridView.getCheckedItemPositions();
            ArrayList<String> arrPaths = new ArrayList<String>();
            for (int index = 0; index < array.size(); index++) {
                int position = array.keyAt(index);
                if (array.get(position)) {
                    Cursor c = (Cursor) vGridView.getItemAtPosition(position);
                    String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
                    arrPaths.add(path);
                }
            }

            Intent mIntent = new Intent(MediaMultiChoiceActivity.this, CreateImageContentActivity.class);
            mIntent.putStringArrayListExtra(DefineContentType.BUNDLE_DATA_REQUEST, arrPaths);

            switch (nCase) {
                case DefineContentType.SINGLE_ART_TYPE_PAINT: {
                    mIntent.putExtra(DefineContentType.BUNDLE_DATA_TYPE, DefineContentType.SINGLE_ART_TYPE_PAINT);
                    break;
                }
                case DefineContentType.SINGLE_ART_TYPE_PICTURE: {
                    mIntent.putExtra(DefineContentType.BUNDLE_DATA_TYPE, DefineContentType.SINGLE_ART_TYPE_PICTURE);
                    break;
                }
                case DefineContentType.SINGLE_ART_TYPE_MUSIC_PICTURE: {
                    mIntent.putExtra(DefineContentType.BUNDLE_DATA_TYPE, DefineContentType.SINGLE_ART_TYPE_MUSIC_PICTURE);
                    break;
                }

            }
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
