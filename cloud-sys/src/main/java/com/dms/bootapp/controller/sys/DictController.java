package com.dms.bootapp.controller.sys;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dms.bootapp.domain.sys.DictDO;
import com.dms.bootapp.service.sys.DictService;
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
 * system dictionary
 *
 * @author SJF
 * @email 2757240527@qq.com
 * @date 2019-01-23 10:05:53
 */

@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;

    @RequestMapping("/getDictList")
    public String list(int page, int limit, String inParaJsonStr) {
        List<DictDO> dictList = dictService.list((page - 1) * limit, limit);
        this.resultObj.setData(dictList);
        this.resultObj.setCode("S");
        this.resultObj.setCount(dictService.count());
        this.resultObj.setMsg("get all dictionary lists OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }

    @RequestMapping("/getDictItemsByCode")
    public String getDictItemsByCode(int page, int limit, String inParaJsonStr) {
        Map<String, Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String v_dict_code = "%" + p_json.get("vDictCode").toString() + "%";
        List<DictDO> dict_item_list = dictService.getDictItemsByCode((page - 1) * limit, limit, v_dict_code);
        this.resultObj.setCount(dictService.countByDictCode(v_dict_code));
        this.resultObj.setData(dict_item_list);
        this.resultObj.setCode("S");
        this.resultObj.setMsg("get dictionary items by dictionary code OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }

    /**
     * save
     */
    @RequestMapping("/saveDictItem")
    public JsonResultObj save(String inParaJsonStr) {
        DictDO dictdo = JSONUtils.packingDOFromJsonStr(inParaJsonStr,DictDO.class);
        List<DictDO> dictList = dictService.checkSameDictItem(dictdo);
        if (dictList.size() > 0) {
            resultObj.setCode("E");
            resultObj.setMsg("已经存在相同的数据字典代码，请重新输入!");
        } else {
            if (dictService.save(dictdo) > 0) {
                resultObj.setCode("S");
                resultObj.setMsg("save dictionary item OK!");
            } else {
                resultObj.setCode("E");
                resultObj.setMsg("save dictionary item ERROR");
            }
        }
        return resultObj;
    }

    /**
     * getDictDetailById
     */
    @RequestMapping("/getDictDetailById")
    public JsonResultObj getDictDetailById(String inParaJsonStr) {
        Map<String,Object> map = JSONUtils.jsonToMap(inParaJsonStr);
        String id = map.get("id").toString();
            List<DictDO> dictDetail = dictService.getDictDetailById(id);
            resultObj.setCode("S");
            resultObj.setData(dictDetail);
            resultObj.setMsg("get dictionary detail by id is OK!");

        return resultObj;
    }

    /**
     * update
     */
    @RequestMapping("/updateDictItem")
    public JsonResultObj update(String inParaJsonStr) {
        DictDO dictdo = JSONUtils.packingDOFromJsonStr(inParaJsonStr,DictDO.class);
        if (dictService.update(dictdo) > 0) {
            resultObj.setCode("S");
            resultObj.setMsg("update dictionary item OK!");
        } else {
            resultObj.setCode("E");
            resultObj.setMsg("update dictionary item ERROR");
        }
        return resultObj;
    }

    /**
     * delete
     */
    @RequestMapping("/removeDictItem")
    public JsonResultObj remove(String inParaJsonStr) {
        Map<String,Object> map = JSONUtils.jsonToMap(inParaJsonStr);
        String id = map.get("id").toString();
        if (dictService.remove(id) > 0) {
            resultObj.setCode("S");
            resultObj.setMsg("remove dictionary item OK!");
        } else {
            resultObj.setCode("E");
            resultObj.setMsg("remove dictionary item ERROR");
        }
        return resultObj;
    }

    /**
     * delete checked dict
     */
    @RequestMapping("/deleteCheckedItem")
    public JsonResultObj deleteCheckedItem(String inParaJsonStr) {
        DictDO dictdo = new DictDO();
        Map<String, Object> map = JSONUtils.jsonToMap(inParaJsonStr);
        String json = map.get("checkedItem").toString();
        JSONArray delete_dict_array = JSONArray.parseArray(json);
        List<DictDO> list = JSONObject.parseArray(delete_dict_array.toJSONString(), DictDO.class);
        if (list.size() > 0) {
            int deleteCount = dictService.deleteCheckedItem(list);
            if (list.size() == deleteCount) {
                resultObj.setCode("S");
                resultObj.setMsg("delete dictionary items by batch OK!");
            } else {
                resultObj.setCode("E");
                resultObj.setMsg("delete dictionary items by batch error!");
            }
        } else {
            resultObj.setCode("E");
            resultObj.setMsg("delete dictionary items by batch error!");
        }
        return resultObj;
    }

    @RequestMapping("/getDictItemForList")
    public String getDictItemForList(String inParaJsonStr) {
        Map<String, Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);
        String v_dict_code = p_json.get("vDictCode").toString();
        List<DictDO> dict_item_list = dictService.getDictItemForList(v_dict_code);
        this.resultObj.setData(dict_item_list);
        this.resultObj.setCode("S");
        this.resultObj.setMsg("get dictionary items by dictionary code OK!");
        return JSONUtils.beanToJson(this.resultObj);
    }
}
