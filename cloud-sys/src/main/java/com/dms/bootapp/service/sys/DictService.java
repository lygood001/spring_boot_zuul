package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.DictDO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * system dictionary service
 * 
 * @author SJF
 * @email 275724057@qq.com
 * @date 2019-01-24 15:26:26
 */
public interface DictService extends IBaseService<DictDO> {
     List<DictDO> getDictDetailById(String id);

     List<DictDO> getDictItemsByCode(int page, int limit, String v_dict_code);

     int countByDictCode(String v_dict_code);

     List<DictDO> checkSameDictItem(DictDO dictdo);

     int deleteCheckedItem(List<DictDO> list);

     List<DictDO> getDictItemForList(String vCode);
}
