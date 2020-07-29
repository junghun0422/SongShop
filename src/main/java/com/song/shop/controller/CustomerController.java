package com.song.shop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.song.shop.entity.OrderEntity;
import com.song.shop.service.OrderService;
import com.song.shop.utils.CyResult;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{	
	private static Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private OrderService orderService;
	
	@ApiOperation( value = "주문조회", notes = "로그인 사용자별 주문조회" )
//	@PostMapping("/orderListByCustomerId")
//	@RequestMapping( value = "/orderListByCustomerId", method = { RequestMethod.GET, RequestMethod.POST } )
	@GetMapping("/order")
	public CyResult<List<OrderEntity>> orderListByCustomerId( Authentication auth )
	{
		log.debug(" [ orderListByCustomerId ] . . . . ");
		return orderService.orderListByCustomerId( auth );
	}
}
