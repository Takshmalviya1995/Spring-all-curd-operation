package com.aartek.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class EmailSpotInterception extends HandlerInterceptorAdapter{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception 
	{
		System.out.println("Inside EmailSpotInterception : afterCompletion()");
		
	}
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception 
	{
		System.out.println("Inside EmailSpotInterception : postHandle()");
		
	}
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception 
	{
		System.out.println("Inside EmailSpotInterception : preHandle()");
		return true;
	}

}
