package com.release.indeepen.management.networkManager;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dongja94 on 2015-10-20.
 */
public class NetworkManager {

    private static NetworkManager instance;

    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }
        return instance;
    }
    ThreadPoolExecutor mExecutor;


    private NetworkManager() {
        mExecutor = new ThreadPoolExecutor(5, 64, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    public ThreadPoolExecutor getExecutor(){
        return mExecutor;
    }
}
