package com.thymeleaf.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	// Handler for about
	
	@RequestMapping(value= "/about" , method= RequestMethod.GET )
	public String about(Model model) 
	{
		System.out.println("Inside in the Handler");
		
		// putting data in the model
		model.addAttribute("name", "Sandeep Kumar");
		model.addAttribute("currentDate", new Date().toLocaleString());
		
		return "about";

	}
	// handler for iterator
	
	@GetMapping("/iterator")
	public String iteratorHandler(Model m)
	{
		System.out.println("You are Inside in the Iterator");
		
		// Send data
		// create a llist, set 
		
		List<String> names = List.of("Diwakar","Sandeep","Satyadeep","Lila");
		
		m.addAttribute("names",names);
		
		
		
		
		return "iterate";
	}
	
	// handler for conditional Handler
	
	@GetMapping("/condition")
	public String conditionHandler(Model m)
	{
		System.out.println("You are inside conditional ");
		m.addAttribute("isActive", true);
		m.addAttribute("gender", "F");
		
		List<Integer> list= List.of(12,45,67,8,9,56,87);
		m.addAttribute("myList", list);
		
		
		return "condition";
	}
	
	
	// handler for including fragment
	@GetMapping("/service")
	public String service(Model m)
	{
		// processing logic 
		
		m.addAttribute("title", "I Liked to eat Briyani");
		m.addAttribute("subtitle", "After that I drinks Coca Cola");
		
		return "service";
	}
	
	// Handling of new About Page and inserting footer
	@GetMapping("/aboutNew")
	public String newAbout()
	{
		return "newAbout";
	}
	
	

}
