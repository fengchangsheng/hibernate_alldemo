package com.fcs.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//��װ������7������
public class HibernateHelp {
	private static Configuration cfg = new Configuration().configure();
	private static SessionFactory sf= cfg.buildSessionFactory();
	
	//����session
	public static Session getSession(){
		return sf.openSession();
	}
	
	//�ر�session(���������̬)
	public static void closeSession(Session session){
		if(session.isOpen() || session!=null){
			session.close();
		}
	}
}
