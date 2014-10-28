package com.wepull.pojo;

import java.io.Serializable;

/**
 * @author Administrator
 * 一对一唯一主键关联    单向
 */
public class Person {
	private int id;
	private String name;
	
	//持有对象
	private IdCard i;//error:private int cid;
	
	public IdCard getI() {
		return i;
	}
	public void setI(IdCard i) {
		this.i = i;
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
