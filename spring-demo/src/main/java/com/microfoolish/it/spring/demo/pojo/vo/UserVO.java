package com.microfoolish.it.spring.demo.pojo.vo;

public class UserVO extends BaseVO{
	private static final long serialVersionUID = -8688393373376713326L;

	private String name;

	private String nickName;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserVO{" +
				"name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
				", age=" + age +
				'}';
	}
}
