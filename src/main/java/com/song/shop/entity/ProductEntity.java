package com.song.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Entity
@Getter @Setter
@Table( name = "Product" )
@NamedQuery( 
		name = "ProductEntity.searchProductListByRegisterId",
		query = "SELECT p FROM ProductEntity p join fetch p.category WHERE p.registerId = :registerId" )
@ToString( exclude = { "category" } )
public class ProductEntity
{
	@Id @GeneratedValue
	@Column( name = "product_seq" )
	private Long productSeq;
	
	@Column( name = "product_nm", nullable = false )
	private String productNm;
	
	@Column( name = "product_price", nullable = false )
	private String productPrice;
	
	@Column( name = "product_img_path", nullable = false )
	private String productImgPath;

	@Column( name = "product_des", nullable = false )
	private String productDes;
	
	@Column( name = "product_amount", nullable = false )
	private int productAmount;
	
	@Column( name = "register_id", nullable = false )
	private String registerId;

	@ManyToOne( fetch = FetchType.LAZY ) // 지연로딩
	@JoinColumn( name = "category_code" )
	@JsonBackReference
	private CategoryEntity category;
	
//	@ManyToOne( fetch = FetchType.LAZY )
//	@JoinColumn( name = "order_seq" )
//	@JsonBackReference
//	private OrderEntity order;
	
	@Builder
	public ProductEntity( String productNm, String productPrice, String productImgPath, String productDes, int productAmount, String registerId )
	{
		this.productNm = productNm;
		this.productPrice = productPrice;
		this.productImgPath = productImgPath;
		this.productDes = productDes;
		this.productAmount = productAmount;
		this.registerId = registerId;
	}
	
	public void setCategory(CategoryEntity category)
	{
		this.category = category;
	}
	
//	public void setOrder(OrderEntity order)
//	{
//		this.order = order;
//	}
	
	 @Override
	 public String toString() 
	 {
		 return ToStringBuilder
				 .reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	 }
}
