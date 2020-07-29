package com.song.shop.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.song.shop.entity.OrderEntity;
import com.song.shop.repository.querydsl.OrderRepositorySupport;
import com.song.shop.service.OrderService;
import com.song.shop.utils.CyResult;

@Service
public class OrderServiceImpl implements OrderService
{
	private static Logger log = LoggerFactory.getLogger( OrderServiceImpl.class );

	@Autowired
	private OrderRepositorySupport orderRepositorySupport;

	@Override
	public CyResult<List<OrderEntity>> orderListByCustomerId( Authentication auth ) 
	{
		CyResult<List<OrderEntity>> result = new CyResult<>();
		
		List<OrderEntity> orderList = orderRepositorySupport.orderListByCustomerId( auth.getName() ); 
		return result;
	}
	
}
