package com.release.indeepen;

/**
 * Created by Tacademy on 2015-10-30.
 */
public interface DefineContentType {

    int CALLBACK_TO_BLOG = 0;
    int CALLBACK_TO_SINGLE_LIST = 1;

    /* 싱글 태스크 관리 및 요청 정보*/
    int TO_SINGLE_LIST = 0;
    int TO_BLOG = 1;

    int TO_DETAIL_IMGAE = 2;
    int TO_DETAIL_MUSIC = 3;
    int TO_DETAIL_MUSIC_VIDEO = 4;
    int TO_DETAIL_YOUTUBE = 5;
    int TO_DETAIL_CULTURE = 6;

    String FRAGMENT_SINGLE_LIST = "singleList";
    String FRAGMENT_DETAIL_IMAGE = "detailIMG";

    String KEY_ON_NEW_PUT_DATA = "PUT_DATA"; // 서버에 업데이트할 데이터들 (업데이트 URL 포함)
    String KEY_ON_NEW_GET_DATA_URL = "GET_DATA_URL"; // 서버에게서 받아오는 데이터 URL


    String KEY_ON_NEW_REQUEST = "REQUEST";
    int TYPE_ON_NEW_REPLACE = 0;
    int TYPE_ON_NEW_ACTIVITY = 1;
    int TYPE_ON_NEW_BACKGROUND = 2;

    /* 디바이스 내 사진 선택 종류*/
    String SELECT_IMAGE = "selectedPicture";

    int ACTIVITY_TYPE_PROFILE_BACKGROUND = 3;
    int ACTIVITY_TYPE_PROFILE_IMG = 4;
    int ACTIVITY_TYPE_EXPANED_IMG = 5;
    int ACTIVITY_TYPE_FIXD_INFO = 6;

    String KEY_ON_NEW_WHERE = "WHERE";



/* 메인 탭 관련 정의*/
    String MAIN_TAB_CULTURE = "culture";
    String MAIN_TAB_FAN = "fan";
    String MAIN_TAB_CREATE = "create";
    String MAIN_TAB_NOTIFICATION = "notification";
    String MAIN_TAB_MYBLOG = "myBlog";


    /* 블로그 어댑터 관련 정의*/
    int BLOG_TYPE_COUNT = 2;

    int BLOG_INTRO_PROFILE = 0;
    int BLOG_INTRO_ART = 1;


/*  comment 관련 리스트  정의*/

    int COMMENT_TYPE_COUNT = 1;

    /* Single List 컨텐츠 관련 정의*/
    int SINGLE_TYPE_COUNT = 5;

    int SINGLE_IMAGE = 0;
    int SINGLE_MUSIC = 1;
    int SINGLE_VIDEO = 2;
    int SINGLE_YOUTUBE = 3;
    int SINGLE_CULTURE = 4;

    int SINGLE_ART_TYPE_PAINT = 10;
    int SINGLE_ART_TYPE_PICTURE = 11;
    int SINGLE_ART_TYPE_MUSIC_PICTURE = 12;
    int SINGLE_ART_TYPE_MUSIC_VIDEO = 13;
    int SINGLE_ART_TYPE_MUSIC = 14;
    int SINGLE_ART_TYPE_VIDEO = 15;
    int SINGLE_ART_TYPE_CULTURE = 16;
    //........


    /* 알림 관련 정의*/
    int NOTI_TYPE_COUNT = 2;
    int NOTI_LIST_TEXT = 0;
    int NOTI_LIST_IMG = 1;

    String NOTI_VER_LIKE_CULTURE = "";
    String NOTI_VER_LIKE_ART = "";
    String NOTI_VER_FAN = "";
    String NOTI_VER_MISSU = "";
    String NOTI_VER_FAN_SPACE = "";
    String NOTI_VER_MISSU_SPACE = "";
    String NOTI_VER_COMM_CULTURE = "";
    String NOTI_VER_COMM_ART = "";
    String NOTI_VER_TAG = "";

    // 텍스트 알림
    int NOTI_TYPE_LIKE_CULTURE = 0;
    int NOTI_TYPE_LIKE_ART = 1;
    int NOTI_TYPE_COMM_CULTURE = 2;
    int NOTI_TYPE_COMM_ART = 3;
    int NOTI_TYPE_TAG = 4;

    // 이미지 사용 알림
    int NOTI_TYPE_FAN = 5;
    int NOTI_TYPE_MISSU = 6;
    int NOTI_TYPE_FAN_SPACE = 7;
    int NOTI_TYPE_MISSU_SPACE = 8;


/* 컨탠츠 디테일 관련 정의*/

    String BUNDLE_DATA_DETAIL_IMAGE = "detailImage";
    String BUNDLE_DATA_DETAIL_MUSIC = "detailMusic";
    String BUNDLE_DATA_DETAIL_MUSIC_VIDEO = "detailMusicVideo";
    String BUNDLE_DATA_DETAIL_YOUTUBE = "detailYoutube";
    //int BUNDLE_DATA_DETAIL_IMAGE = "detail_image";

    /* 사진확대*/
    String EXPAND_IMG = "expendImg";

    /* 심플 유저 리스트*/
    String SIMPLE_MY_FAN = "My 팬들";
    String SIMPLE_MY_ARTIST = "My 예술가들";

    int SIMPLE_USER_LIST_TYPE = 1;

    /* 블로그 내 문화 정보*/
    String BLOG_MY_CULTURE = "My 문화";
    String BLOG_LIKE_CULTURE = "좋아요 문화";



}
