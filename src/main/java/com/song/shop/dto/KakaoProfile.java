package com.song.shop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class KakaoProfile 
{
	private Long id;
	private Properties properties;
	
	@Setter @Getter
	@ToString
	private static class Properties 
	{
		private String nickname;
		private String thumbnail_image;
		private String profile_image;
	}
}
