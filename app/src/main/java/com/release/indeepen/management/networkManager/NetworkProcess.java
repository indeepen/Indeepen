package com.release.indeepen.management.networkManager;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lyo on 2015-11-10.
 */
public class NetworkProcess<T> implements Runnable {
    public interface OnResultListener<T> {
        public void onSuccess(NetworkRequest<T> request, T result);
        public void onFail(NetworkRequest<T> request, int code);
    }

    Handler mHandler = new Handler(Looper.getMainLooper());
    NetworkRequest<T> request;
    OnResultListener<T> listener;

    public NetworkProcess(NetworkRequest<T> request, OnResultListener<T> listener) {
        this.request = request;
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            URL url = request.getURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            request.setRequstMethod(conn);
            request.setOutput(conn);
            int code = conn.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                final T object = request.parsing(is);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!request.isCancel()) {
                            listener.onSuccess(request, object);
                        }
                    }
                });
                return;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (!request.isCancel()) {
                    listener.onFail(request, -1);
                }
            }
        });
    }

}
