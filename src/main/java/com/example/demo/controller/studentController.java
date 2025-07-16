package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.democlientdto.course;

@RestController
public class studentController {
	
	@Autowired
	private StudentService studentService;
	
	
	
	@GetMapping("/students/courseById/{id}")
	public course getCourseDetails(@PathVariable("id") int courseId) {
	    return studentService.fetchCourseForStudent(courseId);
	}
	
	
	
	
	@GetMapping("/students")
	public List<Student> findAllStudents(){
		
		return studentService.findAllStudents();
	}

	@GetMapping("/studentById/{id}")
	public Student findStudentById(@PathVariable("id") int id) {
		return studentService.getById(id);
	}
	
	@GetMapping("/studentByName/{name}")
	public Student findStudentByName(@PathVariable String name) {
		return studentService.getByName(name);
	}
	
    @PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudnet(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}

}
