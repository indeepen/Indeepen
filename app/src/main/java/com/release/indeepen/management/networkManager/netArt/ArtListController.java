package com.release.indeepen.management.networkManager.netArt;

import android.net.Uri;

import com.release.indeepen.DefineContentType;
import com.release.indeepen.content.ContentData;
import com.release.indeepen.content.art.ContentImageData;
import com.release.indeepen.content.art.ContentMusicData;
import com.release.indeepen.content.art.ContentVideoData;
import com.release.indeepen.content.art.ContentYoutubeData;
import com.release.indeepen.culture.CultureItemData;
import com.release.indeepen.management.networkManager.NetworkManager;
import com.release.indeepen.management.networkManager.NetworkProcess;
import com.release.indeepen.management.networkManager.NetworkRequest;
import com.release.indeepen.management.networkManager.netArt.data.ListResult;
import com.release.indeepen.management.networkManager.netArt.data.Resources;
import com.release.indeepen.management.networkManager.netArt.data.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lyo on 2015-11-10.
 */
public class ArtListController {

    private static ArtListController instance;
    private ThreadPoolExecutor mExecutor;
    public static ArtListController getInstance() {
        if (instance == null) {
            instance = new ArtListController();
        }
        return instance;
    }

    private ArtListController(){
        mExecutor = NetworkManager.getInstance().getExecutor();
    }



    public void getArtList(NetworkRequest<ListResult> request, NetworkProcess.OnResultListener<ListResult> listener){
        mExecutor.execute(new NetworkProcess<ListResult>(request, listener));
    }

    public List<ContentData> getContentList(ListResult arrResult) {
        List<ContentData> list = new ArrayList<ContentData>();
        int count = 0; // test
        for(Result contens: arrResult.arrArts){
            if(null == contens) continue;
            CultureItemData mCultureData;
            ContentImageData mIMGData;
            ContentVideoData mVideoData;
            ContentMusicData mMusicData;
            ContentYoutubeData mYoutubeData;
            ContentData mData = null;
            count++; //test
            if(DefineContentType.POST_TYPE_CULTURE == contens.mPostinfo.nPostType){
                mData = new CultureItemData();
                mData.nArtType = DefineContentType.SINGLE_ART_TYPE_CULTURE;
                continue;
            }

            switch (contens.mPostinfo.mWork.nArtType){
                case DefineContentType.SINGLE_ART_TYPE_PAINT:
                case DefineContentType.SINGLE_ART_TYPE_PICTURE:
                case DefineContentType.SINGLE_ART_TYPE_MUSIC_PICTURE:
                case 1:{
                    mData = new ContentImageData();
                    mData.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC_PICTURE;   // test
                    ((ContentImageData)mData).arrIMGs = new ArrayList<String>();
                    for(Resources resources: contens.mPostinfo.arrResources){
                        if(resources.sFileType.contains("image")){
                            ((ContentImageData)mData).arrIMGs.add(Uri.parse(resources.sPath).toString());
                        }
                    }
                    break;
                }
                case DefineContentType.SINGLE_ART_TYPE_MUSIC_VIDEO:{
                    mData = new ContentVideoData();
                    /*((ContentVideoData)mData).*/
                    break;
                }
                case DefineContentType.SINGLE_ART_TYPE_MUSIC:{
                    mData = new ContentMusicData();
                    mData.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC;  // test
                    for(Resources resources: contens.mPostinfo.arrResources) {
                        if (resources.sFileType.contains("image")) {
                            ((ContentMusicData) mData).sMusicBackIMG = Uri.parse(resources.sPath).toString();
                        } else if (resources.sFileType.contains("audio")) {
                            ((ContentMusicData) mData).sMusicPath = Uri.parse(resources.sPath).toString();
                        }
                    }
                    break;
                }
                case DefineContentType.SINGLE_ART_TYPE_YOUTUBE:{
                    mData = new ContentYoutubeData();
                    break;
                }
            }
            if(count > 9){  //test
                mData.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC;
                mData = new ContentMusicData();
                mData.nArtType = DefineContentType.SINGLE_ART_TYPE_MUSIC;  // test
                for(Resources resources: contens.mPostinfo.arrResources) {
                    if (resources.sFileType.contains("image")) {
                        ((ContentMusicData) mData).sMusicBackIMG = Uri.parse(resources.sPath).toString();
                    } else if (resources.sFileType.contains("audio")) {
                        ((ContentMusicData) mData).sMusicPath = resources.sPath;
                    }
                }

            }

            mData.sContentKey = contens.mPostinfo.sContentKey;
            //mData.nArtType = contens.mPostinfo.mWork.nArtType; // 임시 주석
            mData.nCommentCount = contens.nCommentCnt;
            mData.sText = contens.mPostinfo.sContent;


            mData.mUserData.sArtist = contens.mPostinfo.mWriter.sArtist;
            mData.mUserData.sBlogKey = contens.mPostinfo.mWriter.sBlogKey;
            mData.mUserData.sUserkey = contens.mPostinfo.mWriter.sUserkey;
            mData.mUserData.thProfile = Uri.parse(contens.mPostinfo.mWriter.Thprofile).toString();
            mData.nEmotion = contens.mPostinfo.mWork.nEmotion;
            //mData.dWriteDate = Long.parseLong(contens.mPostinfo.sCreateAt); // 임시 주석
            mData.arrLikes = contens.mPostinfo.arrLikes;
            mData.nLikeCount = contens.mPostinfo.arrLikes.size();
            mData.arrComment = contens.arrComments;

            list.add(mData);
        }


        return list;
    }
}
