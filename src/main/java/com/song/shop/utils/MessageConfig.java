//package com.song.shop.utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Configuration
//public class MessageConfig 
//{
//	@Bean
//	public ObjectMapper objectMapper()
//	{
//		return new ObjectMapper();
//	}
//	
//	@Bean	// @ResponseBody ������̼ǿ� ���� �Ҹ��� �Ǹ� ObjectMapper�� �̿��ؼ� Java ��ü�� Json ��ü�� ��ȯ
//	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper objectMapper)
//	{
//		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
//		return mappingJackson2HttpMessageConverter;
//		
//	}
//}
