package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.UserRepo.UserRepository;
import com.example.entity.User;
import com.example.userService.UserService;
import com.example.valueobject.Department;
import com.example.valueobject.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository; 

	@Autowired
	private RestTemplate restTamplate;

	@Override
	public User save(User user) {
		log.info("Inside saveUser of userService");
		return userRepository.save(user);
	}
	@Override
	public ResponseTemplateVO getUserWithDepartment(Long id) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
 		User user = userRepository.findById(id).orElse(null);
 		Department department = restTamplate.getForObject("http://localhost:8081/department/" 
 				+user.getDepartmentId(),Department.class);
          vo.setUser(user);
          vo.setDepartment(department);
          return vo;
	}
}
