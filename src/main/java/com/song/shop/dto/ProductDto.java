package com.song.shop.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto 
{
	private String category_code;
	private String product_nm;
	private String product_price;
	private MultipartFile product_img;
	private String product_des;
	
	public ProductDto() { }

	public ProductDto(String category_code, String product_nm, String product_price, MultipartFile product_img, String product_des) 
	{
		this.category_code = category_code;
		this.product_nm = product_nm;
		this.product_price = product_price;
		this.product_img = product_img;
		this.product_des = product_des;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getProduct_nm() {
		return product_nm;
	}

	public void setProduct_nm(String product_nm) {
		this.product_nm = product_nm;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public MultipartFile getProduct_img() {
		return product_img;
	}

	public void setProduct_img(MultipartFile product_img) {
		this.product_img = product_img;
	}

	public String getProduct_des() {
		return product_des;
	}

	public void setProduct_des(String product_des) {
		this.product_des = product_des;
	}
}
