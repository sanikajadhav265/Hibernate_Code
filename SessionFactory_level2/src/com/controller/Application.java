package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Book;
import com.util.Hibernateutil;

public class Application {
	
	public static void main(String[] args) {
		
		SessionFactory sf = Hibernateutil.getSessionFactory();
		
		Session session = sf.openSession();
		Session session1=sf.openSession();
		
		Book b1 = session.get(Book.class, 2);
		Book b2 = session1.get(Book.class, 1);
		
		session.clear();
		
		Book b3 = session1.get(Book.class, 2);
		Book b4 = session.get(Book.class, 2);
		
		sf.getCache().evictAll();
		session.evict(b1);
		session.close();
		
		Book b5 = session1.get(Book.class, 3);
		Book b6 = session1.get(Book.class, 1);
			
		
//		Transaction tx = session.beginTransaction();
//		
//		Book b=new Book();
//		b.setBname("The Odyssey");
//		b.setAuthor("Homer");
//		b.setPrice(1000.00);
//		
//		session.save(b);
//		
//		tx.commit();
//		
//		System.out.println("Book Details Saved");
	}

}
