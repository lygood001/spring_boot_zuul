package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.ProvinceDO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * system province service
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-30 14:38:24
 */
public interface ProvinceService  extends IBaseService<ProvinceDO> {
    List<ProvinceDO> getProvinceByCodeOrName(int page, int limit, String searchStr);

    int countBySearchStr(String searchStr);

    List<ProvinceDO> getAllProvinceList();

    List<ProvinceDO> getAllProvinceListByAreaCode(String areaCode);

    List<ProvinceDO> getProvinceListCode(String code);

    List<ProvinceDO> getProListByAreaCode(String areaCode);

    int countByAreaCode(String areaCode);

    ProvinceDO getProvinceByCode(String proCode);
}
