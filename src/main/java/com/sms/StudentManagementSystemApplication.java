package com.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sms.Model.Student;
import com.sms.Repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	
	@Autowired
	private StudentRepository stdrepo;
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Student s1=new Student(1,"Somesh","patil","a@gmail.com"); stdrepo.save(s1);
		 * 
		 * Student s2=new Student(2,"ganesh","patil","abc@gmail.com"); stdrepo.save(s2);
		 * 
		 * 
		 * Student s3=new Student(3,"xyz","zxc","xyz@gmail.com"); stdrepo.save(s3);
		 */
	}

}
