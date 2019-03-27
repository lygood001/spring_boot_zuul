package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.MenuGroupDO;
import com.dms.common.base.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * system menu service
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-22 16:05:43
 */
public interface MenuService extends IBaseService<MenuGroupDO> {
	List<MenuGroupDO> getAppMenuList();
	//PC Menu
	List<Map<String, Object>> getPCMenuTree(String id);
	List<Map<String, Object>> getAllPCMenuTree();
	String getPCMenuType();
	List<Map<String, Object>> getPCMenuGroup();
	int countByParentId(String id);
	List<Map<String, Object>> getPCMenuTreeForUser(String value);
}
