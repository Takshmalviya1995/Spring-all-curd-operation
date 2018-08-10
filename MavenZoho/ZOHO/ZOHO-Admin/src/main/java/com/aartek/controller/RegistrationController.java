package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;
import com.aartek.service.RegistrationService;
import com.aartek.validator.RegistrationValidator;


@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationValidator registrationvalidator;
	
	
	
	@Autowired
	private RegistrationService registrationservice;

/*	@RequestMapping("/registration")
	public String showRegistration(Map<String, Object> map)
	{
		map.put("userreg", new User());
		return "registration";
	}
	@RequestMapping(value="/userRegistration", method=RequestMethod.POST)
	public String registrationAction(@ModelAttribute("userreg") User reg,BindingResult result)
	{
		
		Boolean status= false;
		registrationvalidator.validate(reg, result);
		if(result.hasErrors())
		{
			return "registration";
		}
		else
		System.out.println("inside registrationAction");
		System.out.println(reg.getFirstname());
		System.out.println(reg.getLastname());
		System.out.println(reg.getEmail());
		System.out.println(reg.getPassword());
		System.out.println(reg.getMobileno());
		
		registrationservice.checkRegistration(reg);
		return " hello ";
	}*/
	
	
	 @RequestMapping(value="/userRegistration",method= {RequestMethod.GET,RequestMethod.POST})
	  public String registrationAction(@ModelAttribute("userreg")User reg,BindingResult result,Map<String, Object> map,HttpServletRequest request)
	  {
		  if("post".equals(request.getMethod().toLowerCase()))
		  {
			  registrationvalidator.validate(reg, result);
				if(result.hasErrors())
				{
					return "userRegistration";
				}
				else
				{
					System.out.println("inside SignIn Action");
					/* System.out.println(login.getEmail());
			  		System.out.println(login.getPassword());*/
			  
					registrationservice.checkRegistration(reg);
					return "hello";
				}
		  }
				map.put("userMap", new User());
				return "userRegistration";
	}
}
