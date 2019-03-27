package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.DictDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * system dictionary dao
 * @author SJF
 * @email 275724057@qq.com
 * @date 2019-01-24 15:26:26
 */
@Mapper
@Component
public interface DictDao extends IBaseDao<DictDO> {
    List<DictDO> getDictDetailById(String id);
    List<DictDO> getDictItemsByCode(int page, int limit, String v_dict_code);
    List<DictDO> checkSameDictItem(DictDO dictdo);
    int deleteCheckedItem(List<DictDO> list);
    int countByDictCode(String v_dict_code);
    List<DictDO> getDictItemForList(String vCode);
}
