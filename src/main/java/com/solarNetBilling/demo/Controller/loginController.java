package com.solarNetBilling.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class loginController{
	
	@RequestMapping("/login/sessionId")
	public String login(HttpServletRequest request) {
		return ("You are Logged In, your session id : "+ request.getSession().getId());
	}
}