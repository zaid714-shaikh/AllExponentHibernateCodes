package com.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	private String uname;

	@OneToOne(cascade = CascadeType.ALL)
	private login Login;
	
	@OneToOne(cascade = CascadeType.ALL)
	private product Product;

	
}
