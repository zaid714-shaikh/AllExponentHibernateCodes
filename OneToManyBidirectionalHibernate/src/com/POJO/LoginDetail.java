package com.POJO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LoginDetail{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lid;

	private String email;

	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_loginID")
	private UserDetail user;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetail getUser() {
		return user;
	}

	public void setUser(UserDetail user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Login [lid=" + lid + ", email=" + email + ", password=" + password + ", user=" + user + "]";
	}

}
