package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * system paramter(规范审查通过)
 *
 * @author chenDQ
 * @email 18444155288@163.com
 * @date 2019-02-25 14:47:17
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ParamterDO extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;
        private String vRemark;
                        //paramter code
        private String vParaCode;
                        //parameter name
        private String vParaName;
                        //from systttem dictionary sys_model
        private String vSysModel;

	}
