package com;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {

	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Product product = new Product();
		product.setPid(124);
		product.setPname("Mobile");
		product.setPtype("elec.");
		product.setPrice(25000);
		
		session.save(product);
		
		tx.commit();
		
		System.out.println("Data Inserted...!");
		
	}
}
