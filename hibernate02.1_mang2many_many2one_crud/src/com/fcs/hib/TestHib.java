package com.fcs.hib;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.fcs.pojo.Classes;
import com.fcs.pojo.Student;

import junit.framework.TestCase;

public class TestHib extends TestCase{
	/**
	 * 通过Student保存Classes
	 */
	public void add(){
		Session session = HibernateHelper.getSession();
		Transaction tc = null;
		try {
			tc = session.beginTransaction();
			Classes c = new Classes();
			c.setName("光棍班");
			Student s1 = new Student();
			s1.setName("风清扬");
			s1.setSex("男");
			s1.setAge(21);
			s1.setAddress("武汉市青山区");
			Student s2 = new Student();
			s2.setName("刘晓涛");
			s2.setSex("女");
			s2.setAge(20);
			s2.setAddress("武汉市街道口");
			s1.setC(c);
			s2.setC(c);
//			session.save(c);
			//没有这句会报错:object references an unsaved transient instance
			//不手动按顺序挨个保存  就要在合适的地方设置级联
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
	/**
	 * 通过Classes保存Student
	 */
	public void add2(){
		Session session = HibernateHelper.getSession();
		Transaction tc = null;
		try {
			tc = session.beginTransaction();
			Classes c = new Classes();
			c.setName("菜鸟班");
			Student s1 = new Student();
			s1.setName("猥琐男");
			s1.setSex("男");
			s1.setAge(21);
			s1.setAddress("武汉市东西湖区");
			Student s2 = new Student();
			s2.setName("刘晓涛");
			s2.setSex("女");
			s2.setAge(20);
			s2.setAddress("武汉市光谷广场");
			Set<Student> s = new HashSet<Student>();
			s.add(s1);
			s.add(s2);
			c.setS(s);
			s1.setC(c);//必须加上
			s2.setC(c);//必须加上
			session.save(c);
			/**
			 * 这时候从一的一端去保存多的一端
			 * 多的一端也要持有一的一端的引用 
			 * 相比操作多来级联保存一复杂点
			 */
//			session.save(s1);
//			session.save(s2);
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
