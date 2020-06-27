package com.microfoolish.it.spring.demo.pojo.vo;

public class SuperUserVO extends UserVO{
	private static final long serialVersionUID = 2117022406672811877L;

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SuperUserVO{" +
				"address='" + address + '\'' +
				"} " + super.toString();
	}
}
