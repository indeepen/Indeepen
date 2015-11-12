package com.release.indeepen.management.networkManager.netArt.data;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lyo on 2015-11-11.
 */
public class Comments{
    @SerializedName("_id")
    public String sCommID;
    @SerializedName("_writer")
    public Writer mWriter;
    @SerializedName("content")
    public String sComm;


}
