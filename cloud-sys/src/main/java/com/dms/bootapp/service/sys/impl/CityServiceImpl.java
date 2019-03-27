package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.CityDao;
import com.dms.bootapp.domain.sys.CityDO;
import com.dms.bootapp.service.sys.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDao cityDao;
	

	@Override
	public List<CityDO> list(int page, int limit){
		return cityDao.list(page,limit);
	}
	

	@Override
	public int save(CityDO city){
		return cityDao.save(city);
	}
	
	@Override
	public int update(CityDO city){
		return cityDao.update(city);
	}
	
	@Override
	public int remove(String id){
		return cityDao.remove(id);
	}

	@Override
    public int count(){return cityDao.count();};

	@Override
	public List<CityDO> getDictItemsByCode(String v_dict_code) {
		return null;
	}

	@Override
	public CityDO getCityDetail(String id) {
		return cityDao.getCityDetail(id);
	}

	@Override
	public List<CityDO> cityListByProvince(int page, int limit, String vProCode) {
		return cityDao.cityListByProvince(page,limit,vProCode);
	}

	@Override
	public int countBypro(String vProCode) {
		return cityDao.countBypro(vProCode);
	}

	@Override
	public List<CityDO> getCityListByProCode(String proCode) {
		return cityDao.getCityListByProCode(proCode);
	}

	@Override
	public int countByProCode(String proCode) {
		return cityDao.countByProCode(proCode);
	}

	@Override
	public List<CityDO> cityListOrderBy() {
		return cityDao.cityListOrderBy();
	}
}
