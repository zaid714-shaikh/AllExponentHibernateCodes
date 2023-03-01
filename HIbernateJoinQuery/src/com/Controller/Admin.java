package com.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.POJO.Company;
import com.POJO.Employee;
import com.POJO.projects;
import com.Util.HibernateUtil;

public class Admin {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getConnection();

		Session s = sf.openSession();
//
//		projects p = new projects();
//		p.setProjectname("Japanproject");
//		p.setProjectprice(850000.0);
//
//		Company c = new Company();
//		c.setCname("Delloite");
//		c.setProject(p);
//
//		Employee e = new Employee();
//		e.setEname("roy");
//		e.setCompany(c);
//
//		s.save(e);
//		s.beginTransaction().commit();
//		System.out.println("Success!!");

		String sql = "select e.ename,c.cname,p.projectname,p.projectprice from Employee e inner join Company c on e.eid=c.cid inner join projects p on p.pid = c.cid where eid =:e1";

		Query<Object[]> query = s.createQuery(sql);

		query.setParameter("e1", 2);

		List<Object[]> obj = query.getResultList();

		for (Object[] objects : obj) {
			System.out.println(objects[0] + " " + objects[1] + " " + objects[2] + " " + objects[3]);
		}

	}
}
