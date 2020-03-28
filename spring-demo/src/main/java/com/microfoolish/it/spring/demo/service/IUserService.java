package com.microfoolish.it.spring.demo.service;

import com.github.pagehelper.PageInfo;
import com.microfoolish.it.spring.demo.pojo.bo.UserBO;
import com.microfoolish.it.spring.demo.pojo.param.UserQueryParam;

public interface IUserService {

	PageInfo<UserBO> findUsers(UserQueryParam userQueryParam);

	UserBO getUserInfo(UserQueryParam userQueryParam);

}
