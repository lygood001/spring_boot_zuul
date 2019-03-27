package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.MenuDao;
import com.dms.bootapp.domain.sys.MenuDO;
import com.dms.bootapp.service.sys.APPMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class APPMenuServiceImpl implements APPMenuService {
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<MenuDO> list(int page, int limit){
		return menuDao.list(page,limit);
	}
	
	@Override
	public MenuDO getAppMenuByMenuCode(String menuCode){
		return menuDao.getAppMenuByMenuCode(menuCode);
	};

	@Override
	public int save(MenuDO menu){
		return menuDao.save(menu);
	}
	
	@Override
	public int update(MenuDO menu){
		return menuDao.update(menu);
	}
	
	@Override
	public int remove(String id){
		return menuDao.remove(id);
	}

	@Override
    public int count(){return menuDao.count();};
	@Override
	public int countById(String id){
		return menuDao.countById(id);
	};
	@Override
	public int countAttById(String id){
		return menuDao.countAttById(id);
	};
	@Override
	public String autoIncrement(String tableName) {
		return menuDao.autoIncrement(tableName);
	};
}
