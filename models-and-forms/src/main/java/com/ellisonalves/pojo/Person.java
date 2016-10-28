package com.ellisonalves.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				name;
	private Integer			age;

	public Person() {
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public static List<Person> personList() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Ellison", 30));
		personList.add(new Person("Amanda", 29));
		personList.add(new Person("Manuel", 68));
		personList.add(new Person("Maria", 61));
		personList.add(new Person("Rafaela", 14));
		personList.add(new Person("Eduardo", 5));
		personList.add(new Person("Josélia", 44));
		return personList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Person person = (Person) o;

		if (name != null ? !name.equals(person.name) : person.name != null)
			return false;
		return age != null ? age.equals(person.age) : person.age == null;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (age != null ? age.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}