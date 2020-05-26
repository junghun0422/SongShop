package com.song.shop.service;

import java.util.Optional;

import com.song.shop.dto.UserDto;
import com.song.shop.entity.UserEntity;

public interface UserService 
{ 
	String checkUserId(String user_id);
	
	String joinMember(UserDto userDto);
	
	String memberLogin(String user_id, String password);
	
	Optional<UserEntity> selectUser(String user_id);
}
