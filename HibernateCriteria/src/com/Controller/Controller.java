package com.Controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.POJO.employee;
import com.Util.HibernateUtil;

public class Controller {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getConnection();

		Session s = sf.openSession();

//		employee e = new employee();
//		
//		e.setEname("pawana");
//		e.setEaddress("pune");
//		e.setEsalary(50000.0);
//		
//		
//		s.save(e);
//		s.beginTransaction().commit();

		Criteria c = s.createCriteria(employee.class);
		List<employee> emp = c.list();
		System.out.println(emp);

		c.add(Restrictions.gt("esalary", 55000.0));
		List<employee> emp1 = c.list();
		System.out.println(emp1);

		c.add(Restrictions.ilike("ename", "%an"));
		List<employee> emp2 = c.list();
		System.out.println(emp2);
	}

}
