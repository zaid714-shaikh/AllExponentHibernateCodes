package com.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.employee;
import com.Util.hibenateUtil;

public class Admin {

	public static void main(String[] args) {

		SessionFactory sf = hibenateUtil.getConnection();

		Session s = sf.openSession();

		employee e = new employee();

//		e.setEname("zuber");
//		e.setAddress("pune");
//		e.setSalary(500000.0);
//
//		s.save(e);
//		s.beginTransaction().commit();
//		System.out.println("Data Inserted");

		// select * from employee

		Query<employee> query = s.createNamedQuery("empq");
		List<employee> elist = query.getResultList();
		System.out.println(elist);
		System.out.println("-----------------------------------------------------------");
		// select ename,address from employee

		Query<Object[]> query1 = s.createNamedQuery("eemppartial");
		List<Object[]> obj = query1.getResultList();

		for (Object[] ob : obj)
			System.out.println(ob[0] + " " + ob[1]);

		//
	}
}
