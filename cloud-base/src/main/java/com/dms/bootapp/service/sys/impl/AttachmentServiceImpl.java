package com.dms.bootapp.service.sys.impl;

import com.dms.bootapp.dao.sys.AttachmentDao;
import com.dms.bootapp.domain.sys.AttachmentDO;
import com.dms.bootapp.service.sys.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AttachmentServiceImpl implements AttachmentService {
	@Autowired
	private AttachmentDao attachmentDao;
	

	@Override
	public List<AttachmentDO> list(int page, int limit){
		return attachmentDao.list(page,limit);
	}
	

	@Override
	public int save(AttachmentDO attachment){
		return attachmentDao.save(attachment);
	}
	
	@Override
	public int update(AttachmentDO attachment){
		return attachmentDao.update(attachment);
	}
	
	@Override
	public int remove(String id){
		return attachmentDao.remove(id);
	}

	@Override
    public int count(){return attachmentDao.count();};

	@Override
	public List<AttachmentDO> getAttachmentsByBizId(AttachmentDO attachmentDO) {
		return attachmentDao.getAttachmentsByBizId(attachmentDO);
	}

}
