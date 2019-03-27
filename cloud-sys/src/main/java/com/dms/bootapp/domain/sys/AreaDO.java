package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * system area
 *
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-30 17:35:31
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AreaDO extends BaseDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //area code
    private String vCode;
    //area name
    private String vName;
    //remark
    private String vRemark;

}
