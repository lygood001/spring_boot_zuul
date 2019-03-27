package com.dms.bootapp.dao.sys;


import com.dms.bootapp.domain.sys.RoleDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * role
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 10:03:16
 */
@Mapper
@Component
public interface RoleDao extends IBaseDao<RoleDO> {

    RoleDO get(Integer value);
    int getCountByCode(String value);
    String getCreaterName(Integer value);
}
