package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.ParamterDO;
import com.dms.bootapp.service.sys.ParamterService;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * system paramter(规范审查通过)
 * 
 * @author chenDQ
 * @email 18444155288@163.com
 * @date 2019-02-25 14:47:17
 */

@RestController
@RequestMapping("/paramter")
public class ParamterController extends BaseController {
	@Autowired
	private ParamterService paramterService;

    @Autowired
	private ParamterDO paramter;


    @ResponseBody
	@RequestMapping("/list")
	public String list(int page, int limit){
		List<ParamterDO> paramterList = paramterService.list((page - 1) * limit, limit);
        this.resultObj.setData(paramterList);
        this.resultObj.setCode("S");
        this.resultObj.setCount(paramterService.count());
        this.resultObj.setMsg("获取参数列表成功");
		return JSONUtils.beanToJson(this.resultObj);
	}
	/**
	 * save
	 */
    @ResponseBody
	@RequestMapping("/save")
	public JsonResultObj save(String inParaJsonStr){
        /**
        * Increase your business needs
        */
		ParamterDO paramter = JSONUtils.packingDOFromJsonStr(inParaJsonStr,ParamterDO.class);
		if(paramterService.checkParamterCode(paramter).size()>0){
			resultObj.setCode("E");
			resultObj.setMsg("参数代码重复");
		}else {
			if (paramterService.save(paramter) > 0) {
				resultObj.setMsg("添加成功");
			} else {
				resultObj.setCode("E");
				resultObj.setMsg("添加失败");
			}
		}
		return resultObj;
	}
	/**
	 * update
	 */
    @ResponseBody
	@RequestMapping("/update")
	public JsonResultObj update(String inParaJsonStr){
        /**
         * Increase your business needs
         */
		ParamterDO paramter = JSONUtils.packingDOFromJsonStr(inParaJsonStr,ParamterDO.class);
		if(paramterService.update(paramter)>0){
			resultObj.setMsg("Successful Change of Paramter Information!");
		}else{
			resultObj.setCode("E");
			resultObj.setMsg("Failure to change Paramter information!");
		}
        return resultObj;
	}

	/**
	 * delete
	 */
    @ResponseBody
	@RequestMapping( "/remove")
	public JsonResultObj remove(String inParaJsonStr){
		Map<String,Object> map= JSONUtils.jsonToMap(inParaJsonStr);
		String id=map.get("id").toString();
		if(paramterService.remove(id)>0){
            resultObj.setMsg("删除成功");
		}else{
			resultObj.setCode("E");
			resultObj.setMsg("删除成功删除失败");
		}
        return resultObj;
	}
	@RequestMapping("/getParamterByid")
	public String getParamterByid(String inParaJsonStr){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String id = p_json.get("id").toString();
		ParamterDO paramterList = paramterService.get(id);
		this.resultObj.setData(paramterList);
		this.resultObj.setCode("S");
		this.resultObj.setCount(paramterService.count());
		this.resultObj.setMsg("获取参数列表成功");
		return JSONUtils.beanToJson(this.resultObj);
	}
}
