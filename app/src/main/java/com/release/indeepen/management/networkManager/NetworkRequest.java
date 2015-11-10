package com.release.indeepen.management.networkManager;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by lyo on 2015-11-10.
 */
public abstract  class NetworkRequest<T> {
    public abstract URL getURL() throws MalformedURLException;
    public abstract T parsing(InputStream is);
    public void setRequstMethod(HttpURLConnection conn){
        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
    }

    public void setOutput(HttpURLConnection conn) {

    }
    private boolean isCancel = false;
    public void cancel() {
        isCancel = true;
    }
    public boolean isCancel() {
        return isCancel;
    }
}
