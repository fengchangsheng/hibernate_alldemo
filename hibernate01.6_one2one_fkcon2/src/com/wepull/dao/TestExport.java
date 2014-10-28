package com.wepull.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestExport {
	public static void main(String[] args) {
		//解析核心文件
		Configuration cfg = new Configuration().configure();
		
		SchemaExport sc = new SchemaExport(cfg);
		
		sc.create(true, true);
	}
}
