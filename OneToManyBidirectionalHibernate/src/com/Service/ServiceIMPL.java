package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.POJO.LoginDetail;
import com.POJO.UserDetail;
import com.util.HibernateUtil;

public class ServiceIMPL implements service {

	SessionFactory sf = HibernateUtil.getConnection();

	Scanner sc = new Scanner(System.in);

	@Override
	public void addUserWithLoginDetails() {

		Session s = sf.openSession();

		UserDetail u = new UserDetail();

		System.out.println("Enter the user name :- ");
		u.setUname(sc.next());

		System.out.println("How many login accounts you want:- ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			LoginDetail l = new LoginDetail();
			System.out.println("enter the Email :- ");
			l.setEmail(sc.next());
			System.out.println("Enter the password:- ");
			l.setPassword(sc.next());

			l.setUser(u);
			u.getLogin().add(l);

			s.save(l);
			s.save(u);
			s.beginTransaction().commit();
			System.out.println("Data Inserted !!!");

			System.out.println("");

		}

	}

	@Override
	public void displayUser() {

		Session s = sf.openSession();
		Query<UserDetail> query = s.createQuery("from UserDetail");
		List<UserDetail> userlist = query.getResultList();
		for (UserDetail user : userlist) {
			System.out.println(user);
		}

	}

	@Override
	public void displayLogin() {
		Session s = sf.openSession();
		Query<LoginDetail> query = s.createQuery("from LoginDetail");
		List<LoginDetail> Loginlist = query.getResultList();
		for (LoginDetail login : Loginlist) {
			System.out.println(login);
		}

	}

	@Override
	public void displaySingleUserUsingUserID() {
		Session s = sf.openSession();
		System.out.println("Enter the UserID youbwant to Fetch :- ");
		int id = sc.nextInt();
		UserDetail userdetail = s.get(UserDetail.class, id);

		System.out.println("++++++++userdetail++++");
		System.out.println("userID:-" + userdetail.getUid());
		System.out.println("username:- " + userdetail.getUname());
		System.out.println("++++++++++++++++++++++++++++");

	}

	@Override
	public void displaySingleloginDetailUsingUserID() {
		Session s = sf.openSession();
		System.out.println("Enter the UserID youbwant to Fetch :- ");
		int id = sc.nextInt();
		UserDetail userdetail = s.get(UserDetail.class, id);

		System.out.println("++++++++userdetail++++");
		System.out.println("userID:-" + userdetail.getUid());
		System.out.println("username:- " + userdetail.getUname());

		for (LoginDetail loginlistuser : userdetail.getLogin()) {
			System.out.println("UserloginID :- " + loginlistuser.getLid());
			System.out.println("UserLoginEmail :- " + loginlistuser.getEmail());
			System.out.println("UserLoginPassword : - " + loginlistuser.getPassword());
		}
		System.out.println("++++++++++++++++++++++++++++");

	}

	@Override
	public void updateUserusingUserID() {
		Session s = sf.openSession();
		System.out.println("Enter the UserID youwant to Update :- ");
		int id = sc.nextInt();
		UserDetail userdetail = s.get(UserDetail.class, id);
		if (userdetail != null && userdetail.getUid() == id) {

			System.out.println("Enter the username:-");
			userdetail.setUname(sc.next());
			s.update(userdetail);
			s.beginTransaction().commit();
			System.out.println("Data Updated Successfully!!");

			System.out.println();
		}
	}

	@Override
	public void updateLoginDtailUsingUserID() {
		Session s = sf.openSession();
		System.out.println("Enter the UserID youwant to Update :- ");
		int id = sc.nextInt();
		UserDetail userdetail = s.get(UserDetail.class, id);

		List<LoginDetail> listlogin = userdetail.getLogin();

		System.out.println("Enter the login ID:-");
		int lid = sc.nextInt();
		boolean flag = false;
		LoginDetail log = null;
		for (LoginDetail ll : listlogin) {
			if (ll != null && ll.getLid() == lid) {
				log = ll;
				flag = true;
			}
		}

		if (flag) {
			System.out.println("enter the Email :- ");
			log.setEmail(sc.next());
			System.out.println("Enter the password:- ");
			log.setPassword(sc.next());
			s.update(userdetail);
			s.beginTransaction().commit();

		}
	}

	@Override
	public void deleteLoginDtailUsingUserID() {

		Session s = sf.openSession();
		System.out.println("Enter the UserID:- ");
		int id = sc.nextInt();
		UserDetail userdetail = s.get(UserDetail.class, id);

		if (userdetail != null) {
			System.out.println("Enter the LoginID you want to delete :-");
			int lid = sc.nextInt();

			List<LoginDetail> listlogin = userdetail.getLogin();

			boolean flag = false;
			LoginDetail ll = null;
			for (LoginDetail list : listlogin) {
				if (list.getLid() == lid) {
					ll = list;
					flag = true;
					break;
				}
			}

			if (flag) {

				userdetail.getLogin().remove(ll);
				ll.setUser(null);
				s.update(userdetail);
				s.delete(ll);
				

				s.beginTransaction().commit();
				System.out.println("Data Deleted !!!");

			}
		} else {
			System.out.println("Invalid ID!!");
		}
	}

	@Override
	public void displaySingleUserUsingLoginID() {
		Session s = sf.openSession();
		System.out.println("Enter the LoginID:- ");
		int id = sc.nextInt();

		LoginDetail login = s.get(LoginDetail.class, id);

		if (login != null) {

			System.out.println("user ID :- " + login.getUser().getUid());
			System.out.println("User name:- " + login.getUser().getUname());
		} else {
			System.out.println("login ID Not Exist!!!");
		}

	}

	@Override
	public void displaySingleloginDetailUsingLoginID() {
		Session s = sf.openSession();

		Query<LoginDetail> query = s.createQuery("from LoginDetail");
		List<LoginDetail> loginlist = query.getResultList();

		for (LoginDetail l : loginlist) {
			System.out.println(l);
		}

	}

	@Override
	public void updateUserusingLoginID() {

		Session s = sf.openSession();
		System.out.println("Enter the LoginID:- ");
		int id = sc.nextInt();

		LoginDetail login = s.get(LoginDetail.class, id);

		if (login != null) {

			System.out.println("Enter the uSername:-");
			login.getUser().setUname(sc.next());

			s.update(login);
			s.beginTransaction().commit();
			System.out.println("Updated Successfulli!!!");

		}

	}

	@Override
	public void updateLoginDtailUsingLoginID() {

		Session s = sf.openSession();
		System.out.println("Enter the LoginID:- ");
		int id = sc.nextInt();

		LoginDetail login = s.get(LoginDetail.class, id);

		if (login != null) {

			System.out.println("Enter the Email:-");
			login.setEmail(sc.next());
			System.out.println("Enter the Password:-");
			login.setPassword(sc.next());

			s.update(login);
			s.beginTransaction().commit();
			System.out.println("Updated Successfulli!!!");

		}

	}

	@Override
	public void deleteLoginDtailUsingLoginID() {
		Session s = sf.openSession();
		System.out.println("Enter the LoginID:- ");
		int id = sc.nextInt();

		LoginDetail login = s.get(LoginDetail.class, id);

		if (login != null) {
			login.setUser(null);
			s.delete(login);
			
			s.beginTransaction().commit();
			System.out.println("Updated Successfulli!!!");

		}
	}
}
