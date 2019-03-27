package com.dms.bootapp.domain.sys;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserRoleDO {
    private Integer id;
    private Integer userId;
    private Integer roleId;
}
