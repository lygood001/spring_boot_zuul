package com.dms.common.base;

import java.util.List;

/**
 * @author WSD
 * @Title: BaseService
 * @ProjectName cloud-common
 * @Description: Base dao
 * @date 2019/1/23 10:50
 */
public interface IBaseDao<T> {
    List<T> list(int page, int limits);

    int save(T t);

    int update(T t);

    int remove(String id);

    int count();
}
