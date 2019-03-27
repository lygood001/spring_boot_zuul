package com.dms.common.base;

import java.util.List;

/**
 * @author WSD
 * @Title: BaseService
 * @ProjectName cloud-common
 * @Description: Base service
 * @date 2019/1/23 10:50
 */
public interface IBaseService<T> {
    List<T> list(int page, int limit);

    int save(T t);

    int update(T t);

    int remove(String id);

    int count();
}
