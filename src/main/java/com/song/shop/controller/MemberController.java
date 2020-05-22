package com.song.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.song.shop.dto.UserDto;
import com.song.shop.service.UserService;

@RestController
public class MemberController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping("/join/checkUser")
	public String checkUserId(String user_id)
	{
		return userService.checkUserId(user_id);
	}
	
	@RequestMapping("/join/member")
	public @ResponseBody String joinMember(UserDto userDto)
	{
		return userService.joinMember(userDto);
	}
}
