package com.microfoolish.it.spring.demo.service.impl;

import com.microfoolish.it.spring.demo.pojo.vo.RoleVO;
import com.microfoolish.it.spring.demo.service.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class RoleService implements IRoleService {


	@Override
	public RoleVO getRoleVO(RoleVO role) {
		RoleVO result = new RoleVO();
		BeanUtils.copyProperties(result,role);
		return result;
	}
}
