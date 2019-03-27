package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.ProvinceDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * system province
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-30 14:38:24
 */
@Mapper
@Component
public interface ProvinceDao extends IBaseDao<ProvinceDO> {

    List<ProvinceDO> getProvinceByCodeOrName(int page, int limits, String searchStr);

    int countBySearchStr(String searchStr);

    List<ProvinceDO> getAllProvinceList();

    List<ProvinceDO> getAllProvinceListByAreaCode(String procode);

    List<ProvinceDO> getProvinceListCode(String code);

    List<ProvinceDO> getProListByAreaCode(String areaCode);

    int countByAreaCode(String areaCode);

    ProvinceDO  getProvinceByCode(String proCode);
}
