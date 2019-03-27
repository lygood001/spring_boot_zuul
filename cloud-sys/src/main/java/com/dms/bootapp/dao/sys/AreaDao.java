package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.AreaDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  area dao
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-30 17:35:31
 */
@Mapper
@Component
public interface AreaDao extends IBaseDao<AreaDO> {
    List<AreaDO> getAllAreaList();
}
