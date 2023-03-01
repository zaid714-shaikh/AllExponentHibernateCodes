package com.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productid;

	private String productname;

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "Product")
	private user User;

	@OneToOne(cascade = CascadeType.ALL,mappedBy = "Product")
	private login Login;

	
}
