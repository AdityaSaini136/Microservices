package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Department;
import com.example.service.DepService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DepController {

	@Autowired
	private DepService depService;

	@PostMapping("/department")
	private ResponseEntity<Department> save(@RequestBody Department department){
		log.info("Inside Save Deparment method of DepartmentService");
		Department depSave = depService.save(department);
		return new ResponseEntity<Department> (depSave, HttpStatus.CREATED);
	}
	@GetMapping("/department/{ID}")
	private ResponseEntity<Department> findDepartmentById(@PathVariable("ID") Long departmentID){
		Department findDep   = depService.findDepartmentById(departmentID);
		return new ResponseEntity<Department>(findDep, HttpStatus.OK);
	}
}