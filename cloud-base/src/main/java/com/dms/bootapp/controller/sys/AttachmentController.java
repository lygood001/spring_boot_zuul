package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.AttachmentDO;
import com.dms.bootapp.service.sys.AttachmentService;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * attachment controller(规范审查通过)(内置表内置数据)
 *
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 14:05:14
 */

@RestController
@RequestMapping("/attachment")
public class AttachmentController extends BaseController {
	@Autowired
	private AttachmentService attachmentService;

	@RequestMapping("/getAttachmentsByBizId")
	public JsonResultObj getAttachmentsByBizId(String inParaJsonStr ){
		AttachmentDO attachmentDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr,AttachmentDO.class);

		List<AttachmentDO>  domain = attachmentService.getAttachmentsByBizId(attachmentDO);
		this.resultObj.setData(domain);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get attachments information by biz id OK!");
		return this.resultObj;
	}

}
