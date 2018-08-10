package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.User;
@Repository
public class RegistartionRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
 public void checkRegistration(User reg)
 {
	 hibernateTemplate.save(reg);
	 System.out.println(reg.getFirstname());
		System.out.println(reg.getLastname());
		System.out.println(reg.getEmail());
		System.out.println(reg.getPassword());
		System.out.println(reg.getMobileno());
	 
	 System.out.println("inside RegistrationRepository");
	 
 }
 
 /*if same mail present*/
 public String findEmail(String email)
 {
	 String mail=null;
	 List<User> list = hibernateTemplate.find("from User u where u.email=?",email);
	 Iterator<User> itr = list.iterator();
	 while(itr.hasNext())
	 {
		 User user = (User)itr.next();
		 mail = user.getEmail();
	 }
	 return mail;
	 }
 }

