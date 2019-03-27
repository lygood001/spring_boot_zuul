package com.dms.bootapp.controller.sys;


import com.dms.bootapp.domain.sys.AttachmentConfigLevel1DO;
import com.dms.bootapp.service.sys.AttachmentConfigLevel1Service;
import com.dms.common.base.BaseController;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * attachment config level1 (规范审查通过)(内置表内置数据)
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 13:47:34
 */

@RestController
@RequestMapping("/attachmentConfigLevel1")
public class AttachmentConfigLevel1Controller extends BaseController {
	@Autowired
	private AttachmentConfigLevel1Service attachmentConfigLevel1Service;

	@Autowired
	//private AttachmentConfigLevel1DO attachmentConfigLevel1;

	@RequestMapping("/getAttachmentConfigLevel1List")
	public String getAttachmentConfigLevel1List(){
		List<AttachmentConfigLevel1DO> attachmentConfigLevel1List = attachmentConfigLevel1Service.getAttachmentConfigLevel1List();
        this.resultObj.setData(attachmentConfigLevel1List);
        this.resultObj.setCode("S");
        this.resultObj.setCount(attachmentConfigLevel1Service.count());
        this.resultObj.setMsg("get AttachmentConfigLevel1List OK!");
		return JSONUtils.beanToJson(this.resultObj);
	}
}
