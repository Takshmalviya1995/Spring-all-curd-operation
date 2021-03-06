package com.aartek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.Employee;
import com.aartek.service.EmployeeService;

@Controller
/*@RequestMapping("/")*/

public class RegistrationController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@RequestMapping(value= { "/registration"}, method=RequestMethod.GET)
	public String listEmployee(Model model)
	{
		model.addAttribute("employee",new Employee());
		System.out.println("REgistration Controller : listEmployee Get");
		return "registration";	
	}
	
	@RequestMapping(value="/registration1", method=RequestMethod.POST)
	public String listEmployee(@ModelAttribute("employee") Employee emp )
	{
		System.out.println("REgistration Controller : listEmployee Post");
		 employeeservice.checkEmployee(emp);
		return "registration";	
	}
	
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	  public String employeeAction(@ModelAttribute("employee")Employee emp,Map<String, Object> map)
	  { 
		   System.out.println("inside SignIn Action");  
			map.put("empList", employeeservice.getEmployeeDetails(emp));
			System.out.println(emp.getAddress());
			return "allemployees";
	  }
	 @RequestMapping(value="/delete-{id}", method=RequestMethod.GET)
	 public String deleteEmployeeDetails(@PathVariable Integer id)
	 {
		 System.out.println("Employee Controller : deleteEmployeeDetails");
		 System.out.println("Employee ID: "+id);
		 employeeservice.deleteEmployeeService(id);
		 
		 return "allemployees";
	 }
	
	 @RequestMapping(value="/edit-{id}", method=RequestMethod.GET)
	  public ModelAndView edit(@PathVariable Integer id,Model model)
	  { 
		   System.out.println("Employee Controller : editEmployeeDetails");  
			Employee emp = employeeservice.editEmployeeDetails(id);
			model.addAttribute("employee",emp);
			return new ModelAndView("update","command",emp);
	  }
	 
	 

		@RequestMapping(value="/editsave", method=RequestMethod.POST)
		public String updateEmployee(@ModelAttribute("employee") Employee emp )
		{
			System.out.println("REgistration Controller : editEmployee Post");
			employeeservice.updateEmployee(emp);
			return "allemployees";	
		}
	
}
