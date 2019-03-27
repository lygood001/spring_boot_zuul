package com.dms.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

public interface IBootExceptionHandler {
    /**
     * Deal with exception
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler({Exception.class})
    public Object handleException(Exception e, HttpServletRequest request);
}
