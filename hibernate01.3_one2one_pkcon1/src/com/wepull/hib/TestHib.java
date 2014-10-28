package com.wepull.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wepull.pojo.IdCard;
import com.wepull.pojo.Person;

import junit.framework.TestCase;

/**
 * @author Administrator
 * Book---->Type Type（CRUD）
 * set foreign_keys_checks = 0;(断开FK)
 * set foreign_keys_checks = 1;(恢复FK)
 */
public class TestHib extends TestCase{
	public void add(){
		//得到session
		Session ss= HibernateHelp.getSession();
		Transaction ts = null;
		try {
			ts = ss.beginTransaction();
			IdCard i= new IdCard();
			i.setName("002");
			
			Person p = new Person();
			p.setName("胡锦涛");
			p.setI(i);
			
			ss.save(i);
			ss.save(p);
			
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
			Person p = (Person)ss.load(Person.class, 1);
			System.out.println(p.getName());
			System.out.println(p.getI().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateHelp.closeSession(ss);
		}
	}
	
	public void findAll(){
		Session ss= HibernateHelp.getSession();
		try {
			Query q = ss.createQuery("from Person");
			List<Person> list = q.list();
			
			for (Person p : list) {
				System.out.println(p.getId()+" "+p.getName());
			}
			Person p = (Person)ss.load(Person.class, 1);
			System.out.println(p.getName());
			System.out.println(p.getI().getName());
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
			ss.delete(ss.load(new Person().getI().getClass(), 1));
//			ss.delete(ss.load(new Person().getClass(), 1));//通过主键删除?
//			ss.delete(ss.load(IdCard.class, 1));//外键关联  不可删   有主键参照它
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}finally{
			HibernateHelp.closeSession(ss);
		}
	}
	
	
	
	
	
	
	

}
