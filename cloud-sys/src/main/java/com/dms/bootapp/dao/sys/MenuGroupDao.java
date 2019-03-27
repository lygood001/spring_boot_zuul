package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.MenuGroupDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author WSD
 * @Title: AppMenuGroupListDao
 * @ProjectName bootapp
 * @Description: app menu group dao
 * @date 2019/1/2216:03
 */

@Mapper
@Component
public interface MenuGroupDao extends IBaseDao<MenuGroupDO> {
    @Select(" select distinct a.V_MENU_GROUP,a.V_FROM vMenuFrom,b.V_DESC vMenuGroupDesc " +
            " from sys_menu a " +
            " left join sys_dict b on a.V_MENU_GROUP = b.V_CODE and b.V_MAIN_CODE = 'menu_group' " +
            " where a.V_MENU_TYPE = 'APP' and a.V_STOP_FLAG = '0'")
    List<MenuGroupDO> getAppMenuGroupList();
}
