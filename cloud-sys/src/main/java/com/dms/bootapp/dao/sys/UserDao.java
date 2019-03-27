package com.dms.bootapp.dao.sys;

import com.dms.bootapp.domain.sys.UserDO;
import com.dms.common.base.IBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * system user information dao
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-28 12:17:39
 */
@Mapper
@Component
public interface UserDao extends IBaseDao<UserDO> {
    List<UserDO> exeP_APP_Login(String user_account, String user_password);

    public List<UserDO> list(@Param("user") UserDO user, @Param("page") int page, @Param("limit") int limit);

    public UserDO get(String id);

    List<Map<String, Object>> getUserRoleAll(String value);
}
