package com.release.indeepen.management.networkManager.netArt;

import com.release.indeepen.content.ContentData;
import com.release.indeepen.management.networkManager.NetworkRequest;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by lyo on 2015-11-10.
 */
public class FanRequest extends NetworkRequest<ContentData> {

    @Override
    public URL getURL() throws MalformedURLException {
        return null;
    }

    @Override
    public ContentData parsing(InputStream is) {
        return null;
    }

   /* @Override
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
    }*/
}
