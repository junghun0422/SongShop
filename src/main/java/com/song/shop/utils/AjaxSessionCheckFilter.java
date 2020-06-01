package com.song.shop.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;


public class AjaxSessionCheckFilter implements Filter
{
	private String ajaxHeader;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!! AjaxSessionCheckFilter doFilter");
		if(isAjaxRequest(req)) 
		{
			try 
			{
				chain.doFilter(req, res);	
			}
			catch (AccessDeniedException e) 
			{
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
			}
			catch (AuthenticationException e) {
				res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
		else
		{
			chain.doFilter(req,  res);
		}
	}
	
	public boolean isAjaxRequest(HttpServletRequest request)
	{
		return request.getHeader(ajaxHeader) != null && request.getHeader(ajaxHeader).equals(Boolean.TRUE.toString());
	}
	
	public void destory() { }
	
	public void setAjaxHeader(String ajaxHeader)
	{
		this.ajaxHeader = ajaxHeader;
	}
	
}
