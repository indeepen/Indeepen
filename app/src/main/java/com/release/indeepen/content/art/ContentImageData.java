package com.release.indeepen.content.art;

import com.release.indeepen.content.ContentData;
import com.release.indeepen.user.UserData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lyo on 2015-10-31.
 */
public class ContentImageData extends ContentData{

    public List<String> arrIMGs;

    public ContentImageData(){
        mUserData = new UserData();
    }
}
