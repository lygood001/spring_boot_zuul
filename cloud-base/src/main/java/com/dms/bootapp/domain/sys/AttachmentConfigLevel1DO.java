package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * attachment config level1 (规范审查通过)(内置表内置数据)
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 13:47:34
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AttachmentConfigLevel1DO extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

        //文件类别
        private String vClassType;
        //文件类别名称
        private String vClassName;
        //文件磁盘路径
        private String vClassFilePath;
        //备注
        private String vRemark;


}
