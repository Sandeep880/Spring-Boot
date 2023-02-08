package com.emailapi.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class EmailController {
	
	
	@RequestMapping(value = "/sendmail")
	public String sendemail()
	{
		System.out.println("You are inside email");
		return "home";
	}
}
