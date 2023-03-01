package com.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lid;

	private String lpasswd;

	@OneToOne(cascade = CascadeType.ALL)
	private user User;

	@OneToOne(cascade = CascadeType.ALL)
	private product Product;

	

}
