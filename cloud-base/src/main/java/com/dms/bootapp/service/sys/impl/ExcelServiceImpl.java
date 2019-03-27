package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.ExcelDao;
import com.dms.bootapp.domain.sys.ExcelDO;
import com.dms.bootapp.service.sys.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExcelServiceImpl implements ExcelService {
	@Autowired
	private ExcelDao excelDao;

	@Override
	public List<ExcelDO> list(int page, int limit){
		return excelDao.list(page,limit);
	}
	

	@Override
	public int save(ExcelDO excel){
		return excelDao.save(excel);
	}
	
	@Override
	public int update(ExcelDO excel){
		return excelDao.update(excel);
	}
	
	@Override
	public int remove(String id){
		return excelDao.remove(id);
	}

	@Override
    public int count(){return excelDao.count();};

	public ExcelDO get(String id){
		return excelDao.get(id);
	};

	public List<ExcelDO> getTemplateURL(String vExcelCode){
		return excelDao.getTemplateURL(vExcelCode);
	};


}
