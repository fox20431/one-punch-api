package com.hihusky.user.services;


import com.hihusky.user.entities.User;

public interface UserService {
	public User register(User user);
	// public String genToken();
	public boolean checkPassword(String username, String password);
}
