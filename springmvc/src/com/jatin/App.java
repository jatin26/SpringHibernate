package com.jatin;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class App 
{
	@Id
	private int aemp;
	private String aname ;
	private String alast;
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
		return "App [aemp=" + aemp + ", aname=" + aname + ", alast=" + alast + "]";
	}
	
	
}
