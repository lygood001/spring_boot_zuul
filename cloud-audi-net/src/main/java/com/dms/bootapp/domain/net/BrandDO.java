package com.dms.bootapp.domain.net;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * Audi net department compete brand
 * 
 * @author chenDQ
 * @email 18444155288@163.com
 * @date 2019-01-30 09:59:08
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BrandDO extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

        //compete brand code
        private String vBrandCode;
        //compete brand description
        private String vBrandDesc;
        //html page css color
        private String vCssColor;

        private String vRemark;
        private String nSort;
	
	
	}
