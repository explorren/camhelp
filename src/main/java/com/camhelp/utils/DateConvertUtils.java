package com.camhelp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jupiter on 2017/8/3.
 */
public class DateConvertUtils {
    public static String GetNowTimeToString(){
        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

        Date date = new Date();

        String strDate = simpleDateFormat.format(date);

        return strDate;
    }
}
