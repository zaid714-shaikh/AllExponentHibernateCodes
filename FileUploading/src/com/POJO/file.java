package com.POJO;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class file {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;

	private String fname;

	@Lob 
	private byte[] fdata;

	private String fdate;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public byte[] getFdata() {
		return fdata;
	}

	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}

	@Override
	public String toString() {
		return "file [fid=" + fid + ", fname=" + fname + ", fdata=" + Arrays.toString(fdata) + ", fdate=" + fdate + "]";
	}

}
