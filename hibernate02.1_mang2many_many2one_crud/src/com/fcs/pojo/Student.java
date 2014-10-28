package com.fcs.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author fcs
 * Criteria query
 * 2014-8-24
 */

@Entity
@Table(name="t_student")
public class Student {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String address;
	
	private Classes c;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)//延迟加载
	@JoinColumn(name="cid")//修改表字段名  防止自动生成sid
	public Classes getC() {
		return c;
	}
	public void setC(Classes c) {
		this.c = c;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//主键自增长
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
