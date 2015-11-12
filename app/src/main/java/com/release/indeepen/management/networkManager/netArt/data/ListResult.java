package com.release.indeepen.management.networkManager.netArt.data;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by lyo on 2015-11-11.
 */
public class ListResult{
    @SerializedName("result")
    public List<Result> arrArts;

}
