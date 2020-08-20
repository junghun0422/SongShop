package com.song.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.shop.entity.CategoryEntity;
import com.song.shop.repository.CategoryRepository;
import com.song.shop.repository.querydsl.ProductRepositorySupport;

import io.swagger.annotations.Api;

@Api(tags = "Sample API", description = "샘플 API 가이드")
@RestController
//@RequestMapping("/api/sample")
public class TestController
{
	//@ApiOperation(value = "샘플 리스트", notes = "샘플리스트 API")
	
	@Autowired
	private CategoryRepository categoryRespoitory;
	
	@Autowired
	private ProductRepositorySupport productRepositorySupport;
	
	@GetMapping("/insertCategory")
	public void insertCategory( String category_nm )
	{
		CategoryEntity cate = new CategoryEntity();
		cate.setCategoryNm(category_nm);
		categoryRespoitory.save(cate);
	}
	
	@GetMapping( "/test" )
	public String testApi() 
	{
		return productRepositorySupport.jpqlTest("test");
	}
}