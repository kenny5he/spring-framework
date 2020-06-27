package com.microfoolish.it.spring.demo.test.ioc;

import com.microfoolish.it.spring.demo.pojo.vo.UserVO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {

	/**
	 * IOC 启动运行过程:
	 *  1. 启动
	 *
	 *  2. 运行
	 *  3. 停止
	 */


	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
		// 启动应用上下文
		applicationContext.refresh();
		lookupByType(applicationContext);

		// 关闭应用上下文
		applicationContext.close();
	}

	@Bean
	public UserVO user(){
		UserVO user = new UserVO();
		user.setAge(21);
		user.setName("张雯雯");
		return user;
	}

	private static void lookupByType(BeanFactory beanFactory) {
		UserVO user = beanFactory.getBean(UserVO.class);
		System.out.println("类型加载: " + user);
	}
}
