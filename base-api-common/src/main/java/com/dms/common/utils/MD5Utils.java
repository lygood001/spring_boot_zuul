package com.dms.common.utils;

import org.springframework.util.DigestUtils;

/**
 * @author WSD
 * @Title: MD5Utils
 * @ProjectName cloud-common
 * @Description: MD5基础Util类
 * @date 2019/1/2 8:23
 */
public class MD5Utils {

    public static String encrypt(String str) {
        String encodeStr= DigestUtils.md5DigestAsHex(str.getBytes());
        return encodeStr;
    }

//    public static void main(String[] args) {
//        System.out.println(MD5Utils.encrypt("17790090704FAWCARQM2019m01uingfd*wer"));
//    }

}
