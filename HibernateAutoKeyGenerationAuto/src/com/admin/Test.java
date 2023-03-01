package com.admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Customer;
import com.entity.OrderData;
import com.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		Customer customer = new Customer();
		
		customer.setCname("Abcd");
		customer.setCaddress("Pune");
		
		OrderData orderData = new OrderData();
		orderData.setOname("Watch");
		orderData.setOmode("Cash");
		
		
		session.save(orderData);
		session.save(customer);
		
		session.beginTransaction().commit();
		
		System.out.println("Data Stored");
	}
}
