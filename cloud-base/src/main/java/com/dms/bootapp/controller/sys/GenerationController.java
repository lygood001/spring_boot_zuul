package com.dms.bootapp.controller.sys;

import com.dms.bootapp.service.sys.GenerationService;
import com.dms.common.utils.JSONUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author WSD
 * @Title: GenerationController
 * @ProjectName bootapp
 * @Description: System generate codes controller
 * @date 2019/1/3 8:57
 */

@RestController
@RequestMapping("/generation")
public class GenerationController {

    @Autowired
    GenerationService service;

    @RequestMapping("/genertion")
    public String genertion(){

        return "pages/sys/genertion";
    }

    @ResponseBody
    @RequestMapping("/genertionTableList")
    public String genertionTableList(int page,int limit,String inParaJsonStr){
        List<Map<String, Object>> list= service.list((page-1) * limit,limit);
        String strJson="{\"code\":\"S\",\"msg\":\"\",\"count\":"+service.count()+",\"data\":"+ JSONUtils.beanToJson(list)+"}";
        return strJson;
    }

    @ResponseBody
    @RequestMapping("/DownloadGenertionZip")
    public void DownloadZip(HttpServletRequest request, HttpServletResponse response,
                            String tableName) throws IOException {
        System.out.println(">>>>>>>>>>>>>>>"+tableName);
        byte[] data = service.generatorCode(tableName);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"bootdo.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

}
