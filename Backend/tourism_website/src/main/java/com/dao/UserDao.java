package com.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;

@Service
public class UserDao {

	@Autowired
	UserRepository userRepository;
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	public User addUser(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		user.setConfirmPassword(hashPassword(user.getConfirmPassword()));
		User savedUser = userRepository.save(user);
		return savedUser;
	}
}
