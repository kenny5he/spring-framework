package com.microfoolish.it.spring.demo.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 案例：Spring Bean的后置处理器
 * 	可修改注入Bean的类，进行类替换，或注入类改名
 * 	使用需将该后置处理器注册到容器中
 *
 * 	<bean id="demoBeanPostProcessor" class="com.microfoolish.it.spring.demo.processer.DemoBeanPostProcessor"></bean>
 *
 */
public class DemoBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		return null;
	}
}
