package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.ParamterDO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * system paramter(规范审查通过)
 *
 * @author chenDQ
 * @email 18444155288@163.com
 * @date 2019-02-25 14:47:17
 */
public interface ParamterService  extends IBaseService<ParamterDO> {
    public ParamterDO get(String id);
    List<ParamterDO> checkParamterCode(ParamterDO brand);
}
