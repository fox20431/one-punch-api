package com.hihusky.user.services;


import com.hihusky.user.po.User;

public interface UserService {
	public User register(User user);
	public boolean login(String username, String password);
}
