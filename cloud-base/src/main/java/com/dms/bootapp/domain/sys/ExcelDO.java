package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * excel 导入配置信息表
 *
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-31 10:38:27
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ExcelDO extends BaseDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //code
    private String vExcelCode;
    //name
    private String vExcelName;
    //tavle
    private String vExcelTable;
    //proc
    private String vProc;
    //file Url
    private String vTemplateUrl;
    //StopFlag
    private String vStopFlag;


}
