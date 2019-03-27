package com.dms.bootapp.domain.sys;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RoleMenuDO {
    Integer id;
    Integer roleId;
    Integer menuId;
    String roleMenuType;
}
