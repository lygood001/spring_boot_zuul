package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.TerminologyDO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * system terminology service
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-02-06 13:28:12
 */
public interface TerminologyService  extends IBaseService<TerminologyDO> {
    List<TerminologyDO> getTerminologyListBySearchStr(int page, int limit, String v_search_str);

    int countBySearchStr(String v_search_str);

    TerminologyDO getTerminologyDOByID(int id);

    List<TerminologyDO> getTerminologyListByFullName(TerminologyDO terminologyDO);
}
