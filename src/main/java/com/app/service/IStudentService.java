package com.app.service;
import java.util.ArrayList;
import java.util.List;
import com.app.pojos.*;
public interface IStudentService {
	//list all Students
	List<Student>getAllStudents();
	Student getStudentDetails(String name);
	//add new student details
	Student addStudentDetails(Student transientPOJO);
	Student updateStudentDetails(int studentId, Student detachedPOJO);
	List<Student>getAllStudentsbyDriveId(int id);
	boolean updateStudentStatus(ArrayList<Student> student);
}
