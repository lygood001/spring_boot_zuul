package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * system error log 
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-02-15 15:55:46
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ErrorLogDO extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

    //dictionary from_model
    private String vModel;
    //http request url
    private String vRequestUrl;
    //http request parameters
    private String vParameters;
    //excption info
    private String vException;
    //remark
    private String vRemark;
    //micro service name
    private String vServerName;
    //micro server ip address
    private String vServerIp;



}
