package com.song.shop.security;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.song.shop.dto.UserDto;
import com.song.shop.entity.UserEntity;

import lombok.Data;

@Data
public class MyAuthentication extends UsernamePasswordAuthenticationToken
{
	private  static final long serialVersionUID = 1L;
	
//	UserDto userDto;
	Optional<UserEntity> user;
	
	public MyAuthentication(String user_id, String password, List<GrantedAuthority> grantedAuthorityList, Optional<UserEntity> user)
	{
        super(user_id, password, grantedAuthorityList);
        this.user = user;
	}
}
