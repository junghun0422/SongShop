package com.song.shop.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.song.shop.entity.OrderEntity;
import com.song.shop.utils.CyResult;

public interface OrderService 
{ 
	CyResult<List<OrderEntity>> orderListByCustomerId(Authentication auth);
}

