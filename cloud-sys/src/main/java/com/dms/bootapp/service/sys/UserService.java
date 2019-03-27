package com.dms.bootapp.service.sys;

import com.dms.bootapp.domain.sys.UserDO;
import com.dms.common.base.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * system user information(规范审查通过)
 * 
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-28 12:17:39
 */
public interface UserService extends IBaseService<UserDO> {
    List<UserDO> exeP_APP_Login(String user_account, String user_password);

    public List<UserDO> list(UserDO user, int page, int limt);

    public UserDO get(String id);

    List<Map<String, Object>> getUserRoleAll(String value);
}
