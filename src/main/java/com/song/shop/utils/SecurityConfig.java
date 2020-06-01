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
		// static ���͸��� ���� ���� ����� ���� ���� ( = �׻���� )
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

		// �α���
		http.formLogin()
			.loginPage("/")
			.loginProcessingUrl("/login-processing")
			.failureUrl("/login-error")
			.usernameParameter("user_id")
			.passwordParameter("password")
			.successHandler(new AuthSuccessHandler())
			.failureHandler(new AuthFailureHandler());
		
		// �α׾ƿ�
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);
		
		http.authenticationProvider(authProvider);
	}
}
