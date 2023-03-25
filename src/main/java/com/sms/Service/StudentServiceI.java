package com.sms.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.Model.Student;

@Service
public interface StudentServiceI {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
  
	Student getstudentbyid(Long id);
	Student updatestudent(Student student);
	void deleteStudentById(Long id);
	
}
