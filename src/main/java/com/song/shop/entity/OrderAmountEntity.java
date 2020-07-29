//package com.song.shop.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.apache.commons.lang3.builder.ToStringStyle;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@NoArgsConstructor
//@Setter @Getter
//@Table( name = "OrderAmount" )
//@ToString( exclude = { "order" } )
//public class OrderAmountEntity 
//{
//	@Id @GeneratedValue
//	@Column( name = "order_amount_seq" )
//	private Long orderAmountSeq;
//
//	@Column( name = "category_code", nullable = false )
//	private Long categoryCode;
//
//	@ManyToOne( fetch = FetchType.LAZY )
//	@JoinColumn( name = "order_seq" )
//	private OrderEntity order;
//	
////	@OneToMany
////	private List<ProductEntity> products = new ArrayList<>();
//
//	@Override
//	public String toString() 
//	{
//		return ToStringBuilder
//				.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
//	}
//}
