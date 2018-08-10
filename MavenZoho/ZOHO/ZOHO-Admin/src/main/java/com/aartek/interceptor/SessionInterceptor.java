package com.aartek.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.User;

@Component
public class SessionInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception 
	{
		System.out.println("Inside Session : afterCompletion");
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception 
	{
		System.out.println("Inside Session : postHandle");
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception 
	{
		User user = (User)request.getSession().getAttribute("Users"); 
		
		
		if(user==null || user.equals(""))
		{
			/*System.out.println("response"+user);*/
			response.sendRedirect("userSignIn.do");
			//request.setAttribute("LogoutMsg","Invalid Session");
			return false;
		}
		System.out.println("Inside Session : preHandle");
		return true;
	}

	
	
}
