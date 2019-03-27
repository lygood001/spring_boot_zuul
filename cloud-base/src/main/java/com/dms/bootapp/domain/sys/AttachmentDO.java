package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.io.Serializable;



/**
 * syste attachment (规范审查通过)
 * 
 * @author WangShude
 * @email 939459508@qq.com
 * @date 2019-03-25 11:19:00
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AttachmentDO extends BaseDO implements Serializable {
	  private static final long serialVersionUID = 1L;

        //附件类型
        private String vFileType;
        //业务单号
        private Long nBizId;
        //业务表名称
        private String vBizTable;
        //文件名称后缀
        private String vFileNameExte;
        //附件HTTP地址
        private String vFileUrl;
        //附件名称
        private String vFileName;
                                        

	
	}
