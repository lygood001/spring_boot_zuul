package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@EqualsAndHashCode(callSuper = false)
public class UserDO extends BaseDO implements Serializable {
    private static final long serialVersionUID = 1L;
    //user account
    private String vAccount;
    //user mobile
    private String vMobile;
    //user password
    private String vPassword;
    //salt for decode
    private String vSalt;
    //user real name
    private String vRealName;
    //user nick name
    private String vNickName;
    //age
    private String nAge;
    //user email
    private String vMail;
    //regist way
    private String vRegistWay;
    //user status
    private String vStatus;
    //user city for push service
    private String vCity;
    //stop flag
    private String vStopFlag;
    //stop datetime
    private String dStop;
    //stop user
    private String nStop;
    //ge tui client id
    private String vClientId;

    private String vPORTRAITPATH;

}
