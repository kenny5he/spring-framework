package com.microfoolish.it.spring.demo.test.ioc;

import com.microfoolish.it.spring.demo.annotation.Super;
import com.microfoolish.it.spring.demo.pojo.vo.UserVO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找方式
 */
public class DependencyLookupDemo {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
		lookupRealTime(beanFactory);
		lookupInLazy(beanFactory);
	}

	private static void lookupInLazy(BeanFactory beanFactory) {
		ObjectFactory<UserVO> objectFactory = (ObjectFactory<UserVO>)beanFactory.getBean("objectFactory");
		UserVO user = objectFactory.getObject();
		System.out.println("延时加载: " + user);
	}

	private static void lookupRealTime(BeanFactory beanFactory) {
		UserVO user = beanFactory.getBean("user",UserVO.class);
		System.out.println("实时加载: " + user);
	}

	private static void lookupByType(BeanFactory beanFactory) {
		UserVO user = beanFactory.getBean(UserVO.class);
		System.out.println("类型加载: " + user);
	}

	private static void lookupCollectionsByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
			Map<String,UserVO> userMap = listableBeanFactory.getBeansOfType(UserVO.class);
			System.out.println("通过类型加载所有User集合对象: " + userMap);
		}
	}

	private static void lookupCollectionsByAnnotation(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
			Map<String,UserVO> userMap = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
			System.out.println("通过注解加载所有User集合对象: " + userMap);
		}
	}
}
