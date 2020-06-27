package com.microfoolish.it.spring.demo.test.ioc;

import com.microfoolish.it.spring.demo.pojo.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class DependencyInjectDemo {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-inject-context.xml");
		//IOC Bean来源一: 自定义bean
		UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);
		System.out.println(userRepository);

		// 依赖注入(IOC Bean来源二: 内建依赖)
		System.out.println(userRepository.getBeanFactory());

		System.out.print("Bean Factory Equals: ");
		System.out.println(beanFactory == userRepository.getBeanFactory());

		// 依赖查找 运行结果报错，找不到BeanFactory Bean对象
		// System.out.println(beanFactory.getBean(BeanFactory.class));

		// 获取到User对象
		ObjectFactory userObjectFactory = userRepository.getUserVOObjectFactory();
		System.out.println(userObjectFactory.getObject());

		ObjectFactory objectFactory = userRepository.getObjectFactory();
		System.out.print("Object Factory Equals: ");
		System.out.println(beanFactory == objectFactory.getObject());

		// (IOC Bean来源三: 容器内建Bean)
		Environment environment = beanFactory.getBean(Environment.class);
		System.out.println("获取Environment类型的Bean: "+ environment);
	}

}
