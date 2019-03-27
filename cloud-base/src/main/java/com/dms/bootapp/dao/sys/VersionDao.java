package com.dms.bootapp.dao.sys;


import com.dms.bootapp.domain.sys.VersionDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * VersionDao
 * @author WSD
 * @email 9394595508@qq.com
 * @date 2019-01-19 15:11:04
 */
@Mapper
@Component
public interface VersionDao extends IBaseDao<VersionDO> {

	VersionDO get(String id);

	VersionDO getByType(String type);

	List<VersionDO> exeP_APP_GetVersion(Map<String, Object> map);

}
