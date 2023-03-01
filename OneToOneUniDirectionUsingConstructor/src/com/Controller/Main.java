package com.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import com.Model.AdharDetail;
import com.Model.person;

public class Main {

	public static SessionFactory getConnection() {
		StandardServiceRegistry registry = null;

		SessionFactory sf = null;

		if (sf == null)

		{
			Map<String, Object> map = new HashMap<String, Object>();

			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/OneToOneUniConstructor");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.HBM2DDL_AUTO, "update");
			map.put(Environment.SHOW_SQL, true);

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();

			MetadataSources msd = new MetadataSources(registry).addAnnotatedClass(person.class)
					.addAnnotatedClass(AdharDetail.class);

			Metadata md = msd.getMetadataBuilder().build();

			sf = md.getSessionFactoryBuilder().build();
		}

		return sf;
	}

	private static void addPerson() {
		SessionFactory sf = getConnection();
		Scanner sc = new Scanner(System.in);

		Session s = sf.openSession();

		System.out.println("Enter the Ahdar Details:-");
		AdharDetail ad = new AdharDetail(sc.nextInt(), sc.next(), sc.next());
		

		System.out.println("Enter the Person Details:-");
		person p = new person(sc.nextInt(), sc.next(), ad);

		s.save(p);
		s.beginTransaction().commit();

		System.out.println("added successfully");
	}

	private static void showPerson() {
		SessionFactory sf = getConnection();
		Scanner sc = new Scanner(System.in);

		Session s = sf.openSession();

		Query<person> query = s.createQuery("from person");
		List<person> plist = query.getResultList();
		for (person pl : plist) {
			System.out.println(pl);
		}

		System.out.println("added successfully");
	}
	
	private static void updatePerson() {
		SessionFactory sf = getConnection();
		Scanner sc = new Scanner(System.in);

		Session s = sf.openSession();
		
		System.out.println("Enter the person iD:-");
		int id = sc.nextInt();
		
		person p = s.get(person.class, id);
		
		
		

		System.out.println("added successfully");
	}

	public static void main(String[] args) {
//		addPerson();
		showPerson();
	}
}
