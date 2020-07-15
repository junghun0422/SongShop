package com.song.shop.dto;

public class ProductDto 
{
	private String category_code;
	private String category_nm;
	private String product_nm;
	private String product_price;
	private String product_img_path;
	private String product_des;
	
	public ProductDto() { }

	public ProductDto(String category_code, String product_nm, String product_price, String product_img_path, String product_des) 
	{
		this.category_code = category_code;
		this.product_nm = product_nm;
		this.product_price = product_price;
		this.product_img_path = product_img_path;
		this.product_des = product_des;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getCategory_nm() {
		return category_nm;
	}

	public void setCategory_nm(String category_nm) {
		this.category_nm = category_nm;
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

	public String getProduct_img_path() {
		return product_img_path;
	}

	public void setProduct_img_path(String product_img_path) {
		this.product_img_path = product_img_path;
	}	

	public String getProduct_des() {
		return product_des;
	}

	public void setProduct_des(String product_des) {
		this.product_des = product_des;
	}
}
