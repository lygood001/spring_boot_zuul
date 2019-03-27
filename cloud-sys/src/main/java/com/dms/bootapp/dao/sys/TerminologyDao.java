package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.TerminologyDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * system terminology dao
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-02-06 13:28:12
 */
@Mapper
@Component
public interface TerminologyDao extends IBaseDao<TerminologyDO> {
    List<TerminologyDO> getTerminologyListBySearchStr(int page, int limits, String v_search_str);

    int countBySearchStr(String v_search_str);

    TerminologyDO getTerminologyDOByID(int id);

    List<TerminologyDO> getTerminologyListByFullName(TerminologyDO terminologyDO);
}
