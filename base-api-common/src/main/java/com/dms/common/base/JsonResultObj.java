package com.dms.common.base;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author WSD
 * @Title: JsonResultObj
 * @ProjectName cloud-common
 * @Description: 项目应用中返回json数据基类
 * @date 2018/12/25 13:26
 */
@NoArgsConstructor
@Component
@EqualsAndHashCode(callSuper=false)
public class JsonResultObj<T> extends BootAppJsonBase {
    //default value
    private String code="S";
    private String msg;
    private int count;
    private T data;

    /**
     * Constructor
     * @param code
     * @param msg
     */
    public JsonResultObj(String code,String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        if("E".equalsIgnoreCase(code))
        {
            this.setData(null);
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
