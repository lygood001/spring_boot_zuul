package com.dms.bootapp.remote;

import com.dms.common.base.JsonResultObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "spring-cloud-base",fallback = CloudBaseRemoteHystrix.class)
public interface CloudBaseRemote {
    @RequestMapping(value = "/version/getVersionByType")
    JsonResultObj getVersionByType_Remote(@RequestParam(value = "inParaJsonStr") String inParaJsonStr);

    @RequestMapping(value = "/file/base64fileupload")
    JsonResultObj Base64FileUpload(@RequestParam(value = "fileBase64") String fileBase64,
                                   @RequestParam(value = "BizID") String BizID,
                                   @RequestParam(value = "BizTable") String BizTable,
                                   @RequestParam(value = "FileType") String FileType,
                                   @RequestParam(value = "Remake") String Remake,
                                   @RequestParam(value = "status") int status);

    @RequestMapping(value = "/errorLog/writeErrorLog")
    JsonResultObj writeErrorLog_Remote(@RequestParam(value = "inParaJsonStr") String inParaJsonStr);


}
