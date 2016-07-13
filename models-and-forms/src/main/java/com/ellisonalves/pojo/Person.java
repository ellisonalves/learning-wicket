package com.ellisonalves.pojo;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				name;
	private String				age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}