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

//		employee e = new employee();
//		e.setEname("pawan");
//		e.setAddress("pune");
//		e.setSalary(30000.0);
//
//		s.save(e);
//		s.beginTransaction().commit();
//		System.out.println("Data Inserted");

		Query<employee> query = s.createQuery("from employee");
		List<employee> lep = query.getResultList();
		System.out.println(lep);

		System.out.println("------------------------------------------------------");

		// select name,salary from employee where id=?

		Query<Object[]> query1 = s.createQuery("select ename,salary from employee where eid=:i");

		query1.setParameter("i", 1);

		Object[] obj = query1.getSingleResult();

		System.out.println(obj[0] + " " + obj[1]);

		System.out.println("-----------------------------------------------------------");

		// update employee set ename = ? where eid = ?

		Query<employee> query2 = s.createQuery("update employee set ename =:name where eid =:i");

		s.beginTransaction();
		query2.setParameter("name", "prakash");
		query2.setParameter("i", 1);

		int i = query2.executeUpdate();
		System.out.println("updated Rowws:-" + i);
		System.out.println("-----------------------------------------------------------");

		// select count(*) from employee;

		Query<Long> query3 = s.createQuery("select count(*) from employee");
		Long cnt = query3.getSingleResult();

		System.out.println("total count is :-" + cnt);
		System.out.println("-----------------------------------------------------------");

		// pagination

		query = s.createQuery("from employee");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<employee> emp = query.getResultList();
		System.out.println(emp);
		System.out.println("-----------------------------------------------------------");
		// select max(salary) from employee;

		Query<Double> query4 = s.createQuery("select max(salary) from employee");
		Double max = query4.getSingleResult();
		System.out.println("Maximum salary := " + max);
		
		//alter employee set address = eaddress;
		
		
		

	}
}
