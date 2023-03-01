package com.pojo;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custid;

	private String custname;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_cid")
	private List<product> productlist = new ArrayList<product>();

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public List<product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<product> productlist) {
		this.productlist = productlist;
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", productlist=" + productlist + "]";
	}

}
