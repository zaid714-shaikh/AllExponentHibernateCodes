package com.POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class projects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	private String projectname;

	private double projectprice;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public double getProjectprice() {
		return projectprice;
	}

	public void setProjectprice(double projectprice) {
		this.projectprice = projectprice;
	}

	@Override
	public String toString() {
		return "projects [pid=" + pid + ", projectname=" + projectname + ", projectprice=" + projectprice + "]";
	}

}
