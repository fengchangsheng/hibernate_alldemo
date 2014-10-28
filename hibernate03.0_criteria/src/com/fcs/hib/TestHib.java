package com.fcs.hib;

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
	/**
	 * 条件查询   将条件封装到一个对象中
	 * 
	 * 示例查询  根据已有对象  查找属性与之相符的其他对象
	 */
	public void findBys(){
		Session session = HibernateHelper.getSession();
		Criteria cri = session.createCriteria(Student.class);
		cri.add(Expression.eq("name", "屌丝1号"));
		cri.add(Expression.eq("age", 21));
		Student s = (Student) cri.uniqueResult();
		System.out.println(s.getAddress());
	}
	
	/**
	 * 复合查询(多条件组合查询)
	 */
	public void findMore(){
		Session session = HibernateHelper.getSession();
		Criteria cri = session.createCriteria(Classes.class);
		cri.add(Expression.eq("name", "光棍班"));
		List list = cri.list();
		for(int i=0;i<list.size();i++){
			Classes c = (Classes)list.get(i);
			System.out.println(c.getName());
			
		}
	}
	
}
