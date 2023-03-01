package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class test {

	public static void main(String[] args) {

		SessionFactory sf = hibernateUtil.getSessionfactory();

		Session s = sf.openSession();

		department d = new department();
	
		d.setDname("history");
		
		

		s.save(d);

		s.beginTransaction().commit();

		System.out.println("Data inserted!!!");
	}
}
