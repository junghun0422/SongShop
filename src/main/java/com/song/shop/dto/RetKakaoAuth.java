package com.song.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class RetKakaoAuth 
{
	private String access_token;
	private String token_type;
	private String refresh_token;
	private long expires_in;
	private String scope;
}
