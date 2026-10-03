package com.solarNetBilling.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.solarNetBilling.demo.DAO.UserRepo;
import com.solarNetBilling.demo.Model.Users;

@Service
public class UsersService{
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JWTService jwtService;
	
	@Autowired
	private UserRepo repo;
	public Users register(Users users) {
		return  repo.save(users);		
	}
	public String verify(Users users) {
		Authentication authentication = 
				authManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
		
		if(authentication.isAuthenticated())
			return jwtService.generateToken(users.getUsername());
		else
		  return "Fail";
	}
	
}