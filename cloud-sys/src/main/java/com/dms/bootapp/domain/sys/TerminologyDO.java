package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * system terminology
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-02-06 13:28:12
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TerminologyDO extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

    //sys model
    private String vModule;
    //sys model
    private String vModuleDesc;
    //chinese full name
    private String vChFullName;
    //english full name
    private String vEnFullName;
    //extension
    private String vExtension;
    //english short name
    private String vEnShortName;
     //chinese description
    private String vChDesc;
    //spell words
    private String vSpellWords;

    //remark
    private String vRemark;
        
}
