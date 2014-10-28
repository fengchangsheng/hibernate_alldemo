package com.fcs.hib;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fcs.pojo.Classes;
import com.fcs.pojo.Student;

import junit.framework.TestCase;

/**
 * @author Administrator
 * set foreign_keys_checks = 0;
 * set foreign_keys_checks = 1;
 */
public class TestHib extends TestCase{
	/**
	 * 多对一add测试  OK
	 */
	public void add(){//多对一测试
		Session ss= HibernateHelp.getSession();
		Transaction ts = null;
		try {
			ts = ss.beginTransaction();
			
			Student s1 = new Student();
			s1.setName("冯长生");
			Student s2 = new Student();
			s2.setName("李飞");
			Classes c= new Classes();
			c.setName("十二班");
			s1.setC(c);
			s2.setC(c);
			ss.save(s1);
			ss.save(s2);
			ss.save(c);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}finally{
			HibernateHelp.closeSession(ss);
		}
	}
	/**
	 * 一对多add测试不通过
	 */
	public void add2(){//一对多测试
		Session ss= HibernateHelp.getSession();
		Transaction ts = null;
		try {
			ts = ss.beginTransaction();
			
			Student s1 = new Student();
			s1.setName("冯长生1");
			Student s2 = new Student();
			s2.setName("李飞1");
			Set<Student> s = new HashSet<Student>();
			s.add(s1);
			s.add(s2);
			Classes c= new Classes();
			c.setName("十一班");
			c.setS(s);
			ss.save(c);
			ss.save(s1);
			ss.save(s2);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}finally{
			HibernateHelp.closeSession(ss);
		}
	}
	
	public void findById(){
		Session ss= HibernateHelp.getSession();
		try {
			Student p = (Student)ss.load(Student.class, 1);
			System.out.println(p.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateHelp.closeSession(ss);
		}
	}
	
	public void findAll(){
		Session ss= HibernateHelp.getSession();
		try {
			Query q = ss.createQuery("from Student");
			List<Student> list = q.list();
			
			for (Student p : list) {
				System.out.println(p.getId()+" "+p.getName());
			}
			Student p = (Student)ss.load(Student.class, 1);
			System.out.println(p.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateHelp.closeSession(ss);
		}
	}
	
	public void delete(){
		Session ss= HibernateHelp.getSession();
		Transaction ts = null;
		try {
			ts = ss.beginTransaction();
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
