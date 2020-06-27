package com.microfoolish.it.spring.demo.test.ioc;

import com.microfoolish.it.spring.demo.pojo.vo.UserVO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class IoCContainerDemo {

	public static void main(String[] args) {
		// 创建BeanFactory 容器
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 加载配置
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		// 根据配置文件路径加载Bean Definition
		int loadCount = reader.loadBeanDefinitions("classpath:/META-INF/dependency-inject-context.xml");
		lookupByType(beanFactory);
	}


	private static void lookupByType(BeanFactory beanFactory) {
		UserVO user = beanFactory.getBean(UserVO.class);
		System.out.println("类型加载: " + user);
	}
}
