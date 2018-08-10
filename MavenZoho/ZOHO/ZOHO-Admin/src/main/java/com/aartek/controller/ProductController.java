package com.aartek.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.validator.ProductValidator;
import com.aartek.model.Products;
import com.aartek.service.ProductService;



@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductValidator productValidator;

	@RequestMapping(value = "/product", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveProduct(@ModelAttribute("prodMap") Products prod, BindingResult result, Map<String, Object> map,
			HttpServletRequest request) {
		System.out.println("Inside Controller");
		map.put("prodList", productService.getProductDetails(prod));
		if ("post".equals(request.getMethod().toLowerCase()))
		{
			productValidator.validate(prod, result);
			if (result.hasErrors()) 
			{
				return "product";
			} else 
			{
				productService.checkProduct(prod);
				map.put("prodList", productService.getProductDetails(prod));
				return "product";
			}
		}
		map.put("prodMap", prod);
		map.put("prodList", productService.getProductDetails(prod));
		return "product";
	}
}