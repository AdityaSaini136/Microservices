package com.example.service;

import com.example.entity.Department;

public interface DepService {

	Department save(Department department);

	Department findDepartmentById(Long departmentID);

	 

}
