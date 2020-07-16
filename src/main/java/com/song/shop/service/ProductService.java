package com.song.shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.song.shop.dto.CategoryDto;
import com.song.shop.dto.ProductDto;
import com.song.shop.entity.CategoryEntity;
import com.song.shop.entity.ProductEntity;
import com.song.shop.utils.CyResult;

public interface ProductService 
{
	CyResult<String> registProduct(Authentication auth, HttpServletRequest request, HttpServletResponse response, ProductDto productDto, MultipartFile product_img);
	
	CyResult<List<CategoryDto>> searchCategoryList();
	
	CyResult<List<ProductDto>> searchProductListByRegisterId( String registerId );
	
	CyResult<List<ProductEntity>> testProductListByRegisterId( String registerId );
}
