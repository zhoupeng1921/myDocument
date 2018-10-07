package com.xhx.spring.config;

import com.xhx.spring.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import java.net.UnknownServiceException;

/**
 * xuhaixing
 * 2018/9/28 22:34
 * 后置处理器
 **/
@Configuration
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof User){
            User user = (User)bean;
            user.setAge(18);
        }
        return bean;
    }
}
