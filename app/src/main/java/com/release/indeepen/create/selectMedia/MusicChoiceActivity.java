package com.release.indeepen.create.selectMedia;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.release.indeepen.R;

import java.io.File;

public class MusicChoiceActivity extends AppCompatActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<Cursor>{

    ListView vList;
    SimpleCursorAdapter mAdapter;
    int dataColumnIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_choice);

        vList = (ListView) findViewById(R.id.list_create_music);
        mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, null, new String[]{MediaStore.Audio.Media.DISPLAY_NAME} , new int[]{android.R.id.text1,android.R.id.text2}, 0);

        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
                if(columnIndex == dataColumnIndex){
                    //정의  Uri uri = Uri.fromFile(new File(path))
                    ImageView iv = (ImageView) view;
                    /*String path = cursor.getString(columnIndex);
//                    BitmapFactory.Options opts = new BitmapFactory.Options();
//                    opts.inSampleSize = 4;
//                    Bitmap bm = BitmapFactory.decodeFile(path, opts);
//                    iv.setImageBitmap(bm);
                    Uri uri = Uri.fromFile(new File(path));
                    ImageLoader.getInstance().displayImage(uri.toString(), iv);*/
                }


                return false;
            }
        });

        vList.setAdapter(mAdapter);

        vList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor)vList.getItemAtPosition(position);
                String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
              /*  Uri uri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id);

                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.setData(uri);

                setResult(RESULT_OK, intent);
                finish();*/
            }
        });

        getSupportLoaderManager().initLoader(0, null, this);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[] {MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DATA}, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        dataColumnIndex = data.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
    @Override
    public void onClick(View v) {

    }
}
