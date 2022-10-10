package com.hihusky.user.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hihusky.user.po.User;
import com.hihusky.user.services.UserService;
import com.hihusky.user.utils.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

	UserService userService;

	Algorithm algorithm = Algorithm.HMAC256("one_punch_hmac256");
	Date issuedAt = new Date();
	String issuer = "one_punch";

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	Map<String, String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
		if (userService.login(username, password)) {
			Date issuedAt = new Date();
			// generate expired time
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, 180); // expires 180 days from now
			Date expiredAt = calendar.getTime();
			String token = JWT.create()
					.withIssuer(issuer)
					.withIssuedAt(issuedAt)
					.withExpiresAt(expiredAt)
					.withClaim("username", username)
					.sign(algorithm);
			System.out.println(token);
			Map<String, String> map = new HashMap<String, String>();
			map.put("token", token);
			return map;
		} else {
			throw new Error();
		}
	}

	@PostMapping("/users")
	String register(@RequestParam("username") String username, @RequestParam("password") String password) {
		String encodedPassword = BCrypt.hashPassword(password, BCrypt.genSalt());
		User user = new User();
		user.setUsername(username);
		user.setPassword(encodedPassword);
		userService.register(user);
		return "create successfully!";
	}

}
