package com.dms.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WSD
 * @Title: JSONUtils
 * @ProjectName cloud-common
 * @Description: Bean to JSON or JSON to String or String to JSON
 * @date 2018/12/25 14:32
 */
@Slf4j
public class JSONUtils {
    public static String beanToJson(Object object, String dataFormatString) {
        if (object != null) {
            if (StringUtils.isNoneEmpty(dataFormatString)) {
                return JSONObject.toJSONString(object);
            }
            return JSON.toJSONStringWithDateFormat(object, dataFormatString);
        } else {
            return null;
        }
    }

    /**
     * Bean对象转JSON
     *
     * @param object
     * @return
     */
    public static String beanToJson(Object object) {
        if (object != null) {
            return JSON.toJSONString(object);
        } else {
            return null;
        }
    }

    /**
     * String转JSON字符串
     *
     * @param key
     * @param value
     * @return
     */
    public static String stringToJsonByFastjson(String key, String value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>(16);
        map.put(key, value);
        return beanToJson(map, null);
    }

    /**
     * 根据json字符串组装domain object
     *
     * @param inParaJsonStr
     * @param clazz
     * @return
     */
    public static <T> T  packingDOFromJsonStr(String inParaJsonStr,  Class<T> clazz) {
        JSONObject jsonobject = JSONObject.parseObject(inParaJsonStr);
        return JSONObject.toJavaObject(jsonobject,clazz);
    }

    /**
     * json字符串转map
     *
     * @param json
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> jsonToMap(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return JSON.parseObject(json, Map.class);
    }

    /**
     * 根据json字符串组装domain object
     *
     * @param inParaJsonStr
     * @param clazz
     * @return
     */
    public static JSONObject getErrorLogJSONObject(Exception e,HttpServletRequest request,String micro_service_name) {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
            log.error("JSONUtils类getErrorLogJSONObject方法 ==获取服务器IP地址异常==>"+ex.toString());
        }

        String v_request_url =  request.getRequestURL().toString();
        String v_query_string = request.getQueryString();
        String v_request_mode = request.getParameter("model");
        String v_parameters = request.getParameter("inParaJsonStr");


        JSONObject errorLogJson = new JSONObject();
        errorLogJson.put("vModel",v_request_mode);
        errorLogJson.put("vRequestUrl",v_request_url+"?"+v_query_string);
        errorLogJson.put("vParameters",v_parameters);
        errorLogJson.put("vServerIp",inetAddress.toString());
        errorLogJson.put("vServerName",micro_service_name);
        StringBuilder errorOutString =  new StringBuilder();
        errorOutString.append(e.getMessage() + "\r\n");
        StackTraceElement[] trace = e.getStackTrace();
        for (StackTraceElement s : trace) {
            errorOutString.append("\tat " + s + "\r\n");
        }

        errorLogJson.put("vException",errorOutString.toString());
        return errorLogJson;
    }
}
