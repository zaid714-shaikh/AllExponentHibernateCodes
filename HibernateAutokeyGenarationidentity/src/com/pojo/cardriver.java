package com.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class cardriver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cdid;
	private String cdname;

	public int getCdid() {
		return cdid;
	}

	public void setCdid(int cdid) {
		this.cdid = cdid;
	}

	public String getCdname() {
		return cdname;
	}

	public void setCdname(String cdname) {
		this.cdname = cdname;
	}

	@Override
	public String toString() {
		return "cardriver [cdid=" + cdid + ", cdname=" + cdname + "]";
	}

}
