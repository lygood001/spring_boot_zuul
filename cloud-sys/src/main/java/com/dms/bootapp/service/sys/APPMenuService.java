package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.MenuDO;
import com.dms.common.base.IBaseService;

/**
 * system menu(规范审查通过)
 * 
 * @author ZSS
 * @email 19148911@qq.com
 * @date 2019-01-25 12:38:17
 */
public interface APPMenuService extends IBaseService<MenuDO> {
    MenuDO getAppMenuByMenuCode(String menuCode);
    int countById(String id);
    int countAttById(String id);
    String autoIncrement(String tableName);
}
