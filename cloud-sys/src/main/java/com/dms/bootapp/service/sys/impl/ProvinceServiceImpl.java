package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.ProvinceDao;
import com.dms.bootapp.domain.sys.ProvinceDO;
import com.dms.bootapp.service.sys.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	private ProvinceDao provinceDao;
	

	@Override
	public List<ProvinceDO> list(int page, int limit){
		return provinceDao.list(page,limit);
	}
	

	@Override
	public int save(ProvinceDO province){
		return provinceDao.save(province);
	}
	
	@Override
	public int update(ProvinceDO province){
		return provinceDao.update(province);
	}
	
	@Override
	public int remove(String id){
		return provinceDao.remove(id);
	}

	@Override
    public int count(){return provinceDao.count();};

	@Override
	public List<ProvinceDO> getProvinceByCodeOrName(int page, int limit,String searchStr) {
		return provinceDao.getProvinceByCodeOrName(page,limit,searchStr);
	}

	@Override
	public int countBySearchStr(String searchStr) {
		return provinceDao.countBySearchStr(searchStr);
	}

	@Override
	public List<ProvinceDO> getAllProvinceList() {
		return provinceDao.getAllProvinceList();
	}

	@Override
	public List<ProvinceDO> getAllProvinceListByAreaCode(String areaCode) {
		return provinceDao.getAllProvinceListByAreaCode(areaCode);
	}

	@Override
	public List<ProvinceDO> getProvinceListCode(String code) {
		return provinceDao.getProvinceListCode(code);
	}

	@Override
	public List<ProvinceDO> getProListByAreaCode(String areaCode) {
		return provinceDao.getProListByAreaCode(areaCode);
	}

	@Override
	public int countByAreaCode(String areaCode) {
		return provinceDao.countByAreaCode(areaCode);
	}

	@Override
	public ProvinceDO getProvinceByCode(String proCode) {
			return provinceDao.getProvinceByCode(proCode);
	}
}
