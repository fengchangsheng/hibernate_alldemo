package com.wepull.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//封装解析的7个步骤
public class HibernateHelp {
	private static Configuration cfg = new Configuration().configure();
	private static SessionFactory sf= cfg.buildSessionFactory();
	
	//开启session
	public static Session getSession(){
		return sf.openSession();
	}
	
	//关闭session(对象变游离态)
	public static void closeSession(Session session){
		if(session.isOpen() || session!=null){
			session.close();
		}
	}
}
