package com.exponent.hibernateproj.POJO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Student student = new Student();

		student.setSid(1);
		student.setSname("zaid");

		session.save(student);

		session.beginTransaction().commit();

		System.out.println("Data Inserted");

	}
}
