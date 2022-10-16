package com.hihusky.user.services.impl;

import com.hihusky.user.entities.User;
import com.hihusky.user.repositories.UserRepository;
import com.hihusky.user.services.UserService;
import com.hihusky.user.utils.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User register(User user) {
		return userRepository.save(user);
	}

	@Override
	public boolean checkPassword(String username, String password) {
		User user = userRepository.findOneByUsername(username).get();
		return BCrypt.checkPassword(password, user.getPassword());
	}
	
}