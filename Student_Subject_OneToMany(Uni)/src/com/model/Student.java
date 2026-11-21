package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private int rollNo;
	private String sname;
	private float marks;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Subject",
	joinColumns = @JoinColumn(name = "Student_id"), 
	inverseJoinColumns = @JoinColumn(name = "Sub_id"))
	private List<Subject> subject;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject ;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", rollNo=" + rollNo + ", sname=" + sname + ", marks=" + marks + ", subject="
				+ subject + "]";
	}

	
}
