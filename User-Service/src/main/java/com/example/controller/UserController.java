package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.userService.UserService;
import com.example.valueobject.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<User> save(@RequestBody User user){
		User userSave = userService.save(user);
		return new ResponseEntity<User>(userSave , HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id")Long id){
		log.info("Inside getUserWithDepartment of UserController");
		return userService.getUserWithDepartment(id);
		//return new ResponseEntity<ResponseTemplateVO>( HttpStatus.OK);
	}
}
