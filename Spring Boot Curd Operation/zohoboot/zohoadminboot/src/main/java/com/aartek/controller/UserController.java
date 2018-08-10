package com.aartek.controller;




import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aartek.model.Product;
import com.aartek.model.User;
import com.aartek.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String showIndex()
	{
		return "index";
	}
	

	final static Logger logger = Logger.getLogger(UserController.class);
	@RequestMapping(value="/user", method=RequestMethod.GET)
	   public String showUser(Model model){
		logger.info("Inside controller");
		   logger.info("Inside controller : showUser");
		   model.addAttribute("userMap", new User());
		   return "user";
	   }
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	  public String signInAction(@ModelAttribute("userMap")User user)
	  {
		logger.info("Inside Controller : SignIn Action"); 
		userservice.checkUser(user);
		return "login";  
	  }
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getUserDetails(@ModelAttribute("userMap") User user ,Map<String, Object> map)
	{
		logger.info("Inside user Controller : getUserDetails");
		map.put("userList", userservice.getUserDetails(user));
		logger.info(user.getEmail());
		logger.info(user.getPassword());  
		
		return "allusers";	
	}
	@RequestMapping(value= "/edit-{id}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable Integer id,Model model)
	{
		logger.info("Inside user Controller : ModelAndView edit");
		User use = userservice.editUser(id);
		model.addAttribute("user", use);
		return new ModelAndView("update","command",use);
	}
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User use)
	{
		logger.info("Inside user Controller  : updateUser Post");
		userservice.updateUser(use);
		return "allusers";	
	}
	@RequestMapping(value="/delete-{id}", method=RequestMethod.GET)
	 public String deleteUser(@PathVariable Integer id,Map<String, Object> map)
	 {
		 logger.info("Inside user Controller : deleteUser");
		 logger.info("Employ ID: "+id);
		 User user = userservice.deleteUser(id);
		 
		 map.put("userList", userservice.getUserDetails(user));
		 return "allusers";
	 }
	@GetMapping("/login")
	public String userLogin(Model model)
	{
		 logger.info("Inside user Controller : userLogin Get");
		model.addAttribute("userMap", new User());
		return "login";
	}
	@PostMapping("/login")
	public String userLogin(@ModelAttribute("userMap")User user)
	{
		System.out.println("Inside user Controller : userLogin Post");
		boolean status=userservice.checkLogin(user);
		if(status==true)
		{
			return "redirect:/product";
		}
		else 
		{
			return "login";
		}
	}
	@GetMapping("/product")
	public String addProductGet(Model model,Product product)
	{
		 logger.info("Inside user Controller : addProductGet");
		 model.addAttribute("product", new Product());
		 model.addAttribute("prodList",userservice.getProductDetails(product));
		 return "product";
	}
	@PostMapping("/productAction")
	public String addProductPost(@ModelAttribute("product")Product product,Model model)
	{
		logger.info("Inside Controller : addProductPost"); 
		logger.info(product.getProdname());
		userservice.addProduct(product);
		model.addAttribute("prodList",userservice.getProductDetails(product));
		return "product";  
	}
	
	@RequestMapping(value= "/prodedit-{id}",method=RequestMethod.GET)
	public String prodEdit(@PathVariable Integer id,Model model)
	{
		logger.info("Inside user Controller : ModelAndView prodEdit");
		Product prod = userservice.editProduct(id);
		model.addAttribute("product", prod);
		return "updateproduct"; 
		//return new ModelAndView("updateproduct","command",prod);
	}
	@RequestMapping(value="/editprod", method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product prod,Model model)
	{
		logger.info("Inside user Controller  : updateProduct Post");
		logger.info(prod.getProdid());
		logger.info(prod.getProdname());
		userservice.updateProduct(prod);
		//model.addAttribute("prodList",userservice.getProductDetails(prod));
		return "redirect:/product";	
	}
	
	@RequestMapping(value="/proddelete-{id}", method=RequestMethod.GET)
	 public String deleteProduct(@PathVariable Integer id,Map<String, Object> map)
	 {
		 logger.info("Inside user Controller : deleteProduct");
		 logger.info("Product ID: "+id);
		 Product prod = userservice.deleteProduct(id);
		 
		// map.put("prodList", userservice.getProductDetails(prod));
		 return "redirect:/product";
	 }
}

