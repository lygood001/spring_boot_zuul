package com.dms.bootapp.domain.sys;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author WSD
 * @Title: AppMenuGroupListDO
 * @ProjectName bootapp
 * @Description: App get menu group list info
 * @date 2019/1/22 16:03
 */
@Data
@Component
@ToString
public class MenuGroupDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //menu group from system dictionary menu_group
    private String vMenuGroup;

    //menu group description
    private String vMenuGroupDesc;

    //menu from
    private String vMenuFrom;

    //menu info list
    private List<MenuDO> vMenuList;
}
