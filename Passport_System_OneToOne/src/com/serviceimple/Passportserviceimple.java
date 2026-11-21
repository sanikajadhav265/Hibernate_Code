package com.serviceimple;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Passport;
import com.model.Person;
import com.service.PassportService;
import com.util.Hibernateutil;

public class Passportserviceimple implements PassportService {

	SessionFactory sf = Hibernateutil.getSessionFactory();

	@Override
	public void addPerson() {
		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Person p = new Person();

		System.out.println("Enter Person Name:");
		p.setPname(sc.next());
		System.out.println("Enter Email Id:");
		p.setEmail(sc.next());
		System.out.println("Enter Address:");
		p.setAddress(sc.next());

		Passport pass = new Passport();

		System.out.println("Enter Passport No:");
		pass.setPassportNo(sc.next());
		System.out.println("Enter Country Name:");
		pass.setCountryName(sc.next());

		p.setPassport(pass);

		session.save(p);

		tx.commit();

		System.out.println("Pesron Details Added Successfully !!");

	}

	@Override
	public void addPassport() {

		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Passport pass = new Passport();
		System.out.println("Enter Passport No:");
		pass.setPassportNo(sc.next());
		System.out.println("Enter Country Name:");

		pass.setCountryName(sc.next());

		session.save(pass);

		tx.commit();

		System.out.println("Passport Details Added Successfully !!");

	}

	@Override
	public void getPerson() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter Person Id:");
		int id = sc.nextInt();

		Person p = session.get(Person.class, id);
		if (p != null) {
			System.out.println("Person Details: " + p);
		} else {
			System.out.println("Person not found!");
		}
	}

	@Override
	public void getPassportbyId() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();

		System.out.println("Enter Passport Id:");
		int id = sc.nextInt();

		Passport pass = session.get(Passport.class, id);
		if (pass != null) {
			System.out.println("Passport Details: " + pass);
		} else {
			System.out.println("Passport not found!");
		}
	}

	@Override
	public void updatePerson() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Person Id:");
		int id = sc.nextInt();

		Person p = session.get(Person.class, id);
		if (p != null) {
			System.out.println("Enter New Name:");
			p.setPname(sc.next());
			System.out.println("Enter New Email Id:");
			p.setEmail(sc.next());
			System.out.println("Enter New Address:");
			p.setAddress(sc.next());

			session.update(p);
			tx.commit();
			System.out.println("Person updated successfully!");
		} else {
			System.out.println("Person not found!");
		}

	}

	@Override
	public void updatePassportbyId() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Passport Id:");
		int id = sc.nextInt();

		Passport pass = session.get(Passport.class, id);
		if (pass != null) {
			System.out.println("Enter New PassportNo:");
			pass.setPassportNo(sc.next());
			System.out.println("Enter New Country Name:");
			pass.setCountryName(sc.next());

			session.update(pass);
			tx.commit();
			System.out.println("Passport updated successfully!");
		} else {
			System.out.println("Passport not found!");
		}

	}

	@Override
	public void deletePerson() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Person Id:");
		int id = sc.nextInt();

		Person p = session.get(Person.class, id);
		if (p != null) {
			session.delete(p);
			tx.commit();
			System.out.println("Person deleted successfully!");
		} else {
			System.out.println("Person not found!");
		}

	}

	@Override
	public void deletePassportbyId() {
		Scanner sc = new Scanner(System.in);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Passport Id:");
		int id = sc.nextInt();

		Passport pass = session.get(Passport.class, id);
		if (pass != null) {
			session.delete(pass);
			tx.commit();
			System.out.println("Passport deleted successfully!");
		} else {
			System.out.println("Passport not found!");
		}

	}

}
