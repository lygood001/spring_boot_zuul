package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.CityDO;
import com.dms.bootapp.service.sys.CityService;
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
 * system city
 * 
 * @author GSY
 * @email 247140906@qq.com
 * @date 2019-01-23 10:05:53
 */

@RestController
@RequestMapping("/city")
public class CityController extends BaseController {
	@Autowired
	private CityService cityService;

	@RequestMapping("/cityListByProvince")
	public String cityListByProvince(int page, int limit, String inParaJsonStr) {

		Map<String, Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String vProCode = p_json.get("vProCode").toString()+"%";

		List<CityDO> cityList = cityService.cityListByProvince((page - 1) * limit, limit,vProCode);
		this.resultObj.setData(cityList);
		this.resultObj.setCode("S");
		this.resultObj.setCount(cityService.countBypro(vProCode));
		this.resultObj.setMsg("get city information list OK!");
		return JSONUtils.beanToJson(this.resultObj);
	}


	/**
	 * delete
	 */
	@RequestMapping("/remove")
	public JsonResultObj remove(String inParaJsonStr) {
		Map<String, Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String id = p_json.get("id").toString();
            if (cityService.remove(id) > 0) {
                resultObj.setCode("S");
			resultObj.setMsg("remove city information OK!");
		}else {
				resultObj.setCode("E");
				resultObj.setMsg("remove city information error");
			}
		return resultObj;
	}

	/**
	 * save
	 */
	@RequestMapping("/save")
	public JsonResultObj save(String inParaJsonStr) {
		CityDO cityDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr,CityDO.class);
		if (cityService.save(cityDO) > 0) {
			resultObj.setCode("S");
			resultObj.setMsg("save city information OK!");
		}else {
			resultObj.setCode("E");
			resultObj.setMsg("save city information error!");
		}
		return resultObj;
	}

	/**
	 * update
	 */
	@RequestMapping("/update")
	public JsonResultObj update(String inParaJsonStr) {
		CityDO cityDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr,CityDO.class);
		if (cityService.update(cityDO) > 0) {
			resultObj.setCode("S");
			resultObj.setMsg("update city information OK!");
		}
		else {
			resultObj.setCode("E");
			resultObj.setMsg("update city information error!");
		}
		return resultObj;
	}

	@RequestMapping("/getCityListByProCode")
	public String getCityListByProCode(String inParaJsonStr){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String proCode = p_json.get("vProCode").toString();
		List<CityDO> cityList = cityService.getCityListByProCode(proCode);
		this.resultObj.setData(cityList);
		this.resultObj.setCode("S");
		this.resultObj.setCount(cityService.countByProCode(proCode));
		this.resultObj.setMsg("get province lists by area code OK!");
		return JSONUtils.beanToJson(this.resultObj);
	}

    @RequestMapping("/cityListOrderBy")
    public String cityListOrderBy(String inParaJsonStr){
        List<CityDO> cityList = cityService.cityListOrderBy();
        this.resultObj.setData(cityList);
        this.resultObj.setCode("S");
        this.resultObj.setMsg("get city List Order By OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }

	@RequestMapping("/getCityDetail")
	public String getCityDetail(String inParaJsonStr){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String id = p_json.get("id").toString();
		CityDO city = cityService.getCityDetail(id);
		this.resultObj.setData(city);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get city List Order By OK!");
		return JSONUtils.beanToJson(this.resultObj);
	}

}