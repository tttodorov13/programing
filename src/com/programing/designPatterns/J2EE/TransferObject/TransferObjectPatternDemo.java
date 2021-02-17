package com.programing.designPatterns.J2EE.TransferObject;

public class TransferObjectPatternDemo {

	public static void main(String[] args) {
		StudentBusinessObject studentBusinessObject = new StudentBusinessObject();

		// print all students
		for (StudentTransferObject student : studentBusinessObject.getAllStudents()) {
			System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
		}

		// update student
		StudentTransferObject student = studentBusinessObject.getAllStudents().get(0);
		student.setName("Michael");
		studentBusinessObject.updateStudent(student);

		// get the student
		student = studentBusinessObject.getStudent(0);
		System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
	}
}
