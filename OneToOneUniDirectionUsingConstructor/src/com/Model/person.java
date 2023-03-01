package com.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class person {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	private String pname;

	@OneToOne(cascade = CascadeType.ALL)
	private AdharDetail adhardetail;

	public person(int pid, String pname, AdharDetail adhardetail) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.adhardetail = adhardetail;
	}

	public person() {

	}

	@Override
	public String toString() {
		return "person [pid=" + pid + ", pname=" + pname + ", adhardetail=" + adhardetail + "]";
	}

}
