package com.aartek.repository;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.Product;
import com.aartek.model.User;

@Repository
@Transactional
public class UserRepository {

	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	final static Logger logger = Logger.getLogger(UserRepository.class);
	public String checkUser(User user)
	{
		logger.debug("Inside Repository : checkUser");
		
		logger.debug(user.getEmail());
		logger.debug(user.getPassword());
		hibernatetemplate.save(user);
		return "user";
	}
	public List getUserDetails(User user)
	{
		logger.debug("Inside Repository : getUserDetails");
		List list = hibernatetemplate.find("from User");
		Iterator itr = list.iterator();
		while (itr.hasNext())
		{
			User use = (User)itr.next();
			logger.debug(use.getEmail());
			logger.debug(use.getPassword());
		}
		return list; 	
	}
	public User editUser(Integer eid)
	{
		logger.debug("Inside Repository : editUser");
		List list = hibernatetemplate.find("from User u where u.id =?",eid);
		Iterator itr = list.iterator();
		User use = null;
		while (itr.hasNext())
		{
			use = (User)itr.next();
			logger.debug(use.getEmail());
			logger.debug(use.getPassword());
		}
		return use;
	}

	@Transactional(readOnly=false)
	public void updateUser(User use)
	{
		logger.debug("Inside employeeRepository : updateUser");
		hibernatetemplate.update(use);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED)
	public User deleteUser(Integer eid)
	{
		System.out.println("User Repository : deleteUser");
		List list1 = hibernatetemplate.find("from User u where u.id = ?",eid);
		User use=null;
		Iterator<User> itr1 = list1.iterator();
		while(itr1.hasNext())
		{
			 use = (User)itr1.next();
			//System.out.println(employee1.getFirstName()+" "+employee1.getLastName()+" "+employee1.getDept()+" "+employee1.getAddress()+" "+employee1.getAddress()+" "+employee1.getMobile());
			hibernatetemplate.delete(use);
		}	
		System.out.println("Delete Successfully");
		return use;
	}
	public User checkLogin(User user)
	{
		
		List<User> list = (List<User>) hibernatetemplate.find("from User u where u.email=? and u.password=?",user.getEmail(),user.getPassword());
		Iterator<User> itr = list.iterator();
		User use = null;
		while(itr.hasNext())
		{
			use=(User)itr.next();
			System.out.println(use.getEmail()+"....."+use.getPassword());
		}
		return use;	
	}
	
	
	public String addProduct(Product product)
	{
		logger.debug("Inside Repository : addProduct");
		
		logger.debug(product.getProdname());
		logger.debug(product.getProdqty());
		hibernatetemplate.save(product);
		return "product";
	}
	
	public List getProductDetails(Product product)
	{
		logger.debug("Inside Repository : getProductDetails");
		List list = hibernatetemplate.find("from Product");
		Iterator itr = list.iterator();
		while (itr.hasNext())
		{
			Product pro = (Product)itr.next();
			logger.debug(pro.getProdname());
			logger.debug(pro.getProdprice());
		}
		return list; 	
	}
	
	public Product editProduct(Integer eid)
	{
		logger.debug("Inside Repository : editProduct");
		List<Product> list = (List<Product>) hibernatetemplate.find("from Product p where p.prodid= ?",eid);
		Iterator<Product> itr = list.iterator();
		Product prod = null;
		while(itr.hasNext())
		{
			prod = (Product)itr.next();
			logger.debug(prod.getProdname());
			logger.debug(prod.getProdprice());
		}
		return prod;	
	}
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void updateProduct(Product prod)
	{
		logger.debug("Inside Repository : updateProduct");
		logger.info(prod.getProdid());
		logger.info(prod.getProdname());
		
		hibernatetemplate.update(prod);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED)	
	public Product deleteProduct(Integer eid)
	{
		logger.debug("Inside Repository : deleteProduct");
		Product prod = editProduct(eid);
		hibernatetemplate.delete(prod);
		return prod;
	}
}
