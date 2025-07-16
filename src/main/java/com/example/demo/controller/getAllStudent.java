package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.StudentService;

@Controller
public class getAllStudent {
	
	@Autowired
	private StudentService studentService;

	 @GetMapping("/ui")
	    public String ui(Model model) {
	        model.addAttribute("students", studentService.findAllStudents());
	        return "index"; // refers to src/main/resources/templates/index.html
	    }
}
