package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Adhar;
import com.model.Person;

public class Hibernateutil {
	
	private static SessionFactory sf;

	public static SessionFactory getSessionFactory() {

		Configuration cfg = new Configuration();

		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernateutil");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "root");

		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		cfg.setProperty("hibernate.show_sql", "true");
	
		cfg.addAnnotatedClass(Person.class).addAnnotatedClass(Adhar.class);

		sf = cfg.buildSessionFactory();

		return sf;

	}

}
