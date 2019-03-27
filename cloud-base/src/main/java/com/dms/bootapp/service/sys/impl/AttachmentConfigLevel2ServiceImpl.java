package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.AttachmentConfigLevel2Dao;
import com.dms.bootapp.domain.sys.AttachmentConfigLevel2DO;
import com.dms.bootapp.service.sys.AttachmentConfigLevel2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AttachmentConfigLevel2ServiceImpl implements AttachmentConfigLevel2Service {
	@Autowired
	private AttachmentConfigLevel2Dao attachmentConfigLevel2Dao;
	

	@Override
	public List<AttachmentConfigLevel2DO> list(int page, int limit){
		return attachmentConfigLevel2Dao.list(page,limit);
	}
	

	@Override
	public int save(AttachmentConfigLevel2DO attachmentConfigLevel2){
		return attachmentConfigLevel2Dao.save(attachmentConfigLevel2);
	}
	
	@Override
	public int update(AttachmentConfigLevel2DO attachmentConfigLevel2){
		return attachmentConfigLevel2Dao.update(attachmentConfigLevel2);
	}
	
	@Override
	public int remove(String id){
		return attachmentConfigLevel2Dao.remove(id);
	}

	@Override
    public int count(){return attachmentConfigLevel2Dao.count();};

	@Override
	public AttachmentConfigLevel2DO getleval2ById(String id) {return attachmentConfigLevel2Dao.getleval2ById(id);}

	@Override
	public List<AttachmentConfigLevel2DO> listByClassType(int page, int limit, String vClassType) {
		return attachmentConfigLevel2Dao.listByClassType(page,limit,vClassType);
	}

}
