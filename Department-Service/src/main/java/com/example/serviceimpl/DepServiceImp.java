package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Department;
import com.example.repository.DepRepository;
import com.example.service.DepService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepServiceImp implements DepService {
	@Autowired
	private DepRepository depRepository;

	@Override
	public Department save(Department department) {
		log.info("Inside Save Deparment method of DepartmentController");
		return depRepository.save(department);
	}

	@Override
	public Department findDepartmentById(Long departmentID) {
		return depRepository.findById(departmentID).orElse(null);
	}

}
