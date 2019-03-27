package com.dms.bootapp.remote;

import com.dms.common.base.JsonResultObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author WSD
 * @Title: VersionRemoteHystrix
 * @ProjectName springclould
 * @Description: 获取外部服务的数据测试
 * @date 2019/3/15 10:35
 */
@Component
@Slf4j
public class CloudBaseRemoteHystrix implements CloudBaseRemote {
    private String hystrixMessage="";
    @Override
    public JsonResultObj getVersionByType_Remote(String inParaJsonStr) {
        this.hystrixMessage="当前调用的云服务已经断开！";
        log.error(this.hystrixMessage);
        return new JsonResultObj("E",this.hystrixMessage);
    }

    @Override
    public JsonResultObj Base64FileUpload(String fileBase64, String BizID, String BizTable, String FileType, String Remake, int status) {
        this.hystrixMessage="当前调用的文件处上传服务已经断开！";
        log.error(this.hystrixMessage);
        return new JsonResultObj("E",this.hystrixMessage);
    }

    @Override
    public JsonResultObj writeErrorLog_Remote(String inParaJsonStr) {
        this.hystrixMessage="当前调用的日志收集服务已经断开！";
        log.error(this.hystrixMessage);
        return new JsonResultObj("E",this.hystrixMessage);
    }
}
