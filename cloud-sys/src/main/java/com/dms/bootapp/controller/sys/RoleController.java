package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.RoleDO;
import com.dms.bootapp.service.sys.RoleService;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleDO role;

    @RequestMapping("/list")
    public String list(int page, int limit){
        List<RoleDO> roleList = roleService.list((page - 1) * limit, limit);
        this.resultObj.setData(roleList);
        this.resultObj.setCode("S");
        this.resultObj.setCount(roleService.count());
        this.resultObj.setMsg("get role list OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }
    /**
     * save
     */
    @RequestMapping("/save")
    public JsonResultObj save(String inParaJsonStr){

        RoleDO roledo = JSONUtils.packingDOFromJsonStr(inParaJsonStr,RoleDO.class);
        Map<String,String> map = roleService.saveRole(roledo);
        resultObj.setCode(map.get("Code"));
        resultObj.setMsg(map.get("Message"));
        return resultObj;
    }
    /**
     * update
     */
    @RequestMapping("/update")
    public JsonResultObj update(String inParaJsonStr){
        RoleDO roledo = JSONUtils.packingDOFromJsonStr(inParaJsonStr,RoleDO.class);
        int z = roleService.update(roledo);
        if(z > 0){
            resultObj.setCode("S");
            resultObj.setMsg("update role  OK!");
            return resultObj;
        }
        resultObj.setCode("E");
        resultObj.setMsg("update role ERROR");
        return resultObj;
    }

    /**
     * delete
     */
    @RequestMapping( "/remove")
    public JsonResultObj remove(String inParaJsonStr){
        Map<String,Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String id=p_json.get("id").toString();
        if(roleService.remove(id)>0){
            resultObj.setCode("S");
            resultObj.setMsg("remove role OK!");
            return resultObj;
        }
        resultObj.setCode("E");
        resultObj.setMsg("remove role ERROR");
        return resultObj;
    }
}
