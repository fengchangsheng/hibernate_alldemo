package com.wepull.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wepull.pojo.UserPo;

public class UserDAO {
	private Session sess;//持久化灵魂 线程不安全
	
	public UserDAO(Session sess) {
		super();
		this.sess = sess;
	}
	//添加删除更新必须开启事物
	public void add(UserPo up){
		Transaction tx = sess.beginTransaction();
		sess.save(up);
		tx.commit();
	}
	
	public void update(UserPo up){
		Transaction tx = sess.beginTransaction();
		sess.update(up);
		tx.commit();
	}
	
	public UserPo get(String userId){
		return (UserPo)sess.get(UserPo.class, userId);
	}
	
	public List<UserPo> findAll(){
		//只能查对象和属性
		Query qr = sess.createQuery("from UserPo up");
		return qr.list();
	}
	
	public List<UserPo> findAll(int offset,int pagesize){
		//只能查对象和属性
		//分页  从哪条开始   到哪条结束
		return sess.createQuery("from UserPo up").setFirstResult(offset).setMaxResults(pagesize).list();
	}
	
	
	public void delete(String userId){
		Transaction tx = sess.beginTransaction();
		sess.delete(get(userId));
		tx.commit();
	}
	public static void main(String[] args) {
		Session sess = HibernateSessionFactory.getSession();
		UserDAO dao = new UserDAO(sess);
		UserPo up = new UserPo("add","234");
//		up.setUserId("402881b247f694060147f69408470001");
//		up.setUsername("xtf");
//		dao.update(up);
//		dao.add(up);
		//dao.delete("402881b247f691b00147f691b2120001");
		List<UserPo> list = dao.findAll(0, 3);
		for (UserPo user : list) {
			System.out.println(user.getUserId());
			System.out.println(user.getUsername()+" "+user.getPassword());
		}
		
		HibernateSessionFactory.closeSession();
	}
}
