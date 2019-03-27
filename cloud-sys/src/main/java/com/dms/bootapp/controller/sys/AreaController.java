package com.dms.bootapp.controller.sys;

import com.dms.bootapp.domain.sys.AreaDO;
import com.dms.bootapp.service.sys.AreaService;
import com.dms.common.base.BaseController;
import com.dms.common.base.JsonResultObj;
import com.dms.common.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * App area controller
 *
 * @author WSD
 * @email 9394595508@qq.com
 * @date 2019-01-19 15:11:04
 */

@RestController
@RequestMapping("/area")
public class AreaController extends BaseController {
    @Autowired
    private AreaService areaService;

    @RequestMapping("/getallarealist")
    public JsonResultObj getAllAreaList(String inParaJsonStr) {
        Map<String, Object> p_json = JSONUtils.jsonToMap(inParaJsonStr);

        List<AreaDO> areaList = areaService.getAllAreaList();
        this.resultObj.setData(areaList);
        this.resultObj.setCode("S");
        this.resultObj.setMsg("get all area list OK!");
        return this.resultObj;
    }


}
