package com.aartek.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.model.User;

@Controller
public class LogoutController {

	
	 @RequestMapping(value="/logout")
	 public void CheckLogout(HttpServletRequest request,HttpServletResponse response) throws IOException
	 {
		
		 System.out.println("inside logout controller");
		 request.getSession().removeAttribute("Users");
		 User user = (User)request.getSession().getAttribute("Users"); 
		 response.sendRedirect("userSignIn.do");
	 }
}
