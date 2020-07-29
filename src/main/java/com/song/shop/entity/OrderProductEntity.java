package com.song.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter @Getter
@Table( name = "orderProduct" )
public class OrderProductEntity 
{
	@Id @GeneratedValue
	@Column( name = "order_product_seq" )
	private Long orderProductSeq;

	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "order_seq" )
	private OrderEntity order;
	
	@Column( name = "product_seq" )
	private Long productSeq;
	
	@Column( name = "product_nm" )
	private String productNm;
	
	@Column( name = "order_product_cnt" )
	private int orderProductCnt;
	
	public void setOrder( OrderEntity order )
	{
		this.order = order;
	}
}
