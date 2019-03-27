package com.dms.common.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

/**
 * @author WSD
 * @Title: BootAppUtil
 * @ProjectName cloud-common
 * @Description: Utile class for the project
 * @date 2019/1/26 8:52
 */
public class BootAppUtil {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str)
    {
        return str == null || str.length() == 0;
    }

    /**
     * 获取业务系统的单据编号
     * 采用线程锁的方式 防止业务单据号编码重复
     * @return
     */
    public static synchronized String getBizNo(){
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("00");
        String bissiness_no = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date()) + df.format(random.nextInt(100));
        return  bissiness_no;
    }

}
