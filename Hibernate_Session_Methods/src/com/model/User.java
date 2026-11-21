package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Info")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	private String uName;
	private String uAddress;
	private String uEmail;
	private int uPincode;
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public int getuPincode() {
		return uPincode;
	}
	public void setuPincode(int uPincode) {
		this.uPincode = uPincode;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uAddress=" + uAddress + ", uEmail=" + uEmail + ", uPincode="
				+ uPincode + "]";
	}
	
	

}
