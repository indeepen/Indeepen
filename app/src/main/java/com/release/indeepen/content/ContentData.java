package com.release.indeepen.content;

import com.release.indeepen.management.networkManager.netArt.data.Comments;
import com.release.indeepen.user.UserData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lyo on 2015-10-31.
 */
public class ContentData implements Serializable {
    public UserData mUserData;
    public String sContentKey;
    //public int thIMG;
    public int nEmotion;
    public int nArtType;
    public long dWriteDate;
    public String sText;
    public List<String> arrLikes;
    public int nLikeCount;
    public int nCommentCount;
    public List<Comments> arrComment;

}
