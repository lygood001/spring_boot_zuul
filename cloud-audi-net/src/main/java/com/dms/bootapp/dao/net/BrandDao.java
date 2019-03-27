package com.dms.bootapp.dao.net;

import com.dms.bootapp.domain.net.BrandDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Audi net department compete brand
 * @author chenDQ
 * @email 18444155288@163.com
 * @date 2019-01-30 09:59:08
 */
@Mapper
@Component
public interface BrandDao extends IBaseDao<BrandDO> {
    BrandDO get(String id);
    List<BrandDO> checkBrandCode(BrandDO brand);
    List<BrandDO> getAllBrandList();
}
