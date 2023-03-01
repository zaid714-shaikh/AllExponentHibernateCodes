package com.POJO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	private String uname;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<LoginDetail> login = new ArrayList<LoginDetail>();

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public List<LoginDetail> getLogin() {
		return login;
	}

	public void setLogin(List<LoginDetail> login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname +  "]";
	}

}
