package com.validate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.validate.entities.loginData;

import jakarta.validation.Valid;

@Controller
public class myController {
	
	@GetMapping("/form")
	public String openForm(Model model)
	{
		System.out.println("Opening Form");
		model.addAttribute("loginData", new loginData());
		
		return "form";
	}
	
	@PostMapping(path="/processForm")
	public String processForm(@Valid @ModelAttribute("loginData") loginData data,BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println(result);
			return "form";
		}
		System.out.println(data.toString());
		// if errors came then we send success page 
		return "success";
		
	}
}
