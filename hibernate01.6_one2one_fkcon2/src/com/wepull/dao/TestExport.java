package com.wepull.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestExport {
	public static void main(String[] args) {
		//���������ļ�
		Configuration cfg = new Configuration().configure();
		
		SchemaExport sc = new SchemaExport(cfg);
		
		sc.create(true, true);
	}
}
