package com.dms.common.exception;

import com.dms.common.base.JsonResultObj;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author WSD
 * @Title: DMSBootException
 * @ProjectName  cloud-common
 * @Description: 异常处理基类
 * @date 2018/12/28 8 :37
 */
@Data
@Component
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class BootException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private JsonResultObj<Object> bootExceptionJSON;

    public BootException(String msg) {
        super(msg);
        this.bootExceptionJSON.setMsg(msg);
    }

    public BootException(String msg, Throwable e) {
        super(msg, e);
        this.bootExceptionJSON.setMsg(msg);
        this.bootExceptionJSON.setData(e);
    }




}
