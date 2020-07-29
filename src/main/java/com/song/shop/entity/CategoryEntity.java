package com.song.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Entity
@Setter @Getter 
@Table( name = "Category" )
@ToString( exclude = { "products" } )
public class CategoryEntity
{
	@Id @GeneratedValue 
	@Column(name = "category_code")
	private Long categoryCode;
	
	@Column(name = "category_nm", nullable = false)
	private String categoryNm;
	
	@OneToMany( mappedBy = "category" )
	@JsonManagedReference
	private List<ProductEntity> products = new ArrayList<>();
	
	@Builder
	public CategoryEntity(Long categoryCode, String categoryNm)
	{
		this.categoryCode = categoryCode;
		this.categoryNm = categoryNm;
	}
	
	public void addProduct( ProductEntity product )
	{
		if( product.getCategory() != this )
		{
			product.setCategory(this);
		}

		this.products.add( product );

//		product.setCategory(this);
//		products.add(product);
	}
	
	 @Override
	 public String toString() 
	 {
		 return ToStringBuilder
				 .reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	 }
}

