package com.dms.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author WSD
 * @Title: DateUtils
 * @ProjectName cloud-common
 * @Description: 日期时间相关的常用操作类
 * @date 2019/01/03 14:32
 */
public class DateUtils {
    /**
     * 日期格式
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";


    /**
     * 获取系统服务器上时间统一为东八区时间
     * @return
     */
    public static String getSysdate()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return  simpleDateFormat.format(new Date());
    }

    /**
     * 根据给定的日期格式，格式化指定的日期
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 获取某个时间与系统当前时间的差值
     * @param date
     * @return
     */
    public static String getTimeBeforeNow(Date date) {
        Date now = new Date();
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String r = "";
        if (day > 0) {
            r += day + "Day";
        }
        if (hour > 0) {
            r += hour + "Hour";
        }
        if (min > 0) {
            r += min + "Minute";
        }
        if (s > 0) {
            r += s + "Second";
        }
        r += "Before";
        return r;
    }
}
