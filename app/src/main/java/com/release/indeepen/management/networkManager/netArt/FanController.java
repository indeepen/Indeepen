package com.release.indeepen.management.networkManager.netArt;

import com.release.indeepen.content.ContentData;
import com.release.indeepen.culture.CultureItemData;
import com.release.indeepen.management.networkManager.NetworkManager;
import com.release.indeepen.management.networkManager.NetworkProcess;
import com.release.indeepen.management.networkManager.NetworkRequest;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lyo on 2015-11-10.
 */
public class FanController {

    private static FanController instance;
    private ThreadPoolExecutor mExecutor;
    public static FanController getInstance() {
        if (instance == null) {
            instance = new FanController();
        }
        return instance;
    }

    private FanController(){
        mExecutor = NetworkManager.getInstance().getExecutor();
    }



    public void getArtList(NetworkRequest<ContentData> request, NetworkProcess.OnResultListener<ContentData> listener){
        mExecutor.execute(new NetworkProcess<ContentData>(request, listener));
    }
}
