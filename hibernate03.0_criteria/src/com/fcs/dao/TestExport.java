package com.fcs.dao;


import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
/**
 * @author fcs
 * Annotation注解 创建表
 * 2014-8-24
 */
public class TestExport {
     public  static  void main(String  args[]){
    	 Configuration cf=new AnnotationConfiguration().configure();
    	 SchemaExport export=new SchemaExport(cf);
    	 export.create(true, true);
    	 
     }
}
