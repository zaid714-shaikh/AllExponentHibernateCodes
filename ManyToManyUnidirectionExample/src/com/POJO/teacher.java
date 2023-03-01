package com.POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherID;

	private String teacherName;

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "teacher [teacherID=" + teacherID + ", teacherName=" + teacherName + "]";
	}

}
