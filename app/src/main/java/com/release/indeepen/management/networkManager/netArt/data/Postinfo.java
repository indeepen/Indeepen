package com.release.indeepen.management.networkManager.netArt.data;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by lyo on 2015-11-11.
 */
public class Postinfo {

    @SerializedName("_id")
    public String sContentKey;

    @SerializedName("postType")
    public int nPostType;

    @SerializedName("_writer")
    public Writer mWriter;

    @SerializedName("content")
    public String sContent;

    @SerializedName("resources")
    public List<Resources> arrResources;

    @SerializedName("work")
    public Work mWork;

    @SerializedName("likes")
    public List<String> arrLikes;

    @SerializedName("hashTags")
    public List<String> arrHashTags;

    @SerializedName("createAt")
    public String sCreateAt;

}
