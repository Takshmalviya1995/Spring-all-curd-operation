package com.aartek.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.User;

@Repository
@Transactional
public class LoginRepository {

	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	final static Logger logger = Logger.getLogger(LoginRepository.class);
	public String checkLogin(User login)
	{
		logger.debug("Inside Repository : Login");
		
		logger.debug(login.getEmail());
		logger.debug(login.getPassword());
		hibernatetemplate.save(login);
		return "user";
	}
	public Boolean loginRepoCheck(String email,String password)
	{
		System.out.println("Inside LoginRepository : loginRepoCheck() ");
		System.out.println(email);
		System.out.println(password);
		return true;
		
	}
}
