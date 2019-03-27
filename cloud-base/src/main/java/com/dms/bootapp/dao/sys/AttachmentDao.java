package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.AttachmentDO;
import com.dms.common.base.IBaseDao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * system attachment (规范审查通过)
 * @author WangShude
 * @email 939459508@qq.com
 * @date 2019-03-25 11:19:00
 */
@Mapper
@Component
public interface AttachmentDao extends IBaseDao<AttachmentDO> {

    List<AttachmentDO> getAttachmentsByBizId(AttachmentDO attachmentDO);
}
