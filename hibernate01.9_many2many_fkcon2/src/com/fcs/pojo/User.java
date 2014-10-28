package com.fcs.pojo;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable{
	private int id;
	private String name;
	
	private Set<Role> r;
	
	
	public Set<Role> getR() {
		return r;
	}
	public void setR(Set<Role> r) {
		this.r = r;
	}
	private Role c;
	
	public Role getC() {
		return c;
	}
	public void setC(Role c) {
		this.c = c;
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
