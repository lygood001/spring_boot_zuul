package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.RoleMenuDao;
import com.dms.bootapp.domain.sys.RoleMenuDO;
import com.dms.bootapp.service.sys.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    RoleMenuDao roleMneuDao;

    @Override
    public List<RoleMenuDO> listAll(String value){
        return roleMneuDao.listAll(value);
    }
    @Override
    public int save(List<RoleMenuDO> ids ,String roleId,String roleMenuType){
        return roleMneuDao.save(ids,roleId, roleMenuType);
    }
    @Override
    public int remove(String id, String roleMenuType){
        return roleMneuDao.remove(id, roleMenuType);
    }
}
