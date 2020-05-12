package com.song.shop.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.shop.entity.UserEntity;
import com.song.shop.repository.UserRepository;
import com.song.shop.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String checkUserId(String user_id) 
	{
		System.out.println(user_id + " >>> ");
		Optional<UserEntity> user = userRepository.findById(user_id);
		
		if(user != null)
		{
			return "OK";
		}
		
		return "FAIL";
	}
}
