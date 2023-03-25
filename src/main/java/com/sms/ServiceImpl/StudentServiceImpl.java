package com.sms.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.Model.Student;
import com.sms.Repository.StudentRepository;
import com.sms.Service.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI {
	
	private StudentRepository studentrepo;
	public StudentServiceImpl(StudentRepository studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}

	@Override
	public List<Student> getAllStudents() {
	
		return studentrepo.findAll();
	}
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentrepo.save(student);
	}

	@Override
	public Student getstudentbyid(Long id) {
		
		return studentrepo.findById(id).get();
	}

	@Override
	public Student updatestudent(Student student) {
	
		return studentrepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentrepo.deleteById(id);
	}

}
