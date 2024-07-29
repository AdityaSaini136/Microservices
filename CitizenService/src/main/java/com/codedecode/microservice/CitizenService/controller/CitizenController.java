package com.codedecode.microservice.CitizenService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.microservice.CitizenService.entity.Citizen;
import com.codedecode.microservice.CitizenService.repository.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	CitizenRepo citizenRepo;

	@RequestMapping(path = "/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("Test", (HttpStatus.OK));
	}
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<List<Citizen>> getBYId(@PathVariable Integer id){
		List<Citizen> listCitizen = citizenRepo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(listCitizen, HttpStatus.OK);
	}
	@PostMapping(path = "/citizens")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){
		Citizen citizen = citizenRepo.save(newCitizen);
		return new ResponseEntity<>(citizen, HttpStatus.OK);
	}
     

}
