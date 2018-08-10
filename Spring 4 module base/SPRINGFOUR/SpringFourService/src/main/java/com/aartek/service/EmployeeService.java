package com.aartek.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.Employee;
import com.aartek.repository.EmployeeRepository;
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeerepository;
	public String checkEmployee(Employee emp)
	{
		System.out.println("inside employee Service");
		employeerepository.checkEmployee(emp);
		return "hello";
	}
	
	public List getEmployeeDetails(Employee empl)
	{
		List list = employeerepository.getEmployeeDetails(empl);
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			Employee product = (Employee)itr.next();
			System.out.println(empl.getFirstName()+" "+empl.getLastName());
		}
		return list;
	}
	
	//@Transactional(isolation=Isolation.READ_COMMITTED)
	public void deleteEmployeeService(Integer id)
	{
		System.out.println("Employee Service : deleteEmployeeService");
		employeerepository.deleteEmployee(id);
	}
	
	public Employee editEmployeeDetails(Integer eid)
	{
			System.out.println("Employee Service : editEmployeeDetails");
		return  employeerepository.editEmployeeDetails(eid);
	}
	
	public String updateEmployee(Employee emp)
	{
		System.out.println("inside employeeService : updateEmployee");
		employeerepository.updateEmployee(emp);
		return "hello";
	}
}
