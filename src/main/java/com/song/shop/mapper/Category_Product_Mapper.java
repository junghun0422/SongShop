package com.song.shop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.song.shop.dto.ProductDto;

@Repository("categoryProductMapper")
public interface Category_Product_Mapper 
{
	List<ProductDto> searchProductListByRegisterId(String registerId);
}
