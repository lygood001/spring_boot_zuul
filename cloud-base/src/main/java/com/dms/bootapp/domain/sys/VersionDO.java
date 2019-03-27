package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author WSD
 * @Title: VersionDO
 * @Description: App version domain object
 * @date 2018/12/2515:38
 */
@Data
@Component
@ToString
public class VersionDO extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	//mobile system type
	private String vOsType;
	//version code
	private String vVersion;
	//app name
	private String vAppName;
	//app download net url
	private String vApkUrl;
	//ios checking flag. Y/N
	private String vInStore;
	//remark
	private String vRemark;
}
