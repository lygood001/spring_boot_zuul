package com.dms.bootapp.dao.sys;


import com.dms.bootapp.domain.sys.CityDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * city dao
 * @author GSY
 * @email 939459508@qq.com
 * @date 2019-01-24 13:13:48
 */
@Mapper
@Component
public interface CityDao extends IBaseDao<CityDO> {

    CityDO getCityDetail(String id);

    List<CityDO>  cityListByProvince(int page, int limits, String vProCode);

    int countBypro(String vProCode);

    List<CityDO> getCityListByProCode(String proCode);

    int countByProCode(String proCode);

    List<CityDO> cityListOrderBy();
}
