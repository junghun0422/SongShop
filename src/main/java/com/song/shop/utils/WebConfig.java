package com.song.shop.utils;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
	@Bean
	public HttpMessageConverters customConverter()
	{
		GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
		return new HttpMessageConverters(converter);
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource()
	{
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		
		// 메세지 프로퍼티파일의 위치화 이름을 저장
		source.setBasename("classpath:/messages/message");
		
		// 기본 인코딩
		source.setDefaultEncoding("UTF-8");
		
		// 프로퍼티 파일의 변경을 감지할 시간 간격
		source.setCacheSeconds(60);
		
		// 없는 메세지일 경우 예외를 발생시키는 대신 코드를 기본 메세지로 
		source.setUseCodeAsDefaultMessage(true);
		
		return source;
	}
	
	
	@Bean	// 변경된 언어 정보를 기억할 로케일 리졸버 생성. 세션에 저장하는 방식 사용
	public SessionLocaleResolver localeResolver()
	{
		return new SessionLocaleResolver();
	}
	
	@Bean	// 언어 변경을 위한 인터셉터 생성
	public LocaleChangeInterceptor localeChangeInterceptor()
	{
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	@Override	// 인터셉터 등록
	public void addInterceptors(InterceptorRegistry registry) 
	{
		//WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(localeChangeInterceptor());
	}
}
