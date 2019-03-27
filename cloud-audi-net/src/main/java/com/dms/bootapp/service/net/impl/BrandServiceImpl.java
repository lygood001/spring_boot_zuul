package com.dms.bootapp.service.net.impl;

import com.dms.bootapp.dao.net.BrandDao;
import com.dms.bootapp.domain.net.BrandDO;
import com.dms.bootapp.service.net.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao brandDao;
	

	@Override
	public List<BrandDO> list(int page, int limit){
		return brandDao.list(page,limit);
	}

	@Override
	public BrandDO get(String id) {
		return brandDao.get(id);
	}

	@Override
	public List<BrandDO> checkBrandCode(BrandDO brand) {
		return brandDao.checkBrandCode(brand);
	}

	@Override
	public int save(BrandDO brand){
		return brandDao.save(brand);
	}
	
	@Override
	public int update(BrandDO brand){
		return brandDao.update(brand);
	}
	
	@Override
	public int remove(String id){
		return brandDao.remove(id);
	}

	@Override
    public int count(){return brandDao.count();};

	@Override
	public List<BrandDO> getAllBrandList() {
		return brandDao.getAllBrandList();
	}



}
