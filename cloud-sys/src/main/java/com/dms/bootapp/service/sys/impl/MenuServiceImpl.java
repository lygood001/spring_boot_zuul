package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.MenuDao;
import com.dms.bootapp.dao.sys.MenuGroupDao;
import com.dms.bootapp.domain.sys.MenuGroupDO;
import com.dms.bootapp.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	@Autowired
	private MenuGroupDao menuGroupDao;

	/**
	 * get app menu list
	 * @return
	 */
	public List<MenuGroupDO> getAppMenuList()
	{
		List<MenuGroupDO> appMenuGroupList = menuGroupDao.getAppMenuGroupList();
		for (MenuGroupDO temp:appMenuGroupList ) {
			temp.setVMenuList(menuDao.getAppMenuListByGroup(temp.getVMenuGroup()));
		}

		return appMenuGroupList;
	}

	@Override
	public List<MenuGroupDO> list(int page, int limit) {
		return null;
	}

	@Override
	public int save(MenuGroupDO appMenuGroupDO) {
		return 0;
	}

	@Override
	public int update(MenuGroupDO appMenuGroupDO) {
		return 0;
	}

	@Override
	public int remove(String id) {
		return 0;
	}

	@Override
	public int count() {
		return 0;
	}
	@Override
	public List<Map<String, Object>> getPCMenuTree(String id){
		List<Map<String, Object>> maps=  menuDao.getPCMenuTree(id);
		return maps;
	}
	@Override
	public List<Map<String, Object>> getAllPCMenuTree(){
		return menuDao.getAllPCMenuTree();
	}
	@Override
	public String getPCMenuType(){
		return menuDao.getPCMenuType();
	}
	@Override
	public List<Map<String, Object>> getPCMenuGroup(){
		return menuDao.getPCMenuGroup();
	};

	@Override
	public int countByParentId(String id){
		return menuDao.countByParentId(id);
	}
	@Override
	public List<Map<String, Object>> getPCMenuTreeForUser(String value){
		return menuDao.getPCMenuTreeForUser(value);
	}
}
