package com.hihusky.user.controllers;

import com.auth0.jwt.JWT;
import com.hihusky.user.exceptions.InvalidUsernameOrPasswordException;
import com.hihusky.user.entities.User;
import com.hihusky.user.services.UserService;
import com.hihusky.user.utils.BCrypt;
import com.hihusky.user.utils.Token;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	User register(@RequestBody User user) {
		String encodedPassword = BCrypt.hashPassword(user.getPassword(), BCrypt.genSalt());
		user.setPassword(encodedPassword);
		User dbUser = userService.register(user);
		return dbUser;
	}

	@PostMapping(value = "/login", consumes = "application/x-www-form-urlencoded")
	@ResponseStatus(HttpStatus.OK)
	Map<String, String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
		if (userService.login(username, password)) {
			String token = Token.generateToken(username);
			Map<String, String> map = new HashMap<>();
			map.put("token", token);
			return map;
		} else {
			throw new InvalidUsernameOrPasswordException();
		}
	}

	@PostMapping(value = "/parse_token", consumes = "application/x-www-form-urlencoded")
	Map<String, String> parseToken(@RequestParam("token")String token) {
		Map<String, String> map = new HashMap<>();
		return Token.getClaim(token, "username");
	}
}
