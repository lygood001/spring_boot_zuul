package com.dms.bootapp.service.net;

import com.dms.bootapp.domain.net.BrandDO;
import com.dms.common.base.IBaseService;

import java.util.List;

/**
 * Audi net department compete brand
 * 
 * @author chenDQ
 * @email 18444155288@163.com
 * @date 2019-01-30 09:59:08
 */
public interface BrandService extends IBaseService<BrandDO> {
    public BrandDO get(String id);
    List<BrandDO> checkBrandCode(BrandDO brand);
    List<BrandDO> getAllBrandList();
}
