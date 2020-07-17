package com.song.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.song.shop.dto.CategoryDto;
import com.song.shop.dto.ProductDto;
import com.song.shop.entity.CategoryEntity;
import com.song.shop.entity.ProductEntity;
import com.song.shop.repository.querydsl.ProductRepositorySupport;
import com.song.shop.service.ProductService;
import com.song.shop.utils.CyResult;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepositorySupport productRepositorySupport;
	
	@ApiOperation( "상품목록 페이지 이동" )
	@GetMapping( "/goProduct" )
	public ModelAndView goProductPage( Model model, Authentication auth )
	{
		log.debug(" [ goProduct ] . . . . ");
		ModelAndView mv = new ModelAndView();
		
		ModelMapper mapper = new ModelMapper();
		List<ProductDto> list = new ArrayList<>();
		productRepositorySupport.findByRegisterId( SecurityContextHolder.getContext().getAuthentication().getName() ).forEach( e -> list.add( mapper.map( e, ProductDto.class ) ) );
		
		mv.addObject( "userInfo", SecurityContextHolder.getContext().getAuthentication().getName() );
		mv.addObject( "productList", list );
		mv.setViewName( "seller/seller_product" );
		
		return mv;
	}
	
	@ApiOperation( "카테고리 목록 조회" )
	@PostMapping( value = "/searchCategoryList" )
	public @ResponseBody CyResult<List<CategoryDto>> searchCategoryList()
	{
		log.debug(" [ searchCategoryList ] . . . . ");
		return productService.searchCategoryList();
	}
	
	@ApiOperation( "사용자별 상품 조회" )
	@PostMapping( value = "/product_list/{registerId}" )
	public @ResponseBody CyResult<List<ProductDto>> searchProductListByRegisterId( @PathVariable( value="registerId" ) String registerId )
	{
		log.debug(" [ product_list ] . . . . ");
		return productService.searchProductListByRegisterId(registerId);
	}
	
	@ApiOperation( "TEST 상품 조회" )
	@PostMapping( value = "/testList/{registerId}" )
	public @ResponseBody ResponseEntity<List<ProductDto>> repositoryProductList( @PathVariable( value="registerId" ) String registerId )
	{
		log.debug(" [ product_list ] . . . . ");
		return productService.repositoryProductList( registerId );
	}
}
