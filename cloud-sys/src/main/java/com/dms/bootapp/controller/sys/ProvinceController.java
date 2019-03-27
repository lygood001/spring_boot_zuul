package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.ProvinceDO;
import com.dms.bootapp.service.sys.ProvinceService;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/province")
public class ProvinceController extends BaseController {
    @Autowired
    private ProvinceService provinceService;


    @RequestMapping("/getprovincebycodeorname")
    public String getProvinceByCodeOrName(int page, int limit,String inParaJsonStr){
        Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String searchStr = "%"+p_json.get("searchStr").toString()+"%";

        List<ProvinceDO> provinceList = provinceService.getProvinceByCodeOrName((page - 1) * limit, limit,searchStr);
        this.resultObj.setData(provinceList);
        this.resultObj.setCode("S");
        this.resultObj.setCount(provinceService.countBySearchStr(searchStr));
        this.resultObj.setMsg("get province by code or name OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }

    @RequestMapping("/getallprovincelist")
    public String getAllProvinceList(){
        List<ProvinceDO> provinceList = provinceService.getAllProvinceList();
        this.resultObj.setData(provinceList);
        this.resultObj.setCode("S");
        this.resultObj.setMsg("get all province list OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }

    /**
     * save
     */
    @RequestMapping("/save")
    @Transactional
    public JsonResultObj save(String inParaJsonStr){
        ProvinceDO provinceDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr,ProvinceDO.class);

        List<ProvinceDO> exist_province_list = provinceService.getProvinceListCode(provinceDO.getVProCode());

        if(exist_province_list.size()>0)
        {
            resultObj.setCode("E");
            resultObj.setMsg("Province information has been existed !");
        }
        else
        {
            if(provinceService.save(provinceDO)>0){
                resultObj.setCode("S");
                resultObj.setMsg("save province information OK!");
            } else {
                resultObj.setCode("E");
                resultObj.setMsg("save province information error!");
            }
        }

        return resultObj;
    }

    /**
     * update
     */
    @RequestMapping("/update")
    @Transactional
    public JsonResultObj update(String inParaJsonStr){

        ProvinceDO provinceDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr,ProvinceDO.class);

        if(provinceService.update(provinceDO)>0){
            resultObj.setCode("S");
            resultObj.setMsg("update province information OK!");
        } else {
            resultObj.setCode("E");
            resultObj.setMsg("update province information error!");
        }

        return resultObj;
    }

    /**
     * delete province information
     */
    @RequestMapping( "/remove")
    public JsonResultObj remove(String inParaJsonStr){
        Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String id = p_json.get("id").toString();

        if(provinceService.remove(id)>0){
            resultObj.setCode("S");
            resultObj.setMsg("remove province information OK!");
            return resultObj;
        }
        resultObj.setCode("E");
        resultObj.setMsg("remove province information ERROR");
        return resultObj;
    }

    @RequestMapping("/getProListByAreaCode")
    public String getProListByAreaCode(String inParaJsonStr){
        Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String areaCode = p_json.get("vAreaCode").toString();
        List<ProvinceDO> proList = provinceService.getProListByAreaCode(areaCode);
        this.resultObj.setData(proList);
        this.resultObj.setCode("S");
        this.resultObj.setCount(provinceService.countByAreaCode(areaCode));
        this.resultObj.setMsg("get province lists by area code OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }

    @RequestMapping("/getProvinceByCode")
    public String getProvinceByCode(String inParaJsonStr){
        Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String proCode = p_json.get("proCode").toString();

        ProvinceDO province = provinceService.getProvinceByCode(proCode);
        this.resultObj.setData(province);
        this.resultObj.setCode("S");
        this.resultObj.setCount(provinceService.countByAreaCode(proCode));
        this.resultObj.setMsg("get province lists by area code OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }
}
