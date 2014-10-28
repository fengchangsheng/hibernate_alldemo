package com.wepull.pojo;
/**
 * @author Administrator
 * 一对一唯一主键关联单双向
 */
public class IdCard {
	private int id;
	private String name;
	
	private Person p;
	
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
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
