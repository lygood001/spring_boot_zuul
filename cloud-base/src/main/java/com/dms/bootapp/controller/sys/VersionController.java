package com.dms.bootapp.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dms.bootapp.domain.sys.VersionDO;
import com.dms.bootapp.service.sys.VersionService;
import com.dms.common.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;

import javax.transaction.Transactional;

/**
 * App version controller
 * 
 * @author WSD
 * @email 9394595508@qq.com
 * @date 2019-01-19 15:11:04
 */

@RestController
@RequestMapping("/version")
public class VersionController extends BaseController {
	@Autowired
	private VersionService versionService;

	@RequestMapping("/getVersionByType")
	public JsonResultObj getVersionByType(String inParaJsonStr ){
		int a = 1002/0;
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String v_os_type = p_json.get("vosType").toString();

		VersionDO domain = versionService.getByType(v_os_type);
		this.resultObj.setData(domain);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get version information by type OK!");
		return this.resultObj;
	}

    @RequestMapping("/getVersionByID")
    public JsonResultObj getVersionByID(String inParaJsonStr ){
        Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String id = p_json.get("id").toString();

        VersionDO domain = versionService.get(id);
        this.resultObj.setData(domain);
        this.resultObj.setCode("S");
        this.resultObj.setMsg("get version information by id OK!");
        return this.resultObj;
    }

	@RequestMapping("/exe_P_APP_GetVersion")
	@Transactional
	public JsonResultObj exe_P_APP_GetVersion(String inParaJsonStr ){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		Integer id = Integer.parseInt(p_json.get("id").toString());

		Map<String,Object> exeP_APP_GetVersion_param = new HashMap<String, Object>();
		exeP_APP_GetVersion_param.put("p_1",id);
		exeP_APP_GetVersion_param.put("p_2","aaass");
		exeP_APP_GetVersion_param.put("prm_code","");
		exeP_APP_GetVersion_param.put("prm_message","");

		List<VersionDO> appVersionList = versionService.exeP_APP_GetVersion(exeP_APP_GetVersion_param);
		String prm_code = exeP_APP_GetVersion_param.get("prm_code").toString();
		String prm_message = exeP_APP_GetVersion_param.get("prm_message").toString();

		if("S".equalsIgnoreCase(prm_code))
		{
			this.resultObj.setMsg(prm_message);
			this.resultObj.setData(appVersionList);
		}
		else
		{
			this.resultObj.setCode(prm_code);
			this.resultObj.setMsg(prm_message);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return this.resultObj;
	}

	@RequestMapping("/versionList")
	public String list(int page, int limit,String InParaJsonStr){
		List<VersionDO> versionList = versionService.list((page - 1) * limit, limit);
		this.resultObj.setData(versionList);
		this.resultObj.setCode("S");
		this.resultObj.setCount(versionService.count());
		this.resultObj.setMsg("get version information OK!");
		return JSONUtils.beanToJson(this.resultObj);
	}

	@RequestMapping( "/remove")
	public JsonResultObj remove(String inParaJsonStr){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);//analysis data
		String id = p_json.get("id").toString();
		if(versionService.remove(id)>0){
			resultObj.setCode("S");
			resultObj.setMsg("remove version information OK!");
		}
		else
		{
			resultObj.setCode("E");
			resultObj.setMsg("remove version information ERROR");
		}

		return resultObj;
	}

    @RequestMapping("/save")
    public JsonResultObj save(String inParaJsonStr){
		VersionDO versionDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr,VersionDO.class);
        if(versionService.save(versionDO)>0){
            resultObj.setCode("S");
            resultObj.setMsg("save version information OK!");
        }else{
			resultObj.setCode("E");
			resultObj.setMsg("save version information ERROR");
		}
        return resultObj;
    }

	@RequestMapping("/update")
	public JsonResultObj update(String inParaJsonStr){
		VersionDO versionDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr,VersionDO.class);
		if(versionService.update(versionDO)>0){
			resultObj.setCode("S");
			resultObj.setMsg("update version information OK!");
		} else {
			resultObj.setCode("E");
			resultObj.setMsg("update version information error!");
		}
		return resultObj;
	}
}
