package io.github.richardmars.designpattern.dao;

public class Student {
	private String name;
	private int rollNo;
	
	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public int getRollNo() {
		return rollNo;
	}
}
