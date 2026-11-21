package com.serviceimple;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Adhar;
import com.model.Person;
import com.service.PassportService;
import com.util.Hibernateutil;

public class PassportServiceImple implements PassportService {
	SessionFactory sf = Hibernateutil.getSessionFactory();

	@Override
	public void addperson() {
		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Person p = new Person();
		System.out.println("Enter person name:");
		p.setPname(sc.next());

		System.out.println("Enter Emial Id:");
		p.setEmail(sc.next());

		System.out.println("Enter Mob No:");
		p.setMobNo(sc.next());

		System.out.println("Enter City:");
		p.setCity(sc.next());

		Adhar a = new Adhar();
		System.out.println("Enter Adhar No:");
		a.setaNo(sc.next());

		p.setAdhar(a);

		session.save(p);

		tx.commit();

		System.out.println("Person Added Successfully !!");

	}

	@Override
	public void getPersonOnlyUsingPid() {
		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Person id:");
		int pid = sc.nextInt();

		Person p = session.get(Person.class, pid);
		if (p != null) {
			System.out.println("Person Details: " + p);
		} else {
			System.out.println("Person not found!");
		}
	}

	@Override
	public void getAdharOnlyUsingPid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter Person Id:");
		int pid = sc.nextInt();

		Person p = session.get(Person.class, pid);

		if (p != null) {
			Adhar a = p.getAdhar();

			if (a != null) {
				System.out.println(a.getAid());
				System.out.println(a.getaNo());
			}
		} else {
			System.out.println("Person not found");
		}

	}

	@Override
	public void updatePersonDetailsUsingPid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Person Id:");
		int pid = sc.nextInt();

		Person p = session.get(Person.class, pid);

		if (p != null) {
			System.out.println("Enter New Name:");
			p.setPname(sc.next());

			System.out.println("Enter New Email:");
			p.setEmail(sc.next());

			System.out.println("Enter New Mob No:");
			p.setMobNo(sc.next());

			System.out.println("Enter New City:");
			p.setCity(sc.next());

			session.update(p);
			tx.commit();

			System.out.println("Person Updated Successfully");
		} else {
			tx.rollback();
			System.out.println("Person not found");
		}

	}

	@Override
	public void updateAdharDetailsUsingPid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Person Id:");
		int pid = sc.nextInt();

		Person p = session.get(Person.class, pid);

		if (p != null && p.getAdhar() != null) {
			Adhar a = p.getAdhar();

			System.out.println("Enter New Adhar No:");
			a.setaNo(sc.next());

			session.update(a);
			tx.commit();

			System.out.println("Adhar Updated Successfully");
		} else {
			tx.rollback();
			System.out.println("Person or Adhar not found");
		}

	}

	@Override
	public void deletePersonOnlyUsingPid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Person Id:");
		int pid = sc.nextInt();

		Person p = session.get(Person.class, pid);

		if (p != null) {
			session.delete(p);
			tx.commit();

			System.out.println("Person Deleted Successfully");
		} else {
			tx.rollback();
			System.out.println("Person not found");
		}

	}

	@Override
	public void deleteAdharOnlyUsingPid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Person Id:");
		int pid = sc.nextInt();

		Person p = session.get(Person.class, pid);

		if (p != null && p.getAdhar() != null) {
			Adhar a = p.getAdhar();

			p.setAdhar(null);
			session.update(p);
			session.delete(a);

			tx.commit();

			System.out.println("Adhar Deleted Successfully");
		} else {
			tx.rollback();
			System.out.println("Person or Adhar not found");
		}

	}

	@Override
	public void getPersonOnlyUsingAid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter Adhar Id:");
		int aid = sc.nextInt();

		Adhar a = session.get(Adhar.class, aid);

		if (a != null) {
			Person p = a.getPerson();

			if (p != null) {
				System.out.println(p.getPid());
				System.out.println(p.getPname());
				System.out.println(p.getEmail());
				System.out.println(p.getMobNo());
				System.out.println(p.getCity());
			}
		} else {
			System.out.println("Adhar not found");
		}

	}

	@Override
	public void getAdharOnlyUsingAid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter Adhar Id:");
		int aid = sc.nextInt();

		Adhar a = session.get(Adhar.class, aid);

		if (a != null) {
			System.out.println(a.getAid());
			System.out.println(a.getaNo());
		} else {
			System.out.println("Adhar not found");
		}
	}

	@Override
	public void updatePersonDetailsUsingAid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Adhar Id:");
		int aid = sc.nextInt();

		Adhar a = session.get(Adhar.class, aid);

		if (a != null && a.getPerson() != null) {
			Person p = a.getPerson();

			System.out.println("Enter New Name:");
			p.setPname(sc.next());

			System.out.println("Enter New Email:");
			p.setEmail(sc.next());

			System.out.println("Enter New Mob No:");
			p.setMobNo(sc.next());

			System.out.println("Enter New City:");
			p.setCity(sc.next());

			session.update(p);
			tx.commit();

			System.out.println("Person Updated Successfully");
		} else {
			tx.rollback();
			System.out.println("Adhar or Person not found");
		}

	}

	@Override
	public void updateAdharDetailsUsingAid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Adhar Id:");
		int aid = sc.nextInt();

		Adhar a = session.get(Adhar.class, aid);

		if (a != null) {
			System.out.println("Enter New Adhar No:");
			a.setaNo(sc.next());

			session.update(a);
			tx.commit();

			System.out.println("Adhar Updated Successfully");
		} else {
			tx.rollback();
			System.out.println("Adhar not found");
		}

	}

	@Override
	public void deletePersonOnlyUsingAid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Adhar Id:");
		int aid = sc.nextInt();

		Adhar a = session.get(Adhar.class, aid);

		if (a != null && a.getPerson() != null) {
			Person p = a.getPerson();

			session.delete(p);
			tx.commit();

			System.out.println("Person Deleted Successfully");
		} else {
			tx.rollback();
			System.out.println("Person or Adhar not found");
		}

	}

	@Override
	public void deleteAdharOnlyUsingAid() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Adhar Id:");
		int aid = sc.nextInt();

		Adhar a = session.get(Adhar.class, aid);

		if (a != null) {
			Person p = a.getPerson();

			if (p != null) {
				p.setAdhar(null);
				session.update(p);
			}

			session.delete(a);
			tx.commit();

			System.out.println("Adhar Deleted Successfully");
		} else {
			tx.rollback();
			System.out.println("Adhar not found");
		}

	}

}
