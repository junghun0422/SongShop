package com.song.shop.service;

import com.song.shop.dto.KakaoProfile;
import com.song.shop.dto.RetKakaoAuth;

public interface KakaoService 
{
	KakaoProfile getKakaoProfile( String accessToken );
	
	public RetKakaoAuth getKakaoTokenInfo( String code );
}
