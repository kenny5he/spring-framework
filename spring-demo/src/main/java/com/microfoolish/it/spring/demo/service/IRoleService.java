package com.microfoolish.it.spring.demo.service;

import com.microfoolish.it.spring.demo.pojo.vo.RoleVO;
import org.springframework.validation.annotation.Validated;

public interface IRoleService {

	RoleVO getRoleVO(@Validated RoleVO role);

}
