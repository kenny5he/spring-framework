package com.microfoolish.it.spring.demo.processer;

import com.microfoolish.it.spring.demo.interceptor.DemoCglibProxyMethodInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Demo 实例化Bean
 */
public class DemoInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		// 利用 其 生成动态代理
		// if(beanClass instanceof TestFb){
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(beanClass);
			enhancer.setCallback(new DemoCglibProxyMethodInterceptor());
			// TestFb testFb = (TestFb)enhancer.create();
			// System.out.print("返回动态代理\n");
			return null;
		// }
		// return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		return false;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		return null;
	}


	/************************************* BeanPostProcessor 提供的方法 *****************************************/

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}
}
