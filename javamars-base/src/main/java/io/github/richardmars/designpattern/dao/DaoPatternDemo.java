package io.github.richardmars.designpattern.dao;

public class DaoPatternDemo {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoImpl();
		
		for (Student student : studentDao.getAllStudents()) {
			System.out.println("Student: [Roll No : " + student.getRollNo() + ", name : " + student.getName() + " ]"); 
		}
		
		// 通过VO交互，不通过单独的属性
		Student student = studentDao.getAllStudents().get(0);
		student.setName("Michael");
		studentDao.updateStudent(student);
		
		student = studentDao.getStudent(0);
		System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");	
	}
}
