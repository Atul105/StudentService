package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class studentUIController {
	
	@Autowired
	public StudentService studentService;
	
	
	
	@GetMapping("/addStudentForm")
	public String showForm(Model model) {
		model.addAttribute("student", new Student()); // Empty object for binding
		return "addStudent"; // refers to addStudent.html
	}

	// Handle form submission
	@PostMapping("/addStudentForm")
	public String submitForm(@ModelAttribute Student student) {
		studentService.saveStudent(student);
		return "redirect:/ui"; // Redirect to list or success page
	}

}
