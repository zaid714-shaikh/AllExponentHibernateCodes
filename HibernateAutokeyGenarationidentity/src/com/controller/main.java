package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pojo.car;
import com.pojo.cardriver;
import com.util.hibernateutil;

public class main {

	public static void main(String[] args) {

		SessionFactory sf = hibernateutil.getConnection();

		Session s = sf.openSession();

		car c = new car();
		c.setCname("nexon");

		cardriver cd = new cardriver();
		cd.setCdname("pawan");
		
		
		s.save(c);
		s.save(cd);
		
		s.beginTransaction().commit();
		System.out.println("Data inserted!!!");
	}
}
