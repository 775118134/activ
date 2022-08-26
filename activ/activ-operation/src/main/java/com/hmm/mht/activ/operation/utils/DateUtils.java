package com.hmm.mht.activ.operation.utils;

import cn.hutool.core.date.DatePattern;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hmm
 * @date 2021/6/18 10:44
 * @Description:
 */
public class DateUtils {
    public static boolean isThisTime(long time, String pattern) {
        Date date = new Date(time);
        return isThisTime(date, pattern);
    }

    public static boolean isThisTime(Date date, String pattern) {
        if (date == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String param = sdf.format(date);
        String now = sdf.format(new Date());
        return param.equals(now);
    }


    public static boolean isToday(long time) {
        return isThisTime(time, DatePattern.NORM_DATE_PATTERN);
    }

    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        return isThisTime(date, DatePattern.NORM_DATE_PATTERN);
    }
}
