package com.song.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.song.shop.dto.ProductDto;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/goProduct")
	public ModelAndView goProductPage(Model model, Authentication auth)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("userInfo", SecurityContextHolder.getContext().getAuthentication().getName());
		mv.setViewName("seller/seller_product");
		return mv;
	}
	
	@PostMapping(value = "/product_list/{registerId}")
	public @ResponseBody List<ProductDto> searchProductListByRegisterId(HttpServletRequest request, @PathVariable(value="registerId") String registerId)
	{
		List<ProductDto> list = new ArrayList<>();
		
		log.debug("!!!!!!!!!!!!!!!!!!!!!!!");
		log.debug(registerId);
		log.debug(request.getRequestURI());
		log.debug(request.getRequestURL().toString());
		log.debug("!!!!!!!!!!!!!!!!!!!!!!!");
		
		return list;
	}
}
