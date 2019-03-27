package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.VersionDO;
import com.dms.common.base.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * VersionService
 * 
 * @author WSD
 * @email 9394595508@qq.com
 * @date 2019-01-19 15:11:04
 */
public interface VersionService extends IBaseService<VersionDO> {
	VersionDO getByType(String type);
	VersionDO get (String id);
	List<VersionDO> exeP_APP_GetVersion(Map<String,Object> map);
}
