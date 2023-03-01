package com.exponent.Anotationbasedproj;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Session s = sf.openSession();

		List<Student> ls= ListOfStudents.listofstudents();
		for(Student stu:ls)
		{
			System.out.println(stu);
			s.save(stu);

			
		}
		s.beginTransaction().commit();
		
		

		//s.save(e);
		

		System.out.println("Data INserted");

	}

}
