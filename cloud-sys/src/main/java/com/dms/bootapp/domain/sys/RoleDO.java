package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * Role domain
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 15:51:52
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RoleDO extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

        private String vCode;
        //角色描述
        private String vDesc;
        //停用标识
        private String vStopFlag;
        //停用人
        private Integer nStop;
        //停用时间
        private String dStop;
}
