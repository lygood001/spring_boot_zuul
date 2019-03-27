package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.CityDO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * city service
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 13:13:48
 */
public interface CityService  extends IBaseService<CityDO> {

    List<CityDO> getDictItemsByCode(String v_dict_code);

    CityDO getCityDetail(String id);

    List<CityDO> cityListByProvince(int page, int limit, String vProCode);

    int countBypro(String vProCode);

    List<CityDO> getCityListByProCode(String proCode);

    int countByProCode(String proCode);

    List<CityDO>  cityListOrderBy();
}
