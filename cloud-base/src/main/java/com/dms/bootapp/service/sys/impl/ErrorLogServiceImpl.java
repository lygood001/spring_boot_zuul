package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.ErrorLogDao;
import com.dms.bootapp.domain.sys.ErrorLogDO;
import com.dms.bootapp.service.sys.ErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ErrorLogServiceImpl implements ErrorLogService {
	@Autowired
	private ErrorLogDao errorLogDao;


	@Override
	public List<ErrorLogDO> list(int page, int limit){
		return errorLogDao.list(page,limit);
	}
	

	@Override
	public int save(ErrorLogDO errorLog){
		return errorLogDao.save(errorLog);
	}
	
	@Override
	public int update(ErrorLogDO errorLog){
		return errorLogDao.update(errorLog);
	}
	
	@Override
	public int remove(String id){
		return errorLogDao.remove(id);
	}

	@Override
    public int count(){return errorLogDao.count();};

	@Override
	public List<ErrorLogDO> listBySearchDate(int page, int limit, String dbegin, String dend) {
			return errorLogDao.listBySearchDate(page,limit,dbegin,dend);
	}
	@Override
	public int countBySearchDate(String dbegin, String dend){return errorLogDao.countBySearchDate(dbegin,dend);};




}
