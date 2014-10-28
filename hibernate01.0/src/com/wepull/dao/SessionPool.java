package com.wepull.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionPool {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSF(){
		if(sessionFactory==null){
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	public static void main(String[] args) {
		System.out.println(getSession());
	}
}