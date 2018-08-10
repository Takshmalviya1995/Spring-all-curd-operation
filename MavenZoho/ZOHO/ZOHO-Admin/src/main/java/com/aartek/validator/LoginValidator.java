package com.aartek.validator;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.User;
import com.aartek.repository.LoginRepository;
@Component
public class LoginValidator implements Validator {
	
	
	@Autowired
	private LoginRepository loginrepository;
	
	private static final String Email_Reg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static Pattern pattern;
	private Matcher matcher;

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
		
	}

	public void validate(Object target, Errors errors) {
	
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "email", "error.emailId.empty");
		ValidationUtils.rejectIfEmpty(errors, "password","error.password.empty");
		
		
		pattern = Pattern.compile(Email_Reg,Pattern.CASE_INSENSITIVE);
		matcher=pattern.matcher(user.getEmail());
		if(matcher.matches()!=true)
		{
			errors.rejectValue("email","error.email.first.rule");
		}
		
		
		/*else {
		DataBase Transaction
		List<User> list = loginrepository.checkLogin(user);
		Iterator<User> it = list.iterator();
		while(it.hasNext()) {
		  User us = (User)it.next();
		  if(!us.getEmail().equals(user.getEmail()) && !us.getPassword().equals(user.getPassword())) {
			  errors.rejectValue("email",null ,"userId or password is invalid");
		  }
		  
		}*/
	}
	
}
