package com.song.shop.security;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class AuthUtils 
{
	private static Logger log = LoggerFactory.getLogger( AuthUtils.class );
	
	public static Model getUserLoginInfo( Model model, Authentication auth )
	{
		auth = SecurityContextHolder.getContext().getAuthentication();
		
		String user_id = auth.getName();
		
		Collection<SimpleGrantedAuthority> authorities = ( Collection<SimpleGrantedAuthority> ) auth.getAuthorities();
		
		log.debug("user_id :: " + user_id + " / auth >> " + authorities);
		
		String role = authorities.toString();
		if( role.contains( "ROLE_ADMIN") )
		{
			model.addAttribute( "auth_info", "ROLE_ADMIN" );
		}
		else if( role.contains( "ROLE_SELLER" ) )
		{
			model.addAttribute( "auth_info", "ROLE_SELLER" );	
		}
		else if( role.contains( "ROLE_CONSUMER" ) )
		{
			model.addAttribute( "auth_info", "ROLE_CONSUMER" );
		}
		else
		{
			model.addAttribute( "auth_info", "ROLE_ANONYMOUS" );
		}
		
		return model;
	}
	
	public static String getUserId( Authentication auth )
	{
		auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
}
	