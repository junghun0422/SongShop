package com.song.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/goProduct")
	public String goProductPage(Model model, Authentication auth)
	{
		String authInfo = auth.getAuthorities().toString();
		String authName = auth.getName();
		
		
		
		//model.addAttribute("list", null);
		return "seller/seller_product";
	}
}
