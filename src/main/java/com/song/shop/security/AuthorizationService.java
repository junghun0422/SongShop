package com.song.shop.security;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.song.shop.dto.UserDto;
import com.song.shop.entity.UserEntity;
import com.song.shop.mapper.UserMapper;
import com.song.shop.repository.UserRepository;
import com.song.shop.utils.EncryptUtils;

@Service
public class AuthorizationService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Resource(name = "userMapper")
	private UserMapper userMapper;
	
	public Optional<UserEntity> login(String user_id, String password)
	{
		Optional<UserEntity> userEntity = userRepository.findById(user_id);
		if(userEntity.isPresent())
		{
			String input_pwd = EncryptUtils.encryptSHA256(password, user_id.getBytes()).toUpperCase();
			if(userEntity.get().getPassword().equals(input_pwd)) 
			{
				return userEntity;
			}
		}

		throw new BadCredentialsException("Not Found UserInfo");
	}
}
