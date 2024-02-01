package com.ts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDao;
import com.model.User;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;
	
	@PostMapping("addUser")
	public ResponseEntity<String> addUser(@RequestBody User user){
		
		if(!user.getPassword().equals(user.getConfirmPassword())){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password do not match");
		}
		userDao.addUser(user);
		return ResponseEntity.status(HttpStatus.OK).body("User added successfully");
	}
}
