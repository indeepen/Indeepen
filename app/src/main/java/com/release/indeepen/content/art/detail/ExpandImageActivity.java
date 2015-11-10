package com.release.indeepen.content.art.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ExpandImageActivity extends AppCompatActivity {

    ImageView vImage;
    PhotoViewAttacher attacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_image);
        vImage = (ImageView) findViewById(R.id.img_expand);
        attacher = new PhotoViewAttacher(vImage);
        init();
    }

    private void init() {
        if (0 != getIntent().getIntExtra(DefineContentType.EXPAND_IMG, 0)) {
            vImage.setImageResource(getIntent().getIntExtra(DefineContentType.EXPAND_IMG, 0));
        } else {
            vImage.setImageResource(R.drawable.dog2);
        }
    }

}
