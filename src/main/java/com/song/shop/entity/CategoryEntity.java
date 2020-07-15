package com.song.shop.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Setter @Getter
@Table( name = "Category" )
public class CategoryEntity 
{
	@Id 
	@Column(name = "category_code")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer category_code;
	
	@Column(name = "category_nm", nullable = false)
	private String category_nm;
	
//	@OneToMany( mappedBy = "category", cascade = CascadeType.ALL )
//	private List<ProductEntity> products = new ArrayList<>();
	
	@OneToMany( mappedBy = "category", cascade = CascadeType.ALL )
	private Collection<ProductEntity> products;
	
	
	@Builder
	public CategoryEntity(Integer category_code, String category_nm)
	{
		this.category_code = category_code;
		this.category_nm = category_nm;
	}
	
	public void addProduct(ProductEntity product)
	{
		products.add(product);
		product.setCategory(this);
	}
}

