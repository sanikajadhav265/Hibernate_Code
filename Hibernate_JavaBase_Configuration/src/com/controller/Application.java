package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Employee;
import com.util.Hibernateutil;

public class Application {
	
	public static void main(String[] args) {

		SessionFactory sf=Hibernateutil.getSessionFactory();

		Session s=sf.openSession();

		Transaction tx=s.beginTransaction();

		Employee emp=new Employee();
		emp.setEname("Sanika");
		emp.setDept("IT");
		emp.setSalary(90000);

		s.save(emp);

		tx.commit();

		System.out.println("Employee Details Saved Successfully !!");	
	}


}
