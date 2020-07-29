package com.song.shop.repository.querydsl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.shop.entity.OrderEntity;
import com.song.shop.entity.QOrderEntity;
import com.song.shop.entity.QProductEntity;

@Repository
public class OrderRepositorySupport extends QuerydslRepositorySupport 
{
	private static Logger log = LoggerFactory.getLogger(OrderRepositorySupport.class);
	
	@Autowired
	private JPAQueryFactory query;
	
	public OrderRepositorySupport(JPAQueryFactory query)
	{
		super(OrderEntity.class);
		this.query = query;
	}
	
	public List<OrderEntity> orderListByCustomerId(String customerId)
	{
		QOrderEntity order = QOrderEntity.orderEntity;
		QProductEntity product = QProductEntity.productEntity;
		
		return query
				.selectFrom( order )
				.leftJoin( product.order, order )
				.where( order.customerId.eq( customerId ) )
				.groupBy( order.orderSeq )
				.fetch();
	}
}
