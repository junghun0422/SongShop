package com.song.shop.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.shop.dto.UserDto;
import com.song.shop.entity.UserEntity;
import com.song.shop.repository.UserRepository;
import com.song.shop.service.UserService;
import com.song.shop.utils.EncryptUtils;

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
		Optional<UserEntity> user = userRepository.findById(user_id);
		
		if(user != null)
		{
			return "OK";
		}
		
		return "FAIL";
	}

	@Override
	public String joinMember(UserDto userDto) 
	{
		String pwd = EncryptUtils.encryptSHA256(userDto.getPassword(), userDto.getUser_id().getBytes()).toUpperCase();
		UserEntity user = userRepository.save(new UserEntity(userDto.getUser_id(), userDto.getUser_nm(), pwd, userDto.getEmail(), userDto.getAuth_level(), 
				userDto.getPhone_num(), userDto.getZip_code(), userDto.getAddress(), userDto.getDetail_address(), Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()))));
		return "";
	}

	@Override
	public String memberLogin(String user_id, String password) 
	{
		Optional<UserEntity> userEntity = userRepository.findById(user_id);
		
		String input_pwd = EncryptUtils.encryptSHA256(password, user_id.getBytes()).toUpperCase();
		
		if(userEntity != null)
		{
			if(input_pwd.equals(userEntity.get().getPassword()))
			{
				return "로그인 성공";
			}
			
			return "로그인 실패!";
			
		}
		
		return "로그인 실패";
	}	
	
	
}
