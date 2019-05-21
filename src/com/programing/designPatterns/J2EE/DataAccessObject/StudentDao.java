package com.programing.designPatterns.J2EE.DataAccessObject;

import java.util.List;

public interface StudentDao {

	List<Student> getAllStudents();

	Student getStudent(int rollNo);

	void updateStudent(Student student);

	void deleteStudent(Student student);
}
