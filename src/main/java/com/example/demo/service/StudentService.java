package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository sr;
	
	
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

	public Student saveStudent(Student student) {
		return sr.save(student);
	}
	
	
}
