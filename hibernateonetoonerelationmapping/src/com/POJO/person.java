package com.POJO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;

	@OneToOne(cascade = CascadeType.ALL)
	private adhardetail adhard;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public adhardetail getAdhard() {
		return adhard;
	}

	public void setAdhard(adhardetail adhard) {
		this.adhard = adhard;
	}

	@Override
	public String toString() {
		return "person [pid=" + pid + ", pname=" + pname + ", adhard=" + adhard + "]";
	}

}
