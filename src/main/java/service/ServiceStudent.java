package service;

import java.util.List;

import dao.DAOStudent;
import model.Student;

public class ServiceStudent {

	public static List<Student> getAllStudents() {
		return DAOStudent.getAllStudents();
	}

	public static Student getStudentById(int id) {	
		return DAOStudent.getStudentById(id);
	}
	
	public static void AddStudent(Student student) {	
		DAOStudent.createStudent(student);
	}
	
	public static void updateStudent(Student student) {	
		DAOStudent.updateStudent(student);
	}

	public static void deleteStudent(Student student) {
		DAOStudent.deleteStudent(student);	
	}

	public static Student getStudentByIdEagerly(int id) {
		return DAOStudent.getStudentByIdEagerly(id);
	}


}
