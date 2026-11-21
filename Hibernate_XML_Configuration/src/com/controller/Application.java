package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Employee;

public class Application {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration().configure("hibernate1.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session s=sf.openSession();
		
		Transaction tx=s.beginTransaction();
		
		Employee emp=new Employee();
		emp.setEname("Renuka");
		emp.setDept("IT");
		emp.setSalary(88000);
		s.save(emp);
		
		tx.commit();
		
		System.out.println("Employee Data Saved !!");
	}

}
