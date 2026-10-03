package com.solarNetBilling.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solarNetBilling.demo.Model.Users;
import com.solarNetBilling.demo.Service.UsersService;

@RestController
//@RequestMapping("/register")
public class UserController{
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UsersService service;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
	
	@PostMapping("/register")
	public Users register(@RequestBody Users users) {
		users.setPassword(encoder.encode(users.getPassword()));
		return service.register(users);

	}
	
	@PostMapping("/loginUsers")
	public String login(@RequestBody Users users) {
		log.info("User: "+users);
		return service.verify(users);
	}
}