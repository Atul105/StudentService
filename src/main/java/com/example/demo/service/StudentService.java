package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.CourseClient;
import com.example.demo.repository.StudentRepository;
import com.example.democlientdto.course;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository sr;
	
	@Autowired
	private CourseClient courseClient;
	
	
	//frign call service
	public course fetchCourseForStudent(int courseId) {
        return courseClient.getCourseById(courseId);
    }
	
	
	//find all
	public List<Student> findAllStudents(){
		
		return sr.findAll();
	}
	
	
	//getbyid
	
	public Student getById(int id) {
		
		return sr.findById(id).orElse(null);
	}
	
	
	//getbyname
	
	public Student getByName(String name) {
		return sr.findByname(name);
	}

	//addstudent
	public Student saveStudent(Student student) {
		return sr.save(student);
	}
	
	//updateAstudent
	public Student updateStudent(Student student) {
		
		Student existStudent = sr.findById(student.getId()).orElse(null);
		existStudent.setName(student.getName());
		existStudent.setDivision(student.getDivision());
		existStudent.setStandard(student.getStandard());
		
		return sr.save(existStudent);
	}
	
	//deletStudent
	public String deleteStudent(int id) {
		sr.deleteById(id);
		
		return "Student deleted sucessfully";
	}
	
}
