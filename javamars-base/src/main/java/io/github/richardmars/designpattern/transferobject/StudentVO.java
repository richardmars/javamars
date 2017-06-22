package io.github.richardmars.designpattern.transferobject;

// VO: value object
public class StudentVO {
	private String name;
	private int rollNo;
	
	public StudentVO(String name, int i) {
		this.name = name;
		this.rollNo = i;
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
