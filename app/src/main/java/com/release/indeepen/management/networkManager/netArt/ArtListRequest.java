package com.release.indeepen.management.networkManager.netArt;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.release.indeepen.SharedApplication;
import com.release.indeepen.content.ContentData;
import com.release.indeepen.management.networkManager.NetworkRequest;
import com.release.indeepen.management.networkManager.netArt.data.ListResult;
import com.release.indeepen.youtube.DefineNetwork;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by lyo on 2015-11-10.
 */
public class ArtListRequest extends NetworkRequest<ListResult> {

    @Override
    public URL getURL() throws MalformedURLException {
        return new URL("http://54.64.26.200/workPosts");
    }

    public void setRequstMethod(HttpURLConnection conn){
        try {
            conn.setRequestMethod(DefineNetwork.METHOD_GET);
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ListResult parsing(InputStream is) {
        ListResult arrResult = null;

        try {
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));

            arrResult = new Gson().fromJson(reader, ListResult.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrResult;
    }
}
   /*
   String keyword;
    int start;
    int display;
    private static final String MOVIE_URL = "http://openapi.naver.com/search?key=55f1e342c5bce1cac340ebb6032c7d9a&query=%s&display=%s&start=%s&target=movie";
    public NaverMovieRequest(String keyword, int start, int display) {
        this.keyword = keyword;
        this.start = start;
        this.display = display;
    }

    @Override
    public URL getURL() throws MalformedURLException {
        try {
            String urlText = String.format(MOVIE_URL, URLEncoder.encode(keyword, "utf-8"), display, start);
            return new URL(urlText);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NaverMovies parsing(InputStream is) {
        XMLParser parser = new XMLParser();
        NaverMovies movies = parser.fromXml(is, "channel", NaverMovies.class);
        return movies;
    }
    */

