package com.Service;

import java.util.Iterator;
import java.util.List;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.POJO.adhardetail;
import com.POJO.person;
import com.util.hibernateUtil;

public class ServiceIMPL implements service {

	SessionFactory sf = hibernateUtil.getConnection();

	@Override
	public void addperson() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		person p = new person();

		System.out.println("Enter the person name:-");
		p.setPname(sc.next());
		System.out.println("Enter the person adhar number");

		adhardetail ad = new adhardetail();
		ad.setAdharnulmber(sc.nextLong());

		p.setAdhard(ad);

		s.save(p);
		s.beginTransaction().commit();
		System.out.println("data inserted!!!");

	}

	@Override
	public void displayperson() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		Query<person> query = s.createQuery("from person");
		List<person> personlist = query.getResultList();

		for(person p :personlist)
		{
			System.out.println(p);
		}

	}

	@Override
	public void displayspecificperson() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the Person Id :-");
		int id = sc.nextInt();

		person p = s.get(person.class, id);
		if (p != null) {
			System.out.println("-------------");
			System.out.println("person name:- " + p.getPname());
			System.out.println("person adhar number:- " + p.getAdhard().getAdharnulmber());
			System.out.println("----------------");
		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updateperson() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		person p1 = new person();
		System.out.println("Enter the Person Id :-");
		int id = sc.nextInt();
		person p = s.get(person.class, id);
		if (p != null) {

			System.out.println("Enter the person name:-");
			p.setPname(sc.next());
			s.update(p);
			s.beginTransaction().commit();
			System.out.println("sucessfullu updated!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deleteperson() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		person p1 = new person();
		System.out.println("Enter the Person Id :-");
		int id = sc.nextInt();
		person p = s.get(person.class, id);
		if (p != null) {

			s.delete(p);
			s.beginTransaction().commit();
			System.out.println("sucessfullu deleted!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void updartpersonadhar() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		person p1 = new person();
		System.out.println("Enter the Person Id for updating adhar number:-");
		int id = sc.nextInt();
		person p = s.get(person.class, id);
		if (p != null) {

			System.out.println("Enter adhar number:-");

			p.getAdhard().setAdharnulmber(sc.nextLong());

			s.update(p);
			s.beginTransaction().commit();
			System.out.println("sucessfullu updated!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

	@Override
	public void deletepersonadhar() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		System.out.println("Enter the Person Id for delete adhar number:-");
		int id = sc.nextInt();

		person p = s.get(person.class, id);

		if (p != null) {
			 adhardetail adhardetail = p.getAdhard();
              p.setAdhard(null);
              s.update(p);
			s.delete(adhardetail);
			s.beginTransaction().commit();
			System.out.println("sucessfullu deleted!");

		} else {
			System.out.println("Invalid id!!!");
		}

	}

}
