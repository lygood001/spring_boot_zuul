package com.dms.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author WSD
 * @Title: WebPerformanceAspect
 * @ProjectName cloud-common
 * @Description: AOP切片: 记录所有web请求性能情况
 * @date 2018/12/28 10:41
 * Remark: The classes of AOP inner methods should not be published!
 */
@Aspect
@Component
@Slf4j
@Order(2)
public class WebPerformanceAspect {
    @Pointcut("execution( * com.dms.boot*.controller..*.*(..))")
    private void webPerformancePointCut() {
    }

    /**
     *  Before http response, we will receive the request and record the content of the request
     * @param joinPoint
     */
    @Before("webPerformancePointCut()")
    private void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("WebPerformanceAspect--> HTTP METHOD : " + request.getMethod());
        log.info("WebPerformanceAspect--> CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."  + joinPoint.getSignature().getName());
        log.info("WebPerformanceAspect--> HTTP IN PARAMETER JSON STRING : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     *  The value of returning is same with the parameter name of doAfterReturning
     * @param returnJsonObj
     */
    @AfterReturning(returning = "returnJsonObj", pointcut = "webPerformancePointCut()")
    private void doAfterReturning(Object returnJsonObj){
        log.info("WebPerformanceAspect--> HTTP RESPONSE VALUE : " + returnJsonObj);
    }

    /**
     * Record performance time-consuming logs
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("webPerformancePointCut()")
    private Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();
        long timeCost = System.currentTimeMillis() - startTime;
        log.info("WebPerformanceAspect--> TIME CONSUMING : " + timeCost +" ms");

        return ob;
    }
}
