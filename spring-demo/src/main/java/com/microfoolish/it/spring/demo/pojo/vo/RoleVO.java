package com.microfoolish.it.spring.demo.pojo.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoleVO extends BaseVO{
	private static final long serialVersionUID = -5072111799261463049L;
	@NotNull
	private Long roleId;

	@NotEmpty
	private String roleName;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
