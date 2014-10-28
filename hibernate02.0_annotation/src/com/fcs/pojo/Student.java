package com.fcs.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * @author fcs
 * 不能自动删除表
 * 多对一单向     多方持有一方的外键
 * 2014-8-24
 */

@Entity
public class Student {
	private int id;
	private String name;
	private Classes c;
	
	@ManyToOne(fetch=FetchType.LAZY)//延迟加载
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
	
}
