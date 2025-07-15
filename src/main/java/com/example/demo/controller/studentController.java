package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class studentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/students")
	public List<Student> findAllStudents(){
		
		return studentService.findAllStudents();
	}

	@GetMapping("/studentById/{id}")
	public Student findStudentById(@PathVariable("id") int id) {
		return studentService.getById(id);
	}
	
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

}
