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
//	@Bean	// @ResponseBody 어노테이션에 의해 불리게 되면 ObjectMapper를 이용해서 Java 객체를 Json 객체로 변환
//	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper objectMapper)
//	{
//		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
//		return mappingJackson2HttpMessageConverter;
//		
//	}
//}
