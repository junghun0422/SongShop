package com.song.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.song.shop.dto.ProductDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/restapi")
public class RestTestController 
{
	private static final Logger log = LoggerFactory.getLogger(RestTestController.class);
	
//	@PostMapping(value = "/product_list/{registerId}")
//	public @ResponseBody List<ProductDto> searchProductListByRegisterId(HttpServletRequest request, @PathVariable(value="registerId") String registerId)
//	{
//		List<ProductDto> list = new ArrayList<>();
//		
//		log.debug("!!!!!!!!!!!!!!!!!!!!!!!");
//		log.debug(registerId);
//		log.debug(request.getRequestURI());
//		log.debug(request.getRequestURL().toString());
//		log.debug("!!!!!!!!!!!!!!!!!!!!!!!");
//		
//		return list;
//	}
}
