package com.song.shop;

import java.io.IOException;

import javax.sql.DataSource;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;

import com.song.shop.utils.GoDataUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.song.shop.mapper")
public class SongShoppingMallApplication // extends SpringBootServletInitializer
{
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
//	{
//		return application.sources(SongShoppingMallApplication.class);
//	}
//	
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException 
	{
		//GoDataUtils.returnGoData();
		SpringApplication.run(SongShoppingMallApplication.class, args);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception
	{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setTypeAliasesPackage("com.song.shop.mapper");
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
		return sessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory)
	{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
}
