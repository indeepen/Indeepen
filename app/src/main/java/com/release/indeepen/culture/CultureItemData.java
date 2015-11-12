package com.release.indeepen.culture;

import android.graphics.drawable.Drawable;

import com.release.indeepen.content.ContentData;
import com.release.indeepen.user.UserData;

import java.util.List;

/**
 * Created by Lady on 2015. 11. 2..
 */
public class CultureItemData extends ContentData {
 //   public String username;
//    public String uploadtime;
    public CultureItemData(){
        mUserData = new UserData();
    }

    public Drawable feeimage;
    public Drawable ingimage;
    public String title;
    public Drawable mainimage;
    public String date;
    public String time;
    public String address;
    //public String like;
    //public String comment;
    public List<String> arrTag;
    public List<String> arrTagBlog;
    public List<String> arrTag_x;
    public List<String> arrTag_y;
    public String option;


}
