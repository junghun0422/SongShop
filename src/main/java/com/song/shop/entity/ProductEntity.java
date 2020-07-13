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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Product")
public class ProductEntity 
{
	@Id
	@Column(name = "product_seq")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int product_seq;
	
	@Column(name = "product_nm", nullable = false)
	private String product_nm;
	
	@Column(name = "product_price", nullable = false)
	private String product_price;
	
	@Column(name = "product_img_path", nullable = false)
	private String product_img_path;
	
	@Column(name = "product_order_nm", nullable = false)
	private int product_order_nm;
	
	@Column(name = "product_describe", nullable = false)
	private String product_describe;
	
	@Column(name = "registor_id", nullable = false)
	private String registor_id;
	
//	@Column(name = "category_seq", nullable = false)
//	private int category_seq;
//	
//	@Column(name = "category_nm", nullable = false)
//	private String category_nm;
	
//	@ManyToOne( fetch = FetchType.LAZY )
//	@JoinColumn( name = "category_no", foreignKey = @ForeignKey( name = "fk_product_category" ))
//	private CategoryEntity category;
	
	@ManyToOne
	@JoinColumn( name = "category_seq", foreignKey = @ForeignKey( name = "fk_product_category_seq" ))
	private CategoryEntity category;
}
