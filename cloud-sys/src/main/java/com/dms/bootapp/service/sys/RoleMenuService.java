package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.RoleMenuDO;

import java.util.List;

public interface RoleMenuService {
    List<RoleMenuDO> listAll(String value);
    int save(List<RoleMenuDO> ids, String roleId, String roleMenuType);
    int remove(String id, String roleMenuType);

}
