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
@MapperScan( basePackages = "com.song.shop.mapper" )
public class SongShoppingMallApplication
{
	public static void main( String[] args ) throws IOException, SAXException, ParserConfigurationException { SpringApplication.run( SongShoppingMallApplication.class, args ); }
	
	// @Bean 의 경우 개발자가 컨트롤리 불가능한 외부라이브러리들을 Bean으로 등록하고 싶은 경우 사용.
	// @Component 의 경우 개발자가 직접 컨트롤이 가능한 class
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception
	{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource( dataSource );
		sessionFactory.setTypeAliasesPackage( "com.song.shop.mapper" );
		sessionFactory.setMapperLocations( new PathMatchingResourcePatternResolver().getResources( "classpath:mybatis/*.xml" ) );
		return sessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession( SqlSessionFactory sqlSessionFactory )
	{
		return new SqlSessionTemplate( sqlSessionFactory );
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
