package com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdharDetail {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adharid;

	private String email;

	private String password;

	public AdharDetail() {
	}

	public AdharDetail(int adharid, String email, String password) {
		super();
		this.adharid = adharid;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdharDetail [adharid=" + adharid + ", email=" + email + ", password=" + password + "]";
	}

}
