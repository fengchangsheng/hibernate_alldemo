package com.fcs.hib;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fcs.pojo.Classes;
import com.fcs.pojo.Student;

import junit.framework.TestCase;

public class TestHib extends TestCase{
	public void add(){
		Session session = HibernateHelper.getSession();
		Transaction tc = null;
		try {
			tc = session.beginTransaction();
			Classes c = new Classes();
			c.setName("屌丝班");
			Student s1 = new Student();
			s1.setName("屌丝1号");
			Student s2 = new Student();
			s2.setName("屌丝2号");
			s1.setC(c);
			s2.setC(c);
			session.save(c);
			session.save(s1);
			session.save(s2);
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tc.rollback();
		} finally{
			HibernateHelper.closeSession(session);
		}
	}
	
	public void delete(){
		Session session = HibernateHelper.getSession();
		Transaction tc = null;
		try {
			tc = session.beginTransaction();
			session.delete(session.load(Student.class, 2));
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tc.rollback();
		} finally{
			HibernateHelper.closeSession(session);
		}
	}
	
}
