package com.song.shop.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.song.shop.dto.UserDto;
import com.song.shop.entity.UserEntity;
import com.song.shop.service.UserService;
import com.song.shop.utils.CyResult;
import com.song.shop.utils.EncryptUtils;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider 
{
	@Autowired
	AuthorizationService authorizationService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException 
	{
		String user_id = authentication.getName();
		String password = authentication.getCredentials().toString();
		return authenticate(user_id, password);
	}
	
	public Authentication authenticate(String user_id, String password) throws AuthenticationException
	{
		Optional<UserEntity> user = authorizationService.login(user_id, password);
		
		if(!user.isPresent())
		{
			System.out.println("[AuthProvider] :: 로그인 정보 없음.");
			throw new BadCredentialsException("Not Found UserInfo");
		}
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		String role = "";
		switch(user.get().getAuth_level())
		{
			case 0 :
				role = "ROLE_ADMIN";
				break;
			case 1 :
				role = "ROLE_SELLER";
				break;
			case 2 :
				role = "ROLE_CUSTOMER";
				break;
		}
		
		grantedAuthorityList.add(new SimpleGrantedAuthority(role));
		return new MyAuthentication(user_id, password, grantedAuthorityList, user);
	}

	@Override
	public boolean supports(Class<?> authentication) 
	{
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
