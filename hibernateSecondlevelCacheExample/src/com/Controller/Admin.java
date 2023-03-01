package com.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.POJO.Student;
import com.util.hibernatUtil;

public class Admin {

	public static void main(String[] args) {

		SessionFactory sf = hibernatUtil.getConnection();

		
//
//		Student st = new Student();
//		st.setSname("nilesh");
//
//		s.save(st);
//		s.beginTransaction().commit();
//		System.out.println("Data Inserted");

		Session s = sf.openSession();
		Student stu = s.get(Student.class, 1);
		System.out.println(stu);
		
		
		System.out.println("==================");
		Session s2 = sf.openSession();
		Student stu1 = s2.get(Student.class, 1);
		System.out.println(stu1);
		
		
		
		System.out.println("==================");
		Session s3 = sf.openSession();
		Student stu3 = s3.get(Student.class, 1);
		System.out.println(stu3);
		
		
	}
}
