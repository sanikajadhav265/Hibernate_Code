package com.serviceimple;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Student;
import com.model.Subject;
import com.service.StudentSerivce;
import com.util.Hibernateutil;

public class StudentServiceIMple implements StudentSerivce {

	SessionFactory sf = Hibernateutil.getSessionFactory();

	@Override
	public void addStudent() {
		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Student std = new Student();

		System.out.println("Enter Student Roll No:");
		std.setRollNo(sc.nextInt());

		System.out.println("Enter Student Name:");
		std.setSname(sc.next());

		System.out.println("Enter Marks:");
		std.setMarks(sc.nextFloat());

		Subject subs = new Subject();
		System.out.println("Enter Subject Name:");
		subs.setSubname(sc.next());

		System.out.println("Enter Faculty Name:");
		subs.setFaculty(sc.next());

		List<Subject> subList = new ArrayList<>();
		subList.add(subs);

		std.setSubject(subList);

		session.save(std);
		tx.commit();
		System.out.println("Student Details Added");
	}

	@Override
	public void updateStudent() {
		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Student Id:");
		int sid = sc.nextInt();

		Student std = session.get(Student.class, sid);

		if (std != null) {
			System.out.println("Enter New Student Name:");
			std.setSname(sc.next());
			session.update(std);
			tx.commit();
			System.out.println("Student Details Updated Successfully!");
		} else {
			System.out.println("Student with ID " + sid + " not found!");
			tx.rollback();
		}

	}

	@Override
	public void deleteStudent() {
		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		System.out.println("Enter Student Id:");
		int sid = sc.nextInt();

		Student std = session.get(Student.class, sid);

		if (std != null) {
			session.delete(std);
			tx.commit();
			System.out.println("Student and Subjects Deleted Successfully!");
		} else {
			System.out.println("Student with Id " + sid + " not found!");
			tx.rollback();
		}
	}
}
