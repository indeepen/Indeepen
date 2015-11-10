package com.release.indeepen.management.networkManager.netCulture;

import com.release.indeepen.culture.CultureItemData;
import com.release.indeepen.management.networkManager.NetworkManager;
import com.release.indeepen.management.networkManager.NetworkProcess;
import com.release.indeepen.management.networkManager.NetworkRequest;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lyo on 2015-11-10.
 */
public class CultureController {

    private static CultureController instance;
    private ThreadPoolExecutor mExecutor;
    public static CultureController getInstance() {
        if (instance == null) {
            instance = new CultureController();
        }
        return instance;
    }

    private CultureController(){
        mExecutor = NetworkManager.getInstance().getExecutor();
    }



    public void getCultureList(NetworkRequest<CultureItemData> request, NetworkProcess.OnResultListener<CultureItemData> listener){
        mExecutor.execute(new NetworkProcess<CultureItemData>(request, listener));
    }

}
