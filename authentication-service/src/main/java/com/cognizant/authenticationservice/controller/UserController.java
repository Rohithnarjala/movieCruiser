package com.cognizant.authenticationservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.Users;
import com.cognizant.authenticationservice.security.AppUserDetailsService;


@RestController
@RequestMapping("/movieCruiser/users")
@CrossOrigin("http://localhost:4200")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
//	@Autowired
//	InMemoryUserDetailsManager inMemoryUserDetailsManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@PostMapping
	public boolean signup(@RequestBody @Valid Users user) throws UserAlreadyExistsException {
//		boolean userFlag = false;
//		LOGGER.info("Start");
//		if (!inMemoryUserDetailsManager.userExists(user.getUserName())) {
//			userFlag = true;
//			inMemoryUserDetailsManager.createUser(User.withUsername(user.getUserName())
//					.password(passwordEncoder.encode(user.getPassword()))
//					.roles("USER").build());
//		} else {
//			try {
//				throw new UserAlreadyExistsException();
//			} catch (UserAlreadyExistsException u) {
//
//			}
//		}
//		LOGGER.info("End");
//		return userFlag;
		LOGGER.info("start");
		boolean flag = false;
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		flag = appUserDetailsService.signup(user);
		LOGGER.info("End");
		return flag;
	}
}

