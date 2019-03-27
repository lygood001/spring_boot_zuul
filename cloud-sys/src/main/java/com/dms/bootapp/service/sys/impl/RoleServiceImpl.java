package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.RoleDao;
import com.dms.bootapp.domain.sys.RoleDO;
import com.dms.bootapp.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	

	@Override
	public List<RoleDO> list(int page, int limit){
		return roleDao.list(page,limit);
	}
	

	@Override
	public Map<String,String> saveRole(RoleDO role){
		Map<String,String> map = new HashMap<>();
		int vcodeCount=roleDao.getCountByCode(role.getVCode());
		if(vcodeCount == 0){
			if(roleDao.save(role)>0){
				map.put("Code","S");
				map.put("Message","Save role  OK!");
			}else{
				map.put("Code","E");
				map.put("Message","Save role  ERROR");
			}
		}else{
			map.put("Code","E");
			map.put("Message","The code has been repeated. Please re-enter it.");
		}

		return map;
	}
	
	@Override
	public int update(RoleDO role){
		return roleDao.update(role);
	}
	
	@Override
	public int remove(String id){
		return roleDao.remove(id);
	}

	@Override
    public int count(){return roleDao.count();};

	@Override
	public RoleDO get(Integer value){
		return roleDao.get(value);
	}

	@Override
	public int save(RoleDO role){
		return roleDao.save(role);
	}

    @Override
    public String getCreaterName(Integer value){
        return roleDao.getCreaterName(value);
    }
}
