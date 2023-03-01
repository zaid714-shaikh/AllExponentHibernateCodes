package com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	
	@NamedQuery (name = "empq" , query = "from employee"),
	@NamedQuery (name = "eemppartial" , query = "select ename,address from employee")
})
public class employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;

	private String ename;

	private String address;

	private Double salary;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "employee [eid=" + eid + ", ename=" + ename + ", address=" + address + ", salary=" + salary + "]";
	}

}
