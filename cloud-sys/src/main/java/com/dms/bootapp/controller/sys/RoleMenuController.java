package com.dms.bootapp.controller.sys;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dms.bootapp.domain.sys.RoleMenuDO;
import com.dms.bootapp.service.sys.RoleMenuService;
import com.dms.common.base.BaseController;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/RoleMenu")
public class RoleMenuController extends BaseController {
    @Autowired
    RoleMenuService roleMenuService;

    @RequestMapping("/save")
    public String save(String inParaJsonStr) {
        Map<String, Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String json = p_json.get("menuIds").toString();
        JSONArray menuList = JSONArray.parseArray(json);
        List<RoleMenuDO> lists = JSONObject.parseArray(menuList.toJSONString(), RoleMenuDO.class);
        String id = p_json.get("roleId").toString();
        String roleMenuType = p_json.get("roleMenuType").toString();
        roleMenuService.remove(id, roleMenuType);
        if (lists.size() > 0){
            roleMenuService.save(lists,id, roleMenuType);
        }
        this.resultObj.setCode("S");
        this.resultObj.setMsg("save menu lists OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }
}
