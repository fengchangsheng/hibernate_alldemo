//package com.wepull.dao;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class HibernateUtil {  
//
//	/**
//	 * @param args
//	 */
//	
//	private static Log log = LogFactory.getLog(HibernateUtil.class);
//
//	private static final SessionFactory sessionFactory;
//	static {
//		try {
//			// Create the SessionFactory
//			sessionFactory = new Configuration().configure()
//					.buildSessionFactory();
//		} catch (Throwable ex) {
//			log.error("Initial SessionFactory creation failed.", ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//	}
//
//	public static final ThreadLocal threadLocal = new ThreadLocal();
//
//	public static Session currentSession() {
//		Session s = (Session) threadLocal.get();
//		// Open a new Session, if this Thread has none yet
//		if (s == null) {
//			s = sessionFactory.openSession();
//			threadLocal.set(s);
//		}
//		return s;
//	}
//
//	public static void closeSession() {
//		Session s = (Session) threadLocal.get();
//		if (s != null)
//			s.close();
//		threadLocal.set(null);
//	}
//}
