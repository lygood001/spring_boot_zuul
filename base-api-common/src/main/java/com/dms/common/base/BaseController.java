package com.dms.common.base;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author WSD
 * @Title: BaseClass
 * @ProjectName cloud-common
 * @Description: Controller层的基类
 * @date 2019/1/22 13:57
 */
public class BaseController{
    @Autowired
    public JsonResultObj resultObj;
}
