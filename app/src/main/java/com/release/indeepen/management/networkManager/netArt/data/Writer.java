package com.release.indeepen.management.networkManager.netArt.data;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lyo on 2015-11-11.
 */
public class Writer{
    @SerializedName("_id")
    public String sBlogKey;

    @SerializedName("_user")
    public String sUserkey;

    @SerializedName("nick")
    public String sArtist;

    @SerializedName("profilePhoto")
    public String Thprofile;

}
