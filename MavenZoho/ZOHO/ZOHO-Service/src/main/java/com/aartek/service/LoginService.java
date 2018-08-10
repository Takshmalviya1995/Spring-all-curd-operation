package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginrepository;
	
	public String checkLogin(User login)
	{
		System.out.println("Inside LoginService : checkLogin");
		/*System.out.println(login.getEmail());
		System.out.println(login.getPassword());
		
		loginrepository.checkLogin(login);*/
		
		String check=loginrepository.findPassword(login.getEmail(), login.getPassword());
		if(check.equals("Valid"))
		{
			System.out.println(check);
			return check;
		}
		else
		{
			System.out.println(check);
			return "check";
		}
	}
}
