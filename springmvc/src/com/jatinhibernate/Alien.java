package com.jatinhibernate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alien {

	@Id
	@GeneratedValue
	private int aid;
	 
	@Column
	private int aemp;
	
	@Column
	private String aname ;
	
	@Column
	private String alast;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAemp() {
		return aemp;
	}

	public void setAemp(int aemp) {
		this.aemp = aemp;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAlast() {
		return alast;
	}

	public void setAlast(String alast) {
		this.alast = alast;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aemp=" + aemp + ", aname=" + aname + ", alast=" + alast + "]";
	}

	
	
	
}
