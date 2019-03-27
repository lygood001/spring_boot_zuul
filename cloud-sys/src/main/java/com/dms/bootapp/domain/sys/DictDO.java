package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * system dictionary
 * 
 * @author SJF
 * @email 275724057@qq.com
 * @date 2019-01-24 15:26:26
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DictDO extends BaseDO implements Serializable {
        private static final long serialVersionUID = 1L;
        //dictionary main code
        private String vMainCode;
        //dictionary main name
        private String vMainName;
        //dictionary item code
        private String vCode;
        //dictionary item description
        private String vDesc;
        //sort
        private String nSort;
        //stop flag
        private String vStopFlag;
        //stop datetime
        private String dStop;
        //ramark
        private String vRemark;
}
