package com.song.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.song.shop.dto.ProductDto;
import com.song.shop.service.ProductService;
import com.song.shop.utils.CyResult;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerController 
{
	private static Logger log = LoggerFactory.getLogger(SellerController.class);
	
	@Autowired
	private ProductService productService;
	
	@ApiOperation("상품등록")
	@RequestMapping(value = "/registProduct", headers = "Content-Type=multipart/form-data", method = RequestMethod.POST)
	public @ResponseBody CyResult<String> registProduct(Authentication auth, HttpServletRequest request, HttpServletResponse response, ProductDto productDto, MultipartFile product_img)
	{
		return productService.registProduct(auth, request, response, productDto, product_img);
	}
}
