package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.ExcelDO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * excel 导入配置信息表
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-02-15 14:15:42
 */
public interface ExcelService extends IBaseService<ExcelDO> {


    public ExcelDO get(String id);

    List<ExcelDO> getTemplateURL(String vExcelCode);
}
