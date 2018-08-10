package com.aartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.User;
import com.aartek.repository.RegistartionRepository;
@Service
public class RegistrationService {
	@Autowired
	private RegistartionRepository registrationrepository;
	 public void checkRegistration(User reg)
	 {
		 System.out.println("inside registrationService");
			System.out.println(reg.getFirstname());
			System.out.println(reg.getLastname());
			System.out.println(reg.getEmail());
			System.out.println(reg.getPassword());
			System.out.println(reg.getMobileno());
			
			registrationrepository.checkRegistration(reg);
	 }

}
