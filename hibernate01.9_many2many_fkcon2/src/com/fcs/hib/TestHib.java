package com.fcs.hib;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fcs.pojo.Role;
import com.fcs.pojo.User;

import junit.framework.TestCase;

/**
 * @author Administrator
 * set foreign_keys_checks = 0;
 * set foreign_keys_checks = 1;
 */
public class TestHib extends TestCase{
	/**
	 * 多对多添加    测试  OK
	 */
	public void add(){//多对一测试
		Session ss= HibernateHelp.getSession();
		Transaction ts = null;
		try {
			ts = ss.beginTransaction();
			
			User u1 = new User();
			u1.setName("冯长生");
			User u2 = new User();
			u2.setName("李飞");
			Role r1= new Role();
			r1.setName("大学生");
			Role r2= new Role();
			r2.setName("成年人");
			Set<Role> r = new HashSet<Role>();
			r.add(r1);
			r.add(r2);
			u1.setR(r);
			u2.setR(r);
			ss.save(u1);
			ss.save(u2);
			ss.save(r1);
			ss.save(r2);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}finally{
			HibernateHelp.closeSession(ss);
		}
	}
	/**
	 * 多对多delete测试  OK
	 */
	
	public void delete(){
		Session ss= HibernateHelp.getSession();
		Transaction ts = null;
		try {
			ts = ss.beginTransaction();
			ss.delete(ss.load(User.class, 1));
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}finally{
			HibernateHelp.closeSession(ss);
		}
	}
	
//	
//	public static void main(String[] args) {
//		TestHib th = new TestHib();
//		th.add();
//	}
//	
	
	
	

}
