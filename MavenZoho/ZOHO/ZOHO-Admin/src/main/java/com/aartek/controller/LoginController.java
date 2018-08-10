package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;
import com.aartek.service.LoginService;
import com.aartek.validator.LoginValidator;
import com.aartek.validator.RegistrationValidator;

@Controller
public class LoginController {
	
	@Autowired
	private LoginValidator loginvalidator;
	
	@Autowired
	private LoginService loginservice;
	
 /* @RequestMapping("/login")
   public String showLogin(Map<String, Object> map){
	   System.out.println("Inside controller");
	  //User user = new User();
	   //map.put("userMap", user); OR
	   
	   map.put("userMap", new User());
	   return "login";
   }
  @RequestMapping(value="/userSignIn", method=RequestMethod.POST)
  public String signInAction(@ModelAttribute("userMap")User login,BindingResult result)
  {
	  Boolean status= false;
		loginvalidator.validate(login, result);
		if(result.hasErrors())
		{
			return "login";
		}
		else
	  System.out.println("inside SignIn Action");
	  System.out.println(login.getEmail());
	  System.out.println(login.getPassword());
	  
	  loginservice.checkLogin(login);
	  return "hello";
	  
  }*/
  
 @RequestMapping(value="/userSignIn",method= {RequestMethod.GET,RequestMethod.POST})
  public String LoginAction(@ModelAttribute("userMap")User login,BindingResult result,Map<String, Object> map,HttpServletRequest request,HttpServletResponse response)
  {
	 System.out.println("Inside Login controller: LoginAction");
	  boolean status = false;
	  if("post".equals(request.getMethod().toLowerCase()))
	  {
			loginvalidator.validate(login, result);
			if(result.hasErrors())
			{
				return "userSignIn";
			}
			else
			{
				String check=loginservice.checkLogin(login);
				if(check.equals("Valid"))
				{
					try
					{
						System.out.println("controller valid");
						request.getSession().setAttribute("Users",login);
						response.sendRedirect("product.do");
					}
					catch(Exception e)
					{
						System.out.println("Something Wrong");
					}
				}
				else
				{
					return "userSignIn";
				}
				/*System.out.println("inside SignIn Action");
				 System.out.println(login.getEmail());
		  		System.out.println(login.getPassword());
		  
				loginservice.checkLogin(login);
				return "hello";*/
			}
	  }
			map.put("userMap", login);
			return "userSignIn";
}
}
