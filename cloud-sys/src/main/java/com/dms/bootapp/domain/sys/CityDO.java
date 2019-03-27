package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * city domain
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 13:13:48
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CityDO extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

    //province code
    private String vProCode;
    //province name
    private String vProName;
    //city code
    private String vCityCode;
    //city name
    private String vCityName;
    //city initial
    private String vCityFixer;

	}
