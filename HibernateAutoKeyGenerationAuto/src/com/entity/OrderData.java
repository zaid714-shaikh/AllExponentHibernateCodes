package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int oid;
	
	private String oname;
	
	private String omode;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOmode() {
		return omode;
	}

	public void setOmode(String omode) {
		this.omode = omode;
	}

	@Override
	public String toString() {
		return "OrderData [oid=" + oid + ", oname=" + oname + ", omode=" + omode + "]";
	}
	
	
}
