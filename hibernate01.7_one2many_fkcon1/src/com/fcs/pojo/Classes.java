package com.fcs.pojo;

import java.util.Set;

public class Classes {
	private int id;
	private String name;
	private Set<Student> s;
	//一方持有多方集合
	public Set<Student> getS() {
		return s;
	}
	public void setS(Set<Student> s) {
		this.s = s;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
