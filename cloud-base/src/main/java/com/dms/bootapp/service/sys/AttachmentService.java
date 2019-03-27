package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.AttachmentDO;
import com.dms.common.base.IBaseService;
import java.util.List;

/**
 * syste attachment (规范审查通过)
 * 
 * @author WangShude
 * @email 939459508@qq.com
 * @date 2019-03-25 11:19:00
 */
public interface AttachmentService  extends IBaseService<AttachmentDO>  {

    List<AttachmentDO> getAttachmentsByBizId(AttachmentDO attachmentDO);
}
