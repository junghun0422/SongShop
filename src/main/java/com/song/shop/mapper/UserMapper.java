package com.song.shop.mapper;

import org.springframework.stereotype.Repository;

import com.song.shop.dto.UserDto;

@Repository("userMapper")
public interface UserMapper 
{
	UserDto selectUserById(String user_id);
}
