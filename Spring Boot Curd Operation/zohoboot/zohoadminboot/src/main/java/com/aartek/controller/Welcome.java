package com.aartek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {
	@RequestMapping("/")
	public String getMessage(Model model) {
		model.addAttribute("message", "Hello Deependra");
		return "welcome";
	}
}
