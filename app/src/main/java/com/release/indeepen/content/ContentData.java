package com.release.indeepen.content;

import com.release.indeepen.blog.ListData;
import com.release.indeepen.user.UserData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lyo on 2015-10-31.
 */
public class ContentData extends UserData implements ListData, Serializable {

    public int nContentKey;
    public int thIMG;
    public int nEmotion;
    public int nArtType;
    public long dWriteData;
    public String sText;
    public int nLikeCount;
    public int nCommCount;
    public List<String> arrCommUser;
    public List<String> arrComment;
    public List<String> arrCommBlog;
}