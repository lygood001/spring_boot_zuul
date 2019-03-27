package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * system province
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-30 14:38:24
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProvinceDO extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//area code
    private String vAreaCode;
    //area description
    private String vAreaDesc;
    //province code
    private String vProCode;
    //province name
    private String vProName;
    //province initial
    private String vProFixer;

}
