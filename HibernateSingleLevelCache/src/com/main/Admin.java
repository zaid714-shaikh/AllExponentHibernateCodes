package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.University;
import com.util.HIbernateUtil;

public class Admin {

	public static void main(String[] args) {

		SessionFactory sf = HIbernateUtil.getConnection();

		Session s = sf.openSession();

//		University university = new University();
//		university.setUname("kolkatauniversity");
//
//		s.save(university);
//		s.beginTransaction().commit();
//		System.out.println("Data inserted");

		System.out.println("===============");

		
			University un = s.get(University.class, 2);
		
			System.out.println(un);

//			s.evict(un);
			University un1 = s.get(University.class, 3);
		
			System.out.println(un1);
			
			
			

	}
}
