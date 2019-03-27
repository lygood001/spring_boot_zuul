package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.RoleDO;
import com.dms.common.base.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * 用户角色表(规范审查不通过 STOP字段名称不对)
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 10:03:16
 */
public interface RoleService extends IBaseService<RoleDO> {

	
	List<RoleDO> list(int page, int limit);

	Map<String,String> saveRole(RoleDO role);
	
	int update(RoleDO role);
	
	int remove(String id);

    int count();
	RoleDO get(Integer value);
	String getCreaterName(Integer value);
}
