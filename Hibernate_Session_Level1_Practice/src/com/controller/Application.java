package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Product;
import com.util.Hibernateutil;

public class Application {
	
       public static void main(String[] args) {
    	   
		 SessionFactory sf = Hibernateutil.getSessionFactory();
		 
		 Session session = sf.openSession();
		 Session session1= sf.openSession();
		 Session session2=sf.openSession();
		 
		  Transaction tx = session.beginTransaction();
		  
//		  Product p = new Product();
//		  p.setPname("Fries");
//		  p.setQuantity(8);
//		  p.setAddress("Nigdi");
//		  p.setPinCode("411 114");
//		  
//		  session.save(p);
		  
		  Product p1 = session.get(Product.class, 3);//1
		  Product p2 =session1.get(Product.class, 3);//2
		  Product p6 = session2.get(Product.class, 4);
		  session.evict(p2);
		  session2.evict(p6);
		  Product p3 =session1.get(Product.class, 2);//3
		  Product p5 =session1.get(Product.class, 3);
		  session.evict(p3);
		  session.clear();
		  Product p7 = session2.get(Product.class, 4);
		  Product p4 =session.get(Product.class, 2);//4
		  
		  
		  tx.commit();
		  
	//	 System.out.println("Product Details Saved"); 
	}

}


