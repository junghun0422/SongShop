package com.song.shop.dto;

public class CategoryDto 
{
	private Integer categoryCode;
	private String categoryNm;
	
	public CategoryDto() { }
	
	public CategoryDto(Integer categoryCode, String categoryNm) 
	{
		this.categoryCode = categoryCode;
		this.categoryNm = categoryNm;
	}

	public Integer getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(Integer categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryNm() {
		return categoryNm;
	}

	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}
}
