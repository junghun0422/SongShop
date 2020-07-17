package com.song.shop.dto;

public class ProductDto 
{
	private String categoryCode;
	private String categoryNm;
	private String productNm;
	private String productPrice;
	private String productImgPath;
	private String productDes;
	
	public ProductDto() { }

	public ProductDto(String categoryCode, String categoryNm, String productNm, String productPrice, String productImgPath, String productDes) 
	{
		this.categoryCode = categoryCode;
		this.categoryNm = categoryNm;
		this.productNm = productNm;
		this.productPrice = productPrice;
		this.productImgPath = productImgPath;
		this.productDes = productDes;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryNm() {
		return categoryNm;
	}

	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}

	public String getProductNm() {
		return productNm;
	}

	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImgPath() {
		return productImgPath;
	}

	public void setProductImgPath(String productImgPath) {
		this.productImgPath = productImgPath;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}
}
