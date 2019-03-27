package com.dms.common.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author WSD
 * @Title: BaseDO
 * @ProjectName cloud-common
 * @Description: 项目中所有domain业务实体的基类
 * @date 2019/1/21 16:54
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BaseDO {
    // id
    private int id;
    // creator
    private int nCreator;
    // create datetime
    private String dCreate;
    // update datetime
    private String dUpdate;
    //  creator name
    private String vCreatorName;
}
