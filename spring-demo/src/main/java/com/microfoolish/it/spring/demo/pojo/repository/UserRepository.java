package com.microfoolish.it.spring.demo.pojo.repository;

import com.microfoolish.it.spring.demo.pojo.vo.UserVO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.io.Serializable;
import java.util.Collection;

public class UserRepository implements Serializable {
	private static final long serialVersionUID = -2086443398430678648L;

	// 自定义Bean
	private Collection<UserVO> users;

	// 内建非bean对象(依赖)
	// 内建依赖
	private BeanFactory beanFactory;

	private ObjectFactory<UserVO> userVOObjectFactory;

	private ObjectFactory<ApplicationContext> objectFactory;

	public Collection<UserVO> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserVO> users) {
		this.users = users;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public ObjectFactory<UserVO> getUserVOObjectFactory() {
		return userVOObjectFactory;
	}

	public void setUserVOObjectFactory(ObjectFactory<UserVO> userVOObjectFactory) {
		this.userVOObjectFactory = userVOObjectFactory;
	}

	public ObjectFactory<ApplicationContext> getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
		this.objectFactory = objectFactory;
	}

	@Override
	public String toString() {
		return "UserRepository{" +
				"users=" + users +
				'}';
	}
}
