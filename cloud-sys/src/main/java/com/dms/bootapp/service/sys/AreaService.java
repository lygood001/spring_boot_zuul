package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.AreaDO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * area service
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-30 17:35:31
 */
public interface AreaService  extends IBaseService<AreaDO> {
    List<AreaDO> getAllAreaList();
}
