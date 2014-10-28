package com.fcs.pojo;

public class Student {
	private int id;
	private String name;
	
	private Classes c;
	
	public Classes getC() {
		return c;
	}
	public void setC(Classes c) {
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
