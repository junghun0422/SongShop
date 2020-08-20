package com.song.shop.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role 
{
	ADMIN( "ROLE_ADMIn", "관리자" ),
	SELLER( "ROLE_SELLER", "판매자" ),
	CUSTOMER( "ROLW_CUSTOMER", "고객" );
	
	private final String key;
	private final String title;
}
