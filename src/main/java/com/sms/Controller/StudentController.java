package com.sms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sms.Model.Student;
import com.sms.Service.StudentServiceI;

@Controller
public class StudentController {

	
	private StudentServiceI stdI;

	public StudentController(StudentServiceI stdI) {
		super();
		this.stdI = stdI;
	}
	           //handler method to handle list student and return mode and view
	@GetMapping("/students")
	public String listStudent(Model model)
	{
		model.addAttribute("students",stdI.getAllStudents());
		return "students";
		
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student stud=new Student();
		model.addAttribute("student", stud);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String savestudent(@ModelAttribute("student") Student student)
	{
		stdI.saveStudent(student);
		return "redirect:/students";		
	}
	@GetMapping("/students/edit/{id}")
	public String updatestudent(@PathVariable long id,Model  model)
	{
		model.addAttribute("student", stdI.getstudentbyid(id));
		return "update_student";
		
	}
	
	//request handler method
	@PostMapping("/students/{id}")
	public String updatestd(@PathVariable Long id,  
			@ModelAttribute("student") Student student,
			Model model)
	{
		// get student from database by id
		Student existingStd=stdI.getstudentbyid(id);
		existingStd.setId(id);
		  existingStd.setFirstname(student.getFirstname());
		  existingStd.setLastname(student.getLastname());
		  existingStd.setEmail(student.getEmail());
		  
		  //save updated std object
		  stdI.updatestudent(existingStd);  //stdI.updatestd(existingStd);
		return "redirect:/students";
		
	}
	// handler method to handle delete student reuest
	@GetMapping("/students/{id}")
	public String Deletestudent(@PathVariable Long id)
	{
		stdI.deleteStudentById(id);
		return "redirect:/students";
	}
	
	
}

//we will build a simple Student Management System web application using 
//Spring Boot,Spring MVC,Thymleaf,Spring Data JPA and MYSQL Database
