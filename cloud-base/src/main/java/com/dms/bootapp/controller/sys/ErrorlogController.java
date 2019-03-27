package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.ErrorLogDO;
import com.dms.bootapp.service.sys.ErrorLogService;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * system error log
 *
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-02-15 15:55:46
 */

@RestController
@RequestMapping("/errorLog")
public class ErrorlogController extends BaseController {
    @Autowired
    private ErrorLogService errorLogService;

    @RequestMapping("/errorLogList")
    public String errorLogList(int page, int limit,String inParaJsonStr){
        Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String dbegin = p_json.get("dbegin").toString();
        String dend = p_json.get("dend").toString();
        List<ErrorLogDO> errorLogList = errorLogService.listBySearchDate((page - 1) * limit, limit,dbegin,dend);
        this.resultObj.setData(errorLogList);
        this.resultObj.setCode("S");
        this.resultObj.setCount(errorLogService.countBySearchDate(dbegin,dend));
        this.resultObj.setMsg("get errorLogList OK!");
        return JSONUtils.beanToJson(this.resultObj);

    }

    @RequestMapping("/writeErrorLog")
    @Transactional
    public JsonResultObj writeErrorLog(String inParaJsonStr){
        ErrorLogDO errorDO = JSONUtils.packingDOFromJsonStr(inParaJsonStr,ErrorLogDO.class);
        if(errorLogService.save(errorDO)>0){
            resultObj.setCode("S");
            resultObj.setMsg("save error log information OK!");
        }else{
            resultObj.setCode("E");
            resultObj.setMsg("save error log information ERROR");
        }
        return resultObj;

    }

}


