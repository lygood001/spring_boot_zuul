package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.ParamterDao;
import com.dms.bootapp.domain.sys.ParamterDO;
import com.dms.bootapp.service.sys.ParamterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParamterServiceImpl implements ParamterService {
	@Override
	public List<ParamterDO> checkParamterCode(ParamterDO paramter) {
		return paramterDao.checkParamterCode(paramter);
	}


	@Autowired
	private ParamterDao paramterDao;
	@Override
	public ParamterDO get(String id) {
		return paramterDao.get(id);
	}

	@Override
	public List<ParamterDO> list(int page, int limit){
		return paramterDao.list(page,limit);
	}
	

	@Override
	public int save(ParamterDO paramter){
		return paramterDao.save(paramter);
	}
	
	@Override
	public int update(ParamterDO paramter){
		return paramterDao.update(paramter);
	}
	
	@Override
	public int remove(String id){
		return paramterDao.remove(id);
	}

	@Override
    public int count(){return paramterDao.count();};

}
