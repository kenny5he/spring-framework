package com.microfoolish.it.spring.demo.core.ioc;

import com.microfoolish.it.spring.demo.service.impl.ReRouteService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

//@Component
public class RouteBeanFactoryPostProcesser implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition bd =  beanFactory.getBeanDefinition("routeService");
		// 对某个jar包中 某个配置的BeanDefinition 进行修改
		bd.setBeanClassName(ReRouteService.class.getName());
	}
}
