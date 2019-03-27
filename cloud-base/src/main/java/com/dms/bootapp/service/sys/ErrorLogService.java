package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.ErrorLogDO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * system error log 
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-02-15 15:55:46
 */
public interface ErrorLogService extends IBaseService<ErrorLogDO> {
    List<ErrorLogDO> listBySearchDate(int page, int limit, String dbegin, String dend);
    int countBySearchDate(String dbegin, String dend);
}
