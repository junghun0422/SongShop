package com.song.shop.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.song.shop.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	private UserService userService;
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

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
				// ������ ���� ����
				//.antMatchers("/member/**").hasRole("MEMBER")
				//.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/").permitAll();
//			.and()	// �α��� ����
//				.formLogin()
//				.loginPage("/")
//				.defaultSuccessUrl("/member/login/result")
//				.permitAll()
//			.and()	// �α׾ƿ� ����
//				.logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
//				.logoutSuccessUrl("/member/logout/result")
//				.invalidateHttpSession(true)
//			.and()	// 403 ����ó�� �ڵ鸵
//				.exceptionHandling().accessDeniedPage("/member/denied");
//				
				
				
//				.anyRequest().authenticated()
//				.and().logout().permitAll()
//				.and().formLogin()
//				.and().csrf().disable();
				
//			.and()
//				.formLogin()
//				.loginPage("/")
//				.permitAll()
//			.and()
//				.logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher(""))
//				.logoutSuccessUrl("")
//				.invalidateHttpSession(true)
//			.and()
//				.exceptionHandling().accessDeniedPage("/denied");
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
//	{
//		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//	}
}
