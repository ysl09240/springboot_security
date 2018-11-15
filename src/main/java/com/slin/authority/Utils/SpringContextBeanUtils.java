package com.slin.authority.Utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取spring容器的对象
 *
 * @author yangsonglin
 * @create 2018-07-12 10:49
 **/
@Component
public class SpringContextBeanUtils implements ApplicationContextAware {
    protected static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       context = applicationContext;
    }

    public static ApplicationContext getContext() {
       return context;
    }

    public static Object getBean(String name){
        return context.getBean(name);
    }

    /**
     * 获取对象 这里重写了bean方法，用类名获取
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return (T) context.getBean(clazz);
    }

}


