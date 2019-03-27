package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.MenuDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * system menu dao
 * @author SJF
 * @email 275724057@qq.com
 * @date 2019-01-22 16:05:43
 */
@Mapper
@Component
public interface MenuDao extends IBaseDao<MenuDO> {
	List<MenuDO> getAppMenuListByGroup(String group_code);

	MenuDO getAppMenuByMenuCode(String menuCode);

	int countById(String id);

	int countAttById(String id);
	String autoIncrement(String tableName);

	//pc menu
	List<Map<String, Object>> getPCMenuTree(String value);
	List<Map<String, Object>> getAllPCMenuTree();
	String getPCMenuType();
    List<Map<String, Object>> getPCMenuGroup();
	int countByParentId(String id);

	List<Map<String, Object>> getPCMenuTreeForUser(String value);
}
