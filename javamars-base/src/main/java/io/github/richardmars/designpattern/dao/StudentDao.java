package io.github.richardmars.designpattern.dao;

import java.util.List;

public interface StudentDao {
	public List<Student> getAllStudents();
	public Student getStudent(int rollNo);
	public void updateStudent(Student student);
	public void deleteStuden(Student student);
}
