package com.controller;

import java.util.Scanner;

import com.serviceimple.StudentServiceIMple;

public class Application {

	public static void main(String[] args) {

//		SessionFactory sf = Hibernateutil.getSessionFactory();
//		
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Student std=new Student();
//		std.setRollNo(12);
//		std.setSname("Renuka");
//		std.setMarks(90.90f);
//		
//		Subject s1=new Subject();
//		s1.setSubname("Java");
//		s1.setFaculty("Om Sir");
//		
//		Subject s2=new Subject();
//		s2.setSubname("Python");
//		s2.setFaculty("Rushant Sir");
//		
//		Subject s3=new Subject();
//		s3.setSubname("SQL");
//		s3.setFaculty("Anjali Mam");
//		
//		List<Subject> sub=new ArrayList<Subject>();
//		sub.add(s1);
//		sub.add(s2);
//		sub.add(s3);
//		
//		std.setSubject(sub);
//		
//		session.save(std);
//		
//		tx.commit();
//		
//		System.out.println("Student Data Saved");
		
		Scanner sc = new Scanner(System.in);
		StudentServiceIMple std = new StudentServiceIMple();

		boolean flag = true;

		while (flag) {

			System.out.println("****************************************");
			System.out.println("****************************************");
			System.out.println("**    1. Add Student                  **");
			System.out.println("**    2. Update Student               **");
			System.out.println("**    3. Delete Student               **");
			System.out.println("**    4. Get Passport                 **");
			System.out.println("**    5. Exit                         **");
			System.out.println("****************************************");
			System.out.println("****************************************");
			System.out.println("Enter Your Choice 1 to 5:");
			
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				std.addStudent();
				break;
			case 2:
				std.updateStudent();
				break;
			case 3:
				std.deleteStudent();
				break;
			case 4:
				
				break;
			case 5:
				flag=false;
				break;
			default:
				System.out.println("Invalid Choice...");
				
			}
		}

	}

}
