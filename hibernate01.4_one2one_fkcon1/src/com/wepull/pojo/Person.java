package com.wepull.pojo;
/**
 * @author Administrator
 * һ��һΨһ�������    ����person-->IdCard
 */
public class Person {
	private int id;
	private String name;
	
	//���ж���
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
