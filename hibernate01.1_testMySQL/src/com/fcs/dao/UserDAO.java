package com.fcs.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fcs.pojo.UserPo;

public class UserDAO {
	private Session sess;
	
	public UserDAO(Session sess) {
		super();
		this.sess = sess;
	}

	public Session getSess() {
		return sess;
	}

	public void setSess(Session sess) {
		this.sess = sess;
	}
	
	public void add(UserPo up){
		Transaction tc = sess.beginTransaction();
		sess.save(up);
		tc.commit();
	}
	
	public static void main(String[] args) {
		Session sess = HibernateSessionFactory.getSession();
		UserDAO dao = new UserDAO(sess);
		UserPo up = new UserPo("lyt","234");
		dao.add(up);
	}
}
