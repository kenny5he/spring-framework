package com.microfoolish.it.spring.demo.service.impl;

import com.github.pagehelper.PageInfo;
import com.microfoolish.it.spring.demo.pojo.bo.UserBO;
import com.microfoolish.it.spring.demo.pojo.param.UserQueryParam;
import com.microfoolish.it.spring.demo.service.IUserService;
import org.springframework.stereotype.Component;

/**
 * @Configuration 本质还是@Component，但是此注解会生成CGLIB代理对象的子类Class，并对方法拦截
 * @Component 不会生成
 */
@Component
public class UserService implements IUserService {

	@Override
	public PageInfo<UserBO> findUsers(UserQueryParam userQueryParam) {
		return null;
	}

	@Override
	public UserBO getUserInfo(UserQueryParam userQueryParam) {
		return null;
	}
}
