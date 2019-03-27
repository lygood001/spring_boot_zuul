package com.dms.bootapp.controller.net;

import com.dms.bootapp.domain.net.BrandDO;
import com.dms.bootapp.service.net.BrandService;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Audi net department compete brand
 * 
 * @author chenDQ
 * @email 18444155288@163.com
 * @date 2019-01-30 09:59:08
 */

@RestController
@RequestMapping("/brand")
public class BrandController extends BaseController {
	@Autowired
	private BrandService brandService;

    @Autowired
	private BrandDO brand;

	@RequestMapping("/getBrandByID")
	public JsonResultObj getBrandByID(String inParaJsonStr){
		Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
		String id = p_json.get("id").toString();

		BrandDO domain = brandService.get(id);
		this.resultObj.setData(domain);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get brand information by id OK!");
		return this.resultObj;
	}
	/**
	 * save
	 */
	@RequestMapping("/save")
	public JsonResultObj save(String inParaJsonStr){

		BrandDO brand = JSONUtils.packingDOFromJsonStr(inParaJsonStr,BrandDO.class);
		if (brandService.checkBrandCode(brand).size() > 0) {
			resultObj.setCode("E");
			resultObj.setMsg("品牌代码重复");
		} else {
			if (brandService.save(brand) > 0) {
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
	@RequestMapping("/update")
	public JsonResultObj update(String inParaJsonStr){
        /**
         * Increase your business needs
         */
		BrandDO brand = JSONUtils.packingDOFromJsonStr(inParaJsonStr,BrandDO.class);
		if(brandService.update(brand)>0){
			this.resultObj.setMsg("Successful Change of Brand Information!");
		}else{
			resultObj.setCode("E");
			resultObj.setMsg("Failure to change brand information!");
		}
		return this.resultObj;
	}

	/**
	 * delete
	 */
	@RequestMapping( "/remove")
	public JsonResultObj remove(String inParaJsonStr){
		Map<String,Object> map= JSONUtils.jsonToMap(inParaJsonStr);
		String id=map.get("id").toString();
		if(brandService.remove(id)>0){
            resultObj.setMsg("Successful to Delete Brand!");
		}else{
			resultObj.setCode("E");
			resultObj.setMsg("Failure to Delete Brand!");
		}
        return resultObj;
	}

	@RequestMapping("/getAllBrandList")
	public String getAllBrandList(){
		List<BrandDO> brandAllList = brandService.getAllBrandList();
		this.resultObj.setData(brandAllList);
		this.resultObj.setCode("S");
		this.resultObj.setMsg("get all brandList list OK!");
		return JSONUtils.beanToJson(this.resultObj);
	}

}
