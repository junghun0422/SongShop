package com.song.shop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.song.shop.security.AuthFailureHandler;
import com.song.shop.security.AuthProvider;
import com.song.shop.security.AuthSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	AuthProvider authProvider;
	
	@Override
	public void configure(WebSecurity web) throws Exception 
	{
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		web.ignoring().antMatchers("/css/**", "/images/**", "/lib/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()
				.antMatchers("/admin/**").access("ROLE_ADMIN")
				.antMatchers("/seller/**").access("ROLE_SELLER")
				.antMatchers("/consumer/**").access("ROLE_CONSUMER")
				.antMatchers("/", "/login", "/login-error", "/join-member", "/join/*").permitAll()
				.antMatchers("/**").authenticated();

		// 로그인
		http.formLogin()
			.loginPage("/")
			.loginProcessingUrl("/login-processing")
			.failureUrl("/login-error")
			.usernameParameter("user_id")
			.passwordParameter("password")
			.successHandler(new AuthSuccessHandler())
			.failureHandler(new AuthFailureHandler());
		
		// 로그아웃
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);
		
		http.authenticationProvider(authProvider);
	}
}
