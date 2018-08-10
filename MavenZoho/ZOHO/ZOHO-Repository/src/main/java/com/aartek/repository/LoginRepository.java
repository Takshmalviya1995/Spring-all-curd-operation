package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.User;

@Repository
public class LoginRepository {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
/* public void checkLogin(User login)
 {
	
	 System.out.println("inside LoginRepository");
	// System.out.println(login.getEmail());
	// System.out.println(login.getPassword());
	List<User> list= hibernateTemplate.find("from User u where u.email=? and u.password=?",login.getEmail(),login.getPassword());
	Iterator<User> it = list.iterator();
	while(it.hasNext()) 
	{
		User us = (User)it.next();
		
		System.out.println(us.getEmail());
		System.out.println(us.getPassword());
		
		
	}
 }*/
	
	public String findPassword(String email,String password)
	{
		System.out.println("Inside LoginRepository : findPassword");
		String uemail = null;
		String pass = null;
		String check = null;
		
		List<User> l= hibernateTemplate.find("from User u where u.email=? and u.password=?",email,password);
		Iterator<User> itr1 = l.iterator();
		while(itr1.hasNext())
		{
			User u = (User)itr1.next();
			uemail=u.getEmail();
			pass=u.getPassword();
			System.out.println("EmailId: "+uemail);
		}
		if(email.equals(uemail) && password.equals(pass))
		{
			System.out.println("Successfully Login");
			System.out.println("EmailId: "+email);
			check="Valid";
		}
		else
		{
			System.out.println("Not Valid Id And Password");
			check="Not Valid";
		}
		System.out.println(check);
		return check;
	}
 }
	

