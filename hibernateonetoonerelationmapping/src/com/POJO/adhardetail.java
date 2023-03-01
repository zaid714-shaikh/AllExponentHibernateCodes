package com.POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class adhardetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private long adharnulmber;
	
	
	

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public long getAdharnulmber() {
		return adharnulmber;
	}

	public void setAdharnulmber(long adharnulmber) {
		this.adharnulmber = adharnulmber;
	}

	@Override
	public String toString() {
		return "adhardetail [aid=" + aid + ", adharnulmber=" + adharnulmber + "]";
	}

}
