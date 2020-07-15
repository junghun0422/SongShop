package com.song.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter @Setter
@Table(name = "Product")
public class ProductEntity 
{
	@Id
	@Column( name = "product_seq" )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int product_seq;
	
	@Column( name = "product_nm", nullable = false )
	private String product_nm;
	
	@Column( name = "product_price", nullable = false )
	private String product_price;
	
	@Column( name = "product_img_path", nullable = false )
	private String product_img_path;
	
//	@Column( name = "product_order_nm", nullable = false )
//	private int product_order_nm;
	
	@Column( name = "product_des", nullable = false )
	private String product_des;
	
	@Column( name = "register_id", nullable = false )
	private String register_id;
	

//	@ManyToOne
//	@JoinColumn( name = "category_code", foreignKey = @ForeignKey( name = "fk_product_category_code" ))
//	private CategoryEntity category;
	
	@ManyToOne
	@JoinColumn( name = "category_code" )
	private CategoryEntity category;
	
	@Builder
	public ProductEntity(String product_nm, String product_price, String product_img_path, String product_des, String register_id)
	{
		this.product_nm = product_nm;
		this.product_price = product_price;
		this.product_img_path = product_img_path;
		this.product_des = product_des;
		this.register_id = register_id;
	}
	
	public void setCategory(CategoryEntity category)
	{
		this.category = category;
	}
}
