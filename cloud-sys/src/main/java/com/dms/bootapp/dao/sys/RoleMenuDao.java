package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.RoleMenuDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleMenuDao {
    int save(List<RoleMenuDO> list, String roleId, String roleMenuType);
    int remove(String id, String roleMenuType);
    List<RoleMenuDO> listAll(String value);
}
