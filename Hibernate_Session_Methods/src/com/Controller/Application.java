package com.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Util.HibernateUtil;
import com.model.User;

public class Application {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		insertUser(sf);
		// updateUser(sf);
		// getUser(sf);

		// deleteUser(sf);

	}

	private static void insertUser(SessionFactory sf) {
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		User user = new User();

		user.setuName("Om");
		user.setuEmail("Om45@gmail.com");
		user.setuAddress("Kolhapur");
		user.setuPincode(416567);
		session.save(user);

		tx.commit();

		System.out.println("User Data Insert ");
	}

	private static void updateUser(SessionFactory sf) {

		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();

		User u = new User();
		u.setuId(1);
		u.setuName("Om");
		u.setuEmail("OM45@gmail.com");
		u.setuAddress("Kolhapur");
		u.setuPincode(411567);

		s.update(u);
		tx.commit();
		System.out.println("User Data Updated");
	}

	private static void getUser(SessionFactory sf) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		User user = session.get(User.class, 1);
		System.out.println(user.getClass());

		//		User load=session.load(User.class,1);
		//		System.out.println(load.getClass());

		tx.commit();
		System.out.println("User Added");
	}

	private static void deleteUser(SessionFactory sf) {
		Session s = sf.openSession();

		Transaction tx = s.beginTransaction();

		User u = s.get(User.class, 3);
		s.delete(u);

		tx.commit();

		System.out.println("User Data Deleted");
	}

}
