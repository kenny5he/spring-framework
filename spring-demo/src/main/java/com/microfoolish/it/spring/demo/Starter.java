package com.microfoolish.it.spring.demo;

import com.microfoolish.it.spring.demo.config.AppConfig;
import com.microfoolish.it.spring.demo.pojo.vo.RoleVO;
import com.microfoolish.it.spring.demo.service.IRoleService;
import com.microfoolish.it.spring.demo.service.impl.RoleService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

public class Starter {

	public static void main(String[] args)throws Exception {
		/**
		 * Spring 启动流程
		 * 1. 扫描
		 * 2. parse --> beanDefinition  存在 beanDefinitionMap(ConcurrentHashMap)中
		 * 3. validate
		 * 4. liftcycle  将beanDefinitionMap中的 BeanDefinition逐个取出注册
		 *
		 * Spring 容器(ApplicationContext){
		 *		DefaultListableBeanFactory#beanDefinitionMap    BeanDefinition Map
		 *		DefaultSingletonBeanRegistry#singletonObjects   容器单例池Map (Bean Map)(getBean从此获取值)
		 *
		 * }
		 *
		 */
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		/**
		 * 因为 AnnotatedBeanDefinitionReader的底层 doRegisterBean 实现为 AnnotatedGenericBeanDefinition
		 * 并且 AnnotatedGenericBeanDefinition 是继承了 GenericBeanDefinition
		 * 所以能将 RoleService 实例化为了一个Bean
		 */
		//ac.register(RoleService.class);

		/*
		 * RoleService 通过 @Component注解方式，BeanDefinition类型为 ScannedGenericBeanDefinition
		 */
		ac.register(AppConfig.class);

		//Spring 默认支持循环引用(单例模式，并且以set方式注入) 关闭循环引用
		//DefaultListableBeanFactory defaultListableBeanFactory = ac.getDefaultListableBeanFactory();
		//defaultListableBeanFactory.setAllowCircularReferences(false);
		/**
		 * 手动注册一个 BeanDefinition
		 * 等同于
		 * <bean id="roleService" class="com.microfoolish.it.spring.demo.service.impl.RoleService" scope="singleton"></bean>
		 */
//		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
//		genericBeanDefinition.setBeanClass(RoleService.class);
//		genericBeanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
//		ac.registerBeanDefinition("roleService",genericBeanDefinition);
		/**
		 * {@link org.springframework.context.support.AbstractApplicationContext#refresh}
		 **/
		ac.refresh();

		IRoleService roleService = ac.getBean("roleService",IRoleService.class);
		RoleVO roleVO = new RoleVO();
		Set<ConstraintViolation<RoleVO>> result = Validation.buildDefaultValidatorFactory().getValidator().validate(roleVO);
		System.out.println(result);
		roleService.getRoleVO(roleVO);
		System.out.println(roleService);
		System.out.println(ac.getBeanDefinition("roleService").getClass().getSimpleName());
	}
}
