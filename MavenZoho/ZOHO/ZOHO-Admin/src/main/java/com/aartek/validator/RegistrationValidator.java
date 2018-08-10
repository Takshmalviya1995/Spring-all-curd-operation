package com.aartek.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.User;
import com.aartek.repository.RegistartionRepository;

@Component
public class RegistrationValidator implements Validator {
	@Autowired
	private RegistartionRepository registartionrepository; 
	
	private static final String Email_Reg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String pwd = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}";
	private static Pattern pattern;
	private Matcher matcher;
	

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
	
		User user = (User) target;
	ValidationUtils.rejectIfEmpty(errors, "firstname", "error.firstName.empty");
	ValidationUtils.rejectIfEmpty(errors, "lastname", "error.lastName.empty");
	ValidationUtils.rejectIfEmpty(errors, "email","error.emailId.empty");
	ValidationUtils.rejectIfEmpty(errors, "password","error.password.empty");
	ValidationUtils.rejectIfEmpty(errors, "mobileno", "error.mobileNo.empty");
	
	
	
	if(user.getFirstname()!=null && user.getFirstname().trim().length()>=50)
	{
		errors.rejectValue("firstname", "error.firstname.length");
	}
	if(user.getLastname()!=null && user.getLastname().trim().length()>=50)
	{
		errors.rejectValue("lastname", "error.lastname.length");
	}
	/*Email Validation*/
	pattern = Pattern.compile(Email_Reg,Pattern.CASE_INSENSITIVE);
	matcher=pattern.matcher(user.getEmail());
	if(matcher.matches()!=true)
	{
		errors.rejectValue("email","error.emailid.formate");
	}
	 /*Password Validation*/
	pattern = Pattern.compile(pwd);
	matcher = pattern.matcher(user.getPassword());
	if(matcher.matches()!=true)
	{
		errors.rejectValue("password","error.password.formate");
	}
	if(user.getMobileno()!=null && user.getMobileno().toString().length()!=10)
	{
		errors.rejectValue("mobileno","error.contactNo.length");
	}
	
	/*DataBase Transaction*/
	String email = registartionrepository.findEmail(user.getEmail());
	if(user.getEmail().equals(email)==true)
	{
		errors.rejectValue("email","error.emailid.exist");
	}
	
	}

}
