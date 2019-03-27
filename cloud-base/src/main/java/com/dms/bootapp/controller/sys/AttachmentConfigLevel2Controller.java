package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.AttachmentConfigLevel2DO;
import com.dms.bootapp.service.sys.AttachmentConfigLevel2Service;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


/**
 * attachment config level2 (规范审查通过)(内置表内置数据)
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 14:05:14
 */

@RestController
@RequestMapping("/attachmentConfigLevel2")
public class AttachmentConfigLevel2Controller extends BaseController {
	@Autowired
	private AttachmentConfigLevel2Service attachmentConfigLevel2Service;

	@Autowired
	private AttachmentConfigLevel2DO attachmentConfigLevel2;

	@RequestMapping("/listByClassType")
	public String listByClassType(int page,int limit,String inParaJsonStr) {
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String vClassType = p_json.get("vClassType").toString();
		List<AttachmentConfigLevel2DO> attachmentConfigLevel2List;
		if(("all").equals(vClassType))
		{
			attachmentConfigLevel2List = attachmentConfigLevel2Service.list((page - 1) * limit, limit);
		}
		else{
			attachmentConfigLevel2List = attachmentConfigLevel2Service.listByClassType((page - 1) * limit, limit,vClassType);
		}
		this.resultObj.setData(attachmentConfigLevel2List);
		this.resultObj.setCode("S");
		this.resultObj.setCount(attachmentConfigLevel2Service.count());
		this.resultObj.setMsg("get AttachmentConfigLevel2List by listByClassType OK!");
		return JSONUtils.beanToJson(this.resultObj);
	}


	@RequestMapping("/getAttachmentConfigID")
	public JsonResultObj getAttachmentConfigID(String inParaJsonStr ){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String id = p_json.get("id").toString();

		AttachmentConfigLevel2DO domain = attachmentConfigLevel2Service.getleval2ById(id);
		this.resultObj.setData(domain);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get version information by id OK!");
		return this.resultObj;
	}

	/**
	 * save
	 */
	@ResponseBody
	@Transactional
	@RequestMapping("/save")
	public JsonResultObj save(String inParaJsonStr){
		/**
		 * Increase your business needs
		 */
		AttachmentConfigLevel2DO attachmentConfigLevel2do = JSONUtils.packingDOFromJsonStr(inParaJsonStr, AttachmentConfigLevel2DO.class);

		if(attachmentConfigLevel2Service.save(attachmentConfigLevel2do)>0){
			resultObj.setCode("S");
			resultObj.setMsg("save AttachmentConfigLevel2 OK!");
			return resultObj;
		}
		resultObj.setCode("E");
		resultObj.setMsg("save AttachmentConfigLevel2 ERROR");
		return resultObj;
	}
	/**
	 * update
	 */
	@ResponseBody
	@Transactional
	@RequestMapping("/update")
	public JsonResultObj update(String inParaJsonStr){
		/**
		 * Increase your business needs
		 */
		AttachmentConfigLevel2DO attachmentConfigLevel2do = JSONUtils.packingDOFromJsonStr(inParaJsonStr, AttachmentConfigLevel2DO.class);

		attachmentConfigLevel2Service.update(attachmentConfigLevel2do);
		resultObj.setCode("S");
		resultObj.setMsg("Update AttachmentConfigLevel2 OK!");  
		return resultObj;
	}

	/**
	 * delete
	 */
	@ResponseBody
	@Transactional
	@RequestMapping( "/remove")
	public JsonResultObj remove(String inParaJsonStr){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String id = (p_json.get("id").toString());

		if(attachmentConfigLevel2Service.remove(id)>0){
			resultObj.setCode("S");
			resultObj.setMsg("remove AttachmentConfigLevel2 OK!");
			return resultObj;
		}
		resultObj.setCode("E");
		resultObj.setMsg("remove AttachmentConfigLevel2DO ERROR");
		return resultObj;
	}

}
