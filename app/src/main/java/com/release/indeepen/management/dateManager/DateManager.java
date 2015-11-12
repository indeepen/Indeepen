package com.release.indeepen.management.dateManager;

import java.util.GregorianCalendar;

/**
 * Created by lyo on 2015-11-11.
 */
public class DateManager {
    private static DateManager instance;

    public static DateManager getInstance(){
        if(null == instance){
            instance = new DateManager();
        }
        return instance;
    }

    private DateManager(){

    }
    public String getTime(long time){
        String resutl = "";
        long now = System.currentTimeMillis();
        long subs = (now-time)/1000;

        GregorianCalendar today = new GregorianCalendar ( );
        today.setTimeInMillis(now);

        int nowYear = today.get ( today.YEAR );
        int nowMonth = today.get ( today.MONTH ) + 1;
        int nowDay = today.get ( today.DAY_OF_MONTH );
        int nowHour = today.get(today.HOUR_OF_DAY);
        int nowMin = today.get ( today.MINUTE );
        int nowSec = today.get ( today.SECOND );

        today.setTimeInMillis(time);
        int timeYear = today.get ( today.YEAR );
        int timeMonth = today.get ( today.MONTH ) + 1;
        int timeDay = today.get ( today.DAY_OF_MONTH );
        int timeHour = today.get ( today.HOUR_OF_DAY );
        int timeMin = today.get ( today.MINUTE );
        int timeSec = today.get ( today.SECOND );

        int year = nowYear - timeYear;
        int month = nowMonth - timeMonth;
        int day = nowDay - timeDay;
        int hour = nowHour - timeHour;
        int min = nowMin - timeMin;
        int second = nowSec - timeSec;

        if(year > 0){
            resutl = year +"년 전";
        }else if(month > 0){
            resutl = month +"달 전";
        }else if(day > 0){
            resutl = day +"일 전";
        }else if(hour > 0){
            resutl = hour +"시간 전";
        }else if(min > 0){
            resutl = min +"분 전";
        }else if(second > 0){
            resutl = second +"초 전";
        }

        return resutl;
    }
}
