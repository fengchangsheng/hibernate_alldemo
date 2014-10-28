package com.fcs.pojo;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable{
	private int id;
	private String name;
	private Set<User> u;
	//一方持有多方集合
	
	public int getId() {
		return id;
	}
	public Set<User> getU() {
		return u;
	}
	public void setU(Set<User> u) {
		this.u = u;
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
