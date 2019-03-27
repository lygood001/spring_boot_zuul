package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.AttachmentConfigLevel1Dao;
import com.dms.bootapp.domain.sys.AttachmentConfigLevel1DO;
import com.dms.bootapp.service.sys.AttachmentConfigLevel1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AttachmentConfigLevel1ServiceImpl implements AttachmentConfigLevel1Service {
	@Autowired
	private AttachmentConfigLevel1Dao attachmentConfigLevel1Dao;
	

	@Override
	public List<AttachmentConfigLevel1DO> list(int page, int limit){
		return attachmentConfigLevel1Dao.list(page,limit);
	}
	

	@Override
	public int save(AttachmentConfigLevel1DO attachmentConfigLevel1){
		return attachmentConfigLevel1Dao.save(attachmentConfigLevel1);
	}
	
	@Override
	public int update(AttachmentConfigLevel1DO attachmentConfigLevel1){
		return attachmentConfigLevel1Dao.update(attachmentConfigLevel1);
	}
	
	@Override
	public int remove(String id){
		return attachmentConfigLevel1Dao.remove(id);
	}

	@Override
    public int count(){return attachmentConfigLevel1Dao.count();};

	@Override
	public List<AttachmentConfigLevel1DO> getAttachmentConfigLevel1List() {
		return attachmentConfigLevel1Dao.getAttachmentConfigLevel1List();
	}

}
