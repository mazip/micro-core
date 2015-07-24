package com.microframework.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	
	@RequestMapping(value = "/index.do")
	public String login(){
		
		return "login";
	}
	

}
