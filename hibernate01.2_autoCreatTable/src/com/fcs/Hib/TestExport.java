package com.fcs.Hib;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author wolves
 */
public class TestExport {
     public  static  void main(String  args[]){
    	 Configuration cf=new Configuration().configure();
    	 SchemaExport export=new SchemaExport(cf);
    	 export.create(true, true);
    	 
     }
}
