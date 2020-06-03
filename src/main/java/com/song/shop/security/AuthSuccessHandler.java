package com.song.shop.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthSuccessHandler implements AuthenticationSuccessHandler
{
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException 
	{
		System.out.println("onAuthenticationSuccess :: " + authentication.getName());
		
		request.getSession().setMaxInactiveInterval(60*60); //	1�ð�
		response.sendRedirect("/member/goToMainPage");
	}
}
