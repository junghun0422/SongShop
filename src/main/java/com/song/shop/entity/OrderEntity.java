package com.song.shop.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Setter @Getter
@Table( name = "Order" )
@ToString( exclude = { "orderAmountList" } )
public class OrderEntity 
{
	@Id @GeneratedValue
	@Column( name = "order_seq" )
	private Long orderSeq;
	
	@Column( name = "customer_id", nullable = false )
	private String customerId;
	
	@Column( name = "total_price", nullable = false )
	private int totalPrice;
	
	@Column( name = "order_date_time", nullable = false )
	private Timestamp orderDateTime;

	@Builder
	public OrderEntity( String customerId, int totalPrice, Timestamp orderDateTime ) 
	{
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.orderDateTime = orderDateTime;
	}

	
	@Override
	public String toString() 
	{
		return ToStringBuilder
				.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
