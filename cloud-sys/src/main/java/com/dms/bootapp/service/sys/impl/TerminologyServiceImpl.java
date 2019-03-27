package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.TerminologyDao;
import com.dms.bootapp.domain.sys.TerminologyDO;
import com.dms.bootapp.service.sys.TerminologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminologyServiceImpl implements TerminologyService {
	@Autowired
	private TerminologyDao terminologyDao;
	

	@Override
	public List<TerminologyDO> list(int page, int limit){
		return terminologyDao.list(page,limit);
	}
	

	@Override
	public int save(TerminologyDO terminology){
		return terminologyDao.save(terminology);
	}
	
	@Override
	public int update(TerminologyDO terminology){
		return terminologyDao.update(terminology);
	}
	
	@Override
	public int remove(String id){
		return terminologyDao.remove(id);
	}

	@Override
    public int count(){return terminologyDao.count();};

	@Override
	public List<TerminologyDO> getTerminologyListBySearchStr(int page, int limit, String v_search_str) {
		return terminologyDao.getTerminologyListBySearchStr(page,limit,v_search_str);
	}

	@Override
	public int countBySearchStr(String v_search_str) {
		return terminologyDao.countBySearchStr(v_search_str);
	}

	@Override
	public TerminologyDO getTerminologyDOByID(int id) {
		return terminologyDao.getTerminologyDOByID(id);
	}

	@Override
	public List<TerminologyDO> getTerminologyListByFullName(TerminologyDO terminologyDO) {
		return terminologyDao.getTerminologyListByFullName(terminologyDO);
	}

}
