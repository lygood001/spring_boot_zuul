package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.AttachmentConfigLevel1DO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * attachment config level1 (规范审查通过)(内置表内置数据)
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 13:47:34
 */
public interface AttachmentConfigLevel1Service  extends IBaseService<AttachmentConfigLevel1DO> {
    List<AttachmentConfigLevel1DO> getAttachmentConfigLevel1List();
}
