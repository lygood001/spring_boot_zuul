package com.dms.common.base;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author WSD
 * @Title: BootAppJsonBase
 * @ProjectName boot app
 * @Description:
 * @date 2018/12/25 8:55
 */
@Component
@ConfigurationProperties(ignoreUnknownFields = false,prefix = "bootapp")
public class BootAppJsonBase {
    private String appName;
    private String appVersion;
    private String companyCode;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
