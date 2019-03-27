package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.ErrorLogDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * system error log 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-02-15 15:55:46
 */
@Mapper
@Component
public interface ErrorLogDao extends IBaseDao<ErrorLogDO> {
   List<ErrorLogDO> listBySearchDate(int page, int limits, String dbegin, String dend);

   int countBySearchDate(String dbegin, String dend);
}
