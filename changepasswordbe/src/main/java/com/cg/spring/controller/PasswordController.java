package com.cg.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.service.IPasswordService;

@RestController
public class PasswordController {

	@Autowired
	IPasswordService service;
	
	@RequestMapping("/change")
	 public String changePassword(@RequestParam String email, @RequestParam String password,@RequestParam String nPassword) {
		return service.changePassword(email, password, nPassword);
	}
	
}
