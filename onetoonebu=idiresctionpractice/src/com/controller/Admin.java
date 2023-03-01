package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.hibernateutil;

public class Admin {

	public static void main(String[] args) {
		
		
		 SessionFactory sf= hibernateutil.getConnection();
		 
		 
		 Session s = sf.openSession();
		 
		 
	}
}
