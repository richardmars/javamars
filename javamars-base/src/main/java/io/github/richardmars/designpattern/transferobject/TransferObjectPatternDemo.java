package io.github.richardmars.designpattern.transferobject;

public class TransferObjectPatternDemo {
	public static void main(String[] args) {
		StudentBO studentBusinessObject = new StudentBO();
		
		for (StudentVO student : studentBusinessObject.getAllStudent()) {
			System.out.println("Student: [RollNo " + student.getRollNo() + ", Name: " + student.getName() + "]");
		}
		
		StudentVO student = studentBusinessObject.getAllStudent().get(0);
		student.setName("Michael");
		studentBusinessObject.updateStudent(student);
		
		student = studentBusinessObject.getStudent(0);
		System.out.println("Student: [RollNo： " + student.getRollNo() + ", Name " + student.getName() + "]");
	}
}
