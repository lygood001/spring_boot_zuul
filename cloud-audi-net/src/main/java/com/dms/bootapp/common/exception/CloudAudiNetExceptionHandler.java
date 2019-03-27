package com.dms.bootapp.common.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dms.bootapp.remote.CloudBaseRemote;
import com.dms.common.base.JsonResultObj;
import com.dms.common.exception.BootException;
import com.dms.common.exception.IBootExceptionHandler;
import com.dms.common.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WSD
 * @Title: DMSBootExceptionHandler
 * @ProjectName boot app
 * @Description: Spring MVC AOP handler of app system exception
 * @date 2018/12/28 8:47
 */
@RestControllerAdvice(basePackages = "com.dms.bootapp.controller")
@Slf4j
@ConfigurationProperties(ignoreUnknownFields = true,prefix = "spring.application")
public class CloudAudiNetExceptionHandler implements IBootExceptionHandler {

    @Autowired
    private BootException dmsBootException;

    @Autowired
    private CloudBaseRemote cloudBaseRemote;

    /**
     * 在配置文件中配置的文件保存路径
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Deal with exception
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler({Exception.class})
    public Object handleException(Exception e, HttpServletRequest request) {

        //1 各个微服务模块自定义处理
        dmsBootException.getBootExceptionJSON().setCode("E");
        dmsBootException.getBootExceptionJSON().setMsg("Server error,please contact administrator!");
        dmsBootException.getBootExceptionJSON().setData(e.toString());
        log.error(request.getRequestURL().toString()+"  ==CloudSystemException==>"+e.toString());

        //2 调用Base微服务收集记录日志
        JSONObject errorLogJson = JSONUtils.getErrorLogJSONObject(e,request,this.name);
        JsonResultObj writeLogResult = cloudBaseRemote.writeErrorLog_Remote(errorLogJson.toJSONString());
        log.error("调用Base微服务writeErrorLog_Remote方法后返回结果===》"+ JSON.toJSONString(writeLogResult));
        return dmsBootException.getBootExceptionJSON();
    }
}
