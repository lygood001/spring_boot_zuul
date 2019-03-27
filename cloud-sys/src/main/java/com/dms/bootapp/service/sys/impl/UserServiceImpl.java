package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.UserDao;
import com.dms.bootapp.domain.sys.UserDO;
import com.dms.bootapp.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;


	@Override
	public List<UserDO> exeP_APP_Login(String user_account, String user_password) {
		return userDao.exeP_APP_Login(user_account,user_password);
	}

	@Override
	public List<UserDO> list(UserDO user, int page, int limt) {
		return userDao.list(user,page,limt);
	}

	@Override
	public UserDO get(String id) {
		return userDao.get(id);
	}


	@Override
	public List<UserDO> list(int page, int limit) {
		return null;
	}

	@Override
	public int save(UserDO userDO) {
		return userDao.save(userDO);
	}

	@Override
	public int update(UserDO userDO) {
		return userDao.update(userDO);
	}

	@Override
	public int remove(String id) {
		return userDao.remove(id);
	}

	@Override
	public int count() {
		return userDao.count();
	}
	@Override
	public List<Map<String, Object>> getUserRoleAll(String value){
		return userDao.getUserRoleAll(value);
	}
}
