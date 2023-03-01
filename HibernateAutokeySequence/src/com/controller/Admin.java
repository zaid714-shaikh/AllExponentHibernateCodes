package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojo.Student;
import com.util.hibernateUtil;

public class Admin {

	public static void main(String[] args) {

		SessionFactory sf = hibernateUtil.getConnection();

		Session s = sf.openSession();

		Student s1 = new Student();

		s1.setSname("pranay");

		s.save(s1);

		s.beginTransaction().commit();
		System.out.println("Data inserted ");
	}
}
