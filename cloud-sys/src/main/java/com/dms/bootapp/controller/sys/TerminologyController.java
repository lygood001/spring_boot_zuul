package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.TerminologyDO;
import com.dms.bootapp.service.sys.TerminologyService;
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
@RequestMapping("/terminology")
public class TerminologyController extends BaseController {
    @Autowired
    private TerminologyService terminologyService;


    @RequestMapping("/getTerminologyListBySearchStr")
    public String getProvinceByCodeOrName(int page, int limit,String inParaJsonStr){
        Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String searchStr = "%"+p_json.get("searchStr").toString()+"%";

        List<TerminologyDO> provinceList = terminologyService.getTerminologyListBySearchStr((page - 1) * limit, limit,searchStr);
        this.resultObj.setData(provinceList);
        this.resultObj.setCode("S");
        this.resultObj.setCount(terminologyService.countBySearchStr(searchStr));
        this.resultObj.setMsg("get terminology by searching string OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }

    @RequestMapping("/getTerminologyByID")
    public JsonResultObj getTerminologyByID(String inParaJsonStr ){
        Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        int id = Integer.parseInt(p_json.get("id").toString());

        TerminologyDO domain = terminologyService.getTerminologyDOByID(id);
        this.resultObj.setData(domain);
        this.resultObj.setCode("S");
        this.resultObj.setMsg("get terminology information by id OK!");
        return this.resultObj;
    }
    /**
     * save
     */
    @RequestMapping("/save")
    @Transactional
    public JsonResultObj save(String inParaJsonStr){

        TerminologyDO terminologyDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr,TerminologyDO.class);

        List<TerminologyDO> tmpList =  terminologyService.getTerminologyListByFullName(terminologyDO);
        if(tmpList.size() >0) {
            this.resultObj.setCode("E");
            this.resultObj.setMsg("The terminology information has been existed!");
        }
        else
        {
            if (terminologyService.save(terminologyDO) > 0) {
                this.resultObj.setCode("S");
                this.resultObj.setMsg("Save terminology information OK!");
            } else {
                this.resultObj.setCode("E");
                this.resultObj.setMsg("Save terminology information ERROR!");
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
        TerminologyDO terminologyDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr,TerminologyDO.class);

        if (terminologyService.update(terminologyDO) > 0) {
            this.resultObj.setCode("S");
            this.resultObj.setMsg("Update terminology information OK!");
        } else {
            this.resultObj.setCode("E");
            this.resultObj.setMsg("Update terminology information ERROR!");
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

        if(terminologyService.remove(id)>0){
            resultObj.setCode("S");
            resultObj.setMsg("remove province information OK!");
        }
        else
        {
            resultObj.setCode("E");
            resultObj.setMsg("remove province information ERROR");
        }
        return resultObj;
    }
}
