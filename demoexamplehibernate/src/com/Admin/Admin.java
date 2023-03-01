package com.Admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;

public class Admin {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionfactory();

		Session s = sf.openSession();

		s.save(s);

		s.beginTransaction().commit();

		System.out.println("Data inserted!!!");
	}

}
