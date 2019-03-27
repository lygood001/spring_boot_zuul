package com.dms.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author WSD
 * @Title: BaseService
 * @ProjectName cloud-common
 * Describe:Spring Application Context Register
 */
@Slf4j
@Component
public class ApplicationContextRegister implements ApplicationContextAware {

    private static ApplicationContext APPLICATION_CONTEXT;

    /**
     * 设置 Application Context
     * @param applicationContext Application Context
     * @throws BeansException
     * */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("ApplicationContextRegister--> setApplicationContext{}", applicationContext);
        APPLICATION_CONTEXT = applicationContext;
    }

    /**
     * 获取Application Context
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    /**
     * 获取Application Context
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> type) {
        return APPLICATION_CONTEXT.getBean(type);
    }
}