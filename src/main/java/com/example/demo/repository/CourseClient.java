package com.example.demo.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.democlientdto.course;

@FeignClient(name = "course-service", url = "http://localhost:8050")
public interface CourseClient {
	
	
	@GetMapping("/courseById/{id}")
    course getCourseById(@PathVariable("id") int id);

}
