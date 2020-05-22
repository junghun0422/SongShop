package com.song.shop.service;

import com.song.shop.dto.UserDto;

public interface UserService 
{ 
	String checkUserId(String user_id);
	
	String joinMember(UserDto userDto);
	
	String memberLogin(String user_id, String password);
}
