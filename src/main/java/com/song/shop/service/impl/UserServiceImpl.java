package com.song.shop.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.shop.dto.UserDto;
import com.song.shop.entity.UserEntity;
import com.song.shop.repository.UserRepository;
import com.song.shop.service.UserService;
import com.song.shop.utils.Constant;
import com.song.shop.utils.CyResult;
import com.song.shop.utils.EncryptUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService
{
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public CyResult<String> checkUserId(String user_id) 
	{
		CyResult<String> result = new CyResult<>();
		
		if(userRepository.findById(user_id).isPresent()) 
			result.setCode(Constant.RESULT_FAIL_CODE_03);
		else 
			result.setCode(Constant.RESULT_SUCCESS_CODE);

		return result;
	}

	@Override
	public CyResult<String> joinMember( UserDto userDto ) 
	{
		CyResult<String> result = new CyResult<>();

		String pwd = EncryptUtils.encryptSHA256(userDto.getPassword(), userDto.getUser_id().getBytes()).toUpperCase();
		String val = userRepository.save( 
				new UserEntity(
						userDto.getUser_id(), userDto.getUser_nm(), pwd, userDto.getEmail(), userDto.getAuth_level(), 
				userDto.getPhone_num(), userDto.getZip_code(), userDto.getAddress(), userDto.getDetail_address(), Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())))).getUser_id();
		
		result.setCode(Constant.RESULT_SUCCESS_CODE);
		result.setData(val);
		return result;
	}

	@Override
	public String memberLogin(String user_id, String password) 
	{
		Optional<UserEntity> userEntity = userRepository.findById(user_id);
		
		String input_pwd = EncryptUtils.encryptSHA256(password, user_id.getBytes()).toUpperCase();
		
		if(userEntity.isPresent())
		{
			if(input_pwd.equals(userEntity.get().getPassword()))
			{
				return "�α��� ����";
			}
			
			return "�α��� ����!";
			
		}
		
		return "�α��� ����";
	}

	@Override
	public Optional<UserEntity> selectUser(String user_id) 
	{
		return userRepository.findById(user_id);	
	}	
}
