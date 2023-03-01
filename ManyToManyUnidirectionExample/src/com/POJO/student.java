package com.POJO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;

	private String sname;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<teacher> teacherlist = new ArrayList<teacher>();

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<teacher> getTeacherlist() {
		return teacherlist;
	}

	public void setTeacherlist(List<teacher> teacherlist) {
		this.teacherlist = teacherlist;
	}

	@Override
	public String toString() {
		return "student [sid=" + sid + ", sname=" + sname + ", teacherlist=" + teacherlist + "]";
	}

}
