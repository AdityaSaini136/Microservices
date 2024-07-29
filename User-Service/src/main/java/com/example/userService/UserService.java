package com.example.userService;

import com.example.entity.User;
import com.example.valueobject.ResponseTemplateVO;

public interface UserService {

	User save(User user);

	ResponseTemplateVO getUserWithDepartment(Long id);
}