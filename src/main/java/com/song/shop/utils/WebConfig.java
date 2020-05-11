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
		
		// �޼��� ������Ƽ������ ��ġȭ �̸��� ����
		source.setBasename("classpath:/messages/message");
		
		// �⺻ ���ڵ�
		source.setDefaultEncoding("UTF-8");
		
		// ������Ƽ ������ ������ ������ �ð� ����
		source.setCacheSeconds(60);
		
		// ���� �޼����� ��� ���ܸ� �߻���Ű�� ��� �ڵ带 �⺻ �޼����� 
		source.setUseCodeAsDefaultMessage(true);
		
		return source;
	}
	
	
	@Bean	// ����� ��� ������ ����� ������ ������ ����. ���ǿ� �����ϴ� ��� ���
	public SessionLocaleResolver localeResolver()
	{
		return new SessionLocaleResolver();
	}
	
	@Bean	// ��� ������ ���� ���ͼ��� ����
	public LocaleChangeInterceptor localeChangeInterceptor()
	{
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	@Override	// ���ͼ��� ���
	public void addInterceptors(InterceptorRegistry registry) 
	{
		//WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(localeChangeInterceptor());
	}
}
