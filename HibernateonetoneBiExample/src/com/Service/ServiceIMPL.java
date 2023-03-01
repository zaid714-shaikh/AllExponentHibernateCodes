package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.POJO.Login;
import com.POJO.UserData;
import com.Util.HibernateUtil;
import com.mysql.jdbc.log.Log;

public class ServiceIMPL implements Service {

	SessionFactory sf = HibernateUtil.getConnection();

	@Override
	public void addUserDataWithLoginData() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		UserData u = new UserData();
		Login l = new Login();
		System.out.println("Enter the user name :-");
		u.setUsername(sc.next());

		System.out.println("Enter the Login Email :- ");
		l.setEmail(sc.next());

		System.out.println("Enter the Login Password :- ");
		l.setPassword(sc.nextLong());

		u.setLogin(l);
		l.setUserdata(u);

		s.save(u);
		s.save(l);

		s.beginTransaction().commit();
		System.out.println("Data inserted !!!!");
	}

	@Override
	public void displayAllDataUsingUserData() {

		Session s = sf.openSession();

		System.out.println("===============All data using UserData=============");

		Query<UserData> query = s.createQuery("from UserData");
		List<UserData> ld = query.getResultList();

		for (UserData ul : ld) {
			System.out.println(ul.getId());
			System.out.println(ul.getUsername());
			System.out.println(ul.getLogin().getEmail());
			System.out.println(ul.getLogin().getPassword());
		}

		System.out.println("==============================================");

	}

	@Override
	public void displaySingleDataUsingUserId() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the User-ID :- ");
		int id = sc.nextInt();

		UserData u = s.get(UserData.class, id);

		if (u != null) {
			System.out.println(u.getId());
			System.out.println(u.getUsername());
			System.out.println(u.getLogin().getEmail());
			System.out.println(u.getLogin().getPassword());
		} else {
			System.out.println("invalid ID!!!!!!");
		}

	}

	@Override
	public void updateUserDataOnly() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the User-ID :- ");
		int id = sc.nextInt();

		UserData u = s.get(UserData.class, id);

		if (u != null) {

			System.out.println("Enter the user name :-");
			u.setUsername(sc.next());

			s.update(u);
			s.beginTransaction().commit();
			System.out.println("Updated Successfully!!!!");

		} else {
			System.out.println("invalid ID!!!!!!");
		}

	}

	@Override
	public void updateLoginDataUsingUserId() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the User-ID :- ");
		int id = sc.nextInt();

		UserData u = s.get(UserData.class, id);

		if (u != null) {

			System.out.println("Enter the Login Email :- ");
			u.getLogin().setEmail(sc.next());

			System.out.println("Enter the Login Password :- ");
			u.getLogin().setPassword(sc.nextLong());

			s.update(u);
			s.beginTransaction().commit();
			System.out.println("Updated Successfully!!!!");

		} else {
			System.out.println("invalid ID!!!!!!");
		}
	}

	@Override
	public void deleteUserData() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the User-ID :- ");
		int id = sc.nextInt();

		UserData u = s.get(UserData.class, id);

		if (u != null) {

			s.delete(u);
			s.beginTransaction().commit();
			System.out.println("deleted Successfully!!!!");

		} else {
			System.out.println("invalid ID!!!!!!");
		}

	}

	@Override
	public void DeleteLoginDataUsingUserId() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		System.out.println("Enter the User-ID :- ");
		int id = sc.nextInt();

		UserData u = s.get(UserData.class, id);

		if (u != null) {

			u.setLogin(null);
			s.update(u);

			Login login = u.getLogin();
			s.delete(login);
			s.beginTransaction().commit();
			System.out.println("deleted Successfully!!!!");

		} else {
			System.out.println("invalid ID!!!!!!");
		}
	}
	
	
	
	
	
	
	

	// Login detials related methods
	@Override
	public void displayAllDataUsingLoginData() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();
		System.out.println("======================================");

		Query<Login> query = s.createQuery("from Login");
		List<Login> loginlist = query.getResultList();
		for (Login ls : loginlist) {
			System.out.println(ls.getLoginid());
			System.out.println(ls.getUserdata().getUsername());
			System.out.println(ls.getEmail());
			System.out.println(ls.getPassword());
		}

		System.out.println("==============================");
	}

	@Override
	public void displaySingleDataUsingLoginId() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the login-ID :- ");
		int id = sc.nextInt();

		Login l = s.get(Login.class, id);

		if (l != null) {
			System.out.println(l.getUserdata().getUsername());
			System.out.println(l.getEmail());
			System.out.println(l.getPassword());
		} else {
			System.out.println("invalid ID!!!!!!");
		}
	}

	@Override
	public void updateUserDataUsingLoginId() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the Login-ID :- ");
		int id = sc.nextInt();

		Login l = s.get(Login.class, id);

		if (l != null) {

			System.out.println("Enter the Username:- ");
			l.getUserdata().setUsername(sc.next());
			s.update(l);
			s.beginTransaction().commit();
			System.out.println("Updated Successfully!!!!");

		} else {
			System.out.println("invalid ID!!!!!!");
		}

	}

	@Override
	public void updateLoginDataOnly() {

		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the Login-ID :- ");
		int id = sc.nextInt();

		Login l = s.get(Login.class, id);

		if (l != null) {

			System.out.println("Enter the Login Email :- ");
			l.setEmail(sc.next());

			System.out.println("Enter the Login Password :- ");
			l.setPassword(sc.nextLong());

			s.update(l);
			s.beginTransaction().commit();
			System.out.println("Updated Successfully!!!!");

		} else {
			System.out.println("invalid ID!!!!!!");
		}
	}

	@Override
	public void deleteLoginData() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the Login-ID :- ");
		int id = sc.nextInt();

		Login l = s.get(Login.class, id);

		if (l != null) {

			s.delete(l);
			s.beginTransaction().commit();
			System.out.println("deleted Successfully!!!!");

		} else {
			System.out.println("invalid ID!!!!!!");
		}
	}

	@Override
	public void DeleteUserDataUsingLoginId() {
		Scanner sc = new Scanner(System.in);
		Session s = sf.openSession();

		System.out.println("Enter the Login-ID :- ");
		int id = sc.nextInt();

		Login l = s.get(Login.class, id);

		if (l != null) {

			l.setUserdata(null);
			s.update(l);
			UserData userdata = l.getUserdata();
			s.delete(userdata);
			s.beginTransaction().commit();
			System.out.println("deleted Successfully!!!!");

		} else {
			System.out.println("invalid ID!!!!!!");
		}
	}

}
