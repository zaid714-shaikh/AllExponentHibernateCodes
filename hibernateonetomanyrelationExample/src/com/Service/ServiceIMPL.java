package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pojo.Customer;
import com.pojo.product;
import com.util.HibernateUtil;

public class ServiceIMPL implements Service {

	SessionFactory sf = HibernateUtil.getConnection();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCustomer() {

		Session s = sf.openSession();
		Customer c = new Customer();
		System.out.println("Enter the customer:-");
		c.setCustname(sc.next());
		s.save(c);
		s.beginTransaction().commit();

		System.out.println("");
	}

	@Override
	public void addProducts() {
		Session s = sf.openSession();
		System.out.println("Enter the customerID:-");
		int id = sc.nextInt();
		Customer cust = s.get(Customer.class, id);
		if (cust != null) {

			System.out.println("How many products you want to add:-");
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				product p = new product();
				System.out.println("Enter the Product Name:-");
				p.setProductname(sc.next());
				cust.getProductlist().add(p);
				s.save(cust);
				s.beginTransaction().commit();
			}
		} else {
			System.out.println("Invalid Customer ID!!!");
		}

	}

	@Override
	public void updateCustomer() {
		Session s = sf.openSession();
		System.out.println("Enter the customerID:-");
		int id = sc.nextInt();
		Customer c = s.get(Customer.class, id);
		if (c != null) {

			System.out.println("Enter the customer name:-");
			c.setCustname(sc.next());
			s.update(c);
			s.beginTransaction().commit();

		} else {
			System.out.println("Invalid Customer ID!!!");
		}

	}

	@Override
	public void updateProductUsingCustomerID() {
		Session s = sf.openSession();
		System.out.println("Enter the customerID:-");
		int id = sc.nextInt();
		Customer c = s.get(Customer.class, id);
		if (c != null) {
			System.out.println("Enter the Product ID you wnt to updtate:- ");
			int pid = sc.nextInt();
			for (product plist : c.getProductlist()) {

				if (plist != null && pid == plist.getPid()) {
					System.out.println("Enter the Product Name");
					plist.setProductname(sc.next());
					s.update(c);
					s.beginTransaction().commit();
					System.out.println("Products Updated Succesfully!!!");
				} else {
					System.out.println("Invaid Product ID!!");
				}

			}
		} else {
			System.out.println("Invalid Customer ID!!!");
		}

	}

	@Override
	public void deleteCustomer() {
		Session s = sf.openSession();
		System.out.println("Enter the customerID:-");
		int id = sc.nextInt();
		Customer c = s.get(Customer.class, id);
		if (c != null) {
			s.delete(c);
			s.beginTransaction().commit();
			System.out.println("cutomer Deleted Successfully!!!");

		} else {
			System.out.println("Invalid Customer ID!!!");
		}

	}

	@Override
	public void deleteProductsUsingCustomerID() {
		Session s = sf.openSession();
		System.out.println("Enter the customerID:-");
		int id = sc.nextInt();
		Customer c = s.get(Customer.class, id);
		if (c != null) {

			for (product lp : c.getProductlist()) {
				s.delete(lp);
				s.beginTransaction().commit();

			}
			System.out.println("product Deleted !!!");
			System.out.println("");
		} else {
			System.out.println("Invalid Customer ID!!!");
		}
	}

	@Override
	public void showCustomer() {
		Session s = sf.openSession();
		Query<Customer> query = s.createQuery("from Customer");
		List<Customer> clist = query.getResultList();

		for (Customer c : clist) {
			System.out.println(c.getCustid());
			System.out.println(c.getCustname());
			for (product p : c.getProductlist()) {
				System.out.println(p.getPid());
				System.out.println(p.getProductname());
			}
		}
	}

	@Override
	public void showSpecificCustomer() {
		Session s = sf.openSession();
		System.out.println("Enter the customerID:-");
		int id = sc.nextInt();
		Customer c = s.get(Customer.class, id);
		if (c != null) {

			System.out.println(c.getCustid());
			System.out.println(c.getCustname());
			for (product pro : c.getProductlist()) {
				System.out.println(pro.getPid());
				System.out.println(pro.getProductname());
			}

		} else {
			System.out.println("Invalid Customer ID!!!");
		}
	}

	@Override
	public void showproducts() {
		Session s = sf.openSession();

		Query<product> query = s.createQuery("from product");
		List<product> plist = query.getResultList();

		for (product p : plist) {
			System.out.println(p.getPid());
			System.out.println(p.getProductname());
		}

	}

	@Override
	public void showSpecificProductUsingCustomerID() {
		Session s = sf.openSession();
		System.out.println("Enter the customerID:-");
		int id = sc.nextInt();
		Customer c = s.get(Customer.class, id);
		if (c != null) {

			for (product pro : c.getProductlist()) {
				System.out.println(pro.getPid());
				System.out.println(pro.getProductname());
			}

		} else {
			System.out.println("Invalid Customer ID!!!");
		}

	}

	@Override
	public void deletSpecificCustomer() {

		Session s = sf.openSession();
		System.out.println("Enter the Customer ID:- ");
		int id = sc.nextInt();
		Customer cust = s.get(Customer.class, id);
		if (cust != null) {
			s.delete(cust);
			s.beginTransaction().commit();
			System.out.println("Customer Deleted Syccessfully!!");
		} else {
			System.out.println("Invalid Customer ID");
		}

	}

	@Override
	public void deleteSpecificProductUsingCustomerID() {

		Session s = sf.openSession();
		System.out.println("Enter the Customer ID:- ");
		int id = sc.nextInt();
		Customer cust = s.get(Customer.class, id);

		if (cust != null) {

			System.out.println("Enter the Product ID you want to Delete:-");
			int pid = sc.nextInt();
			List<product> plist = cust.getProductlist();

			product p = null;
			boolean flag = false;
			for (product product : plist) {
				if (pid == product.getPid()) {
					p = product;
					flag = true;
				}

			}

			if (flag) {

				plist.remove(p);
				s.update(cust);
				s.delete(p);
				s.beginTransaction().commit();
			}

		} else {
			System.out.println("Invalid Customer ID");
		}
	}

}
