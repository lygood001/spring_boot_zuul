package com.dms.bootapp.service.sys;


import com.dms.bootapp.domain.sys.AttachmentConfigLevel2DO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * attachment config level2 (规范审查通过)(内置表内置数据)
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 14:05:14
 */
public interface AttachmentConfigLevel2Service  extends IBaseService<AttachmentConfigLevel2DO> {
    AttachmentConfigLevel2DO getleval2ById(String id);
    List<AttachmentConfigLevel2DO> listByClassType(int page, int limit, String vClassType);
}
