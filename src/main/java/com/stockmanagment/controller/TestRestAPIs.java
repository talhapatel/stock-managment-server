package com.stockmanagment.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Scope("request")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("test")
public class TestRestAPIs extends BaseController {
	
	
	
	@PostMapping("/{name}")
	public ApiResponse welcome(@PathVariable String name) {
		setData("name", "welcome "+name);
		return renderResponse();
	}
}