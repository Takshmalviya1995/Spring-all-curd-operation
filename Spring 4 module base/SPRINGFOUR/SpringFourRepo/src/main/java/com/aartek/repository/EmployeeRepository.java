package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.Employee;

@Repository
public class EmployeeRepository {
	@Autowired
	//private HibernateTemplate hibernatetemplate;
	private HibernateTemplate hibernatetemplate;
	@Transactional(readOnly=false)
	public void checkEmployee(Employee emp)
	{
		System.out.println("inside employee Repository");
		/*System.out.println("save : values");
		System.out.println(emp.getId());
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		System.out.println(emp.getEmail());
		System.out.println(emp.getDept());
		System.out.println(emp.getAddress());
		System.out.println(emp.getMobile());*/
		hibernatetemplate.save(emp);
	}
	
	public List getEmployeeDetails(Employee empl)
	{
		System.out.println("inside getEmployeeDetails");
		List list = hibernatetemplate.find("from Employee");
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			Employee employee = (Employee)itr.next();
			System.out.println(empl.getFirstName()+" "+empl.getLastName()+" "+empl.getDept()+" "+empl.getAddress()+" "+empl.getAddress()+" "+empl.getMobile());
		}
		return list;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void deleteEmployee(Integer eid)
	{
		System.out.println("Employee Repository : deleteEmployee");
		List list1 = hibernatetemplate.find("from Employee e where e.id = ?",eid);
		Iterator<Employee> itr1 = list1.iterator();
		while(itr1.hasNext())
		{
			Employee employee1 = (Employee)itr1.next();
			System.out.println(employee1.getFirstName()+" "+employee1.getLastName()+" "+employee1.getDept()+" "+employee1.getAddress()+" "+employee1.getAddress()+" "+employee1.getMobile());
			hibernatetemplate.delete(employee1);
			
		}	
		System.out.println("Delete Successfully");
		
	}
	
	public Employee editEmployeeDetails(Integer eid)
	{
		System.out.println("inside EditEmployeeDetails");
		List list = hibernatetemplate.find("from Employee e where e.id = ?",eid);
		Iterator itr = list.iterator();
		Employee empl = null;
		while(itr.hasNext())
		{
			empl = (Employee)itr.next();
			System.out.println(empl.getFirstName()+" "+empl.getLastName()+" "+empl.getDept()+" "+empl.getAddress()+" "+empl.getAddress()+" "+empl.getMobile());
		}
		return empl;
	}
	
	@Transactional(readOnly=false)
	public void updateEmployee(Employee emp)
	{
		System.out.println("inside employeeRepository : updateEmployee");
		
		hibernatetemplate.update(emp);
	}
}
