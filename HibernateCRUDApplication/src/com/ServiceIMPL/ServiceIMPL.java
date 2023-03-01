package com.ServiceIMPL;

import java.util.List;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.POJO.Collage;
import com.Service.Service;
import com.util.hibernateUtil;

public class ServiceIMPL implements Service {

	SessionFactory sf = hibernateUtil.getConnection();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCollage() {

		Session s = sf.openSession();
		Collage c = new Collage();
		System.out.println("Enter the collage name :- ");
		String cname = sc.next();
		c.setCname(cname);

		s.save(c);

		s.beginTransaction().commit();
		System.out.println("Data Inserted!!!");

	}

	@Override
	public void displaycollage() {

		Session s = sf.openSession();
		Query<Collage> query = s.createQuery("from Collage");

		List<Collage> lc = query.getResultList();

		for (Collage collage : lc) {
			System.out.println(collage);
		}

	}

	@Override
	public void displaySpecificCollage() {

		Session s = sf.openSession();

		System.out.println("Enter the Collage ID :- ");
		int id = sc.nextInt();
		Collage c = s.get(Collage.class, id);
		if (c != null) {

			System.out.println(c);
			System.out.println("Data Fetch Successfuly!!");
		} else {
			System.out.println("Id Not Exist");
		}

	}

	@Override
	public void updateCollage() {

		Session s = sf.openSession();

		System.out.println("Enter the Collage ID :- ");
		int id = sc.nextInt();
		Collage c = s.get(Collage.class, id);
		if (c != null) {
			System.out.println("Enter the collage name :- ");
			String cname = sc.next();
			c.setCname(cname);

			s.update(c);
			s.beginTransaction().commit();

		} else {
			System.out.println("Id Not Exist");
		}

	}

	@Override
	public void deleteCollage() {
		Session s = sf.openSession();
		System.out.println("Enter the Collage ID :- ");
		int id = sc.nextInt();
		Collage c = s.get(Collage.class, id);
		if (c != null) {

			s.delete(c);
			s.beginTransaction().commit();

		} else {
			System.out.println("Id Not Exist");
		}

	}

}
