package com.fcs.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
	private static Configuration cf = new AnnotationConfiguration().configure();
	private static SessionFactory sf = cf.buildSessionFactory();
	
	public static Session getSession(){
		return sf.openSession();
	}
	
	public static void closeSession(Session sess){
		if(sess.isOpen()||sess!=null){
			sess.close();
		}
	}
}
