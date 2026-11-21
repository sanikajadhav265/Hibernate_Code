package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passportid;
	private String passportNo;
	private String countryName;
	
	public int getPassportid() {
		return passportid;
	}
	public void setPassportid(int passportid) {
		this.passportid = passportid;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	@Override
	public String toString() {
		return "Passport [passportid=" + passportid + ", passportNo=" + passportNo + ", countryName=" + countryName
				+ "]";
	}
	
	

}
