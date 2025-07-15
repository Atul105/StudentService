
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class homeController {
	

	    @GetMapping("/")
	    public String home() {
	        return "Welcome to the Student Service from home contoller mapping to {/}!";
	    }
	}