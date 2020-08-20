package com.song.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.song.shop.dto.UserDto;
import com.song.shop.service.UserService;
import com.song.shop.utils.CyResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@Api( tags = { "1. User" } )
@Controller
@RequiredArgsConstructor
@RequestMapping( value="/member" )
public class MemberController 
{
	private static Logger log = LoggerFactory.getLogger( MemberController.class );
	
	@Autowired
	private UserService userService;
	
	@ApiOperation( value = "회원가입", notes = "회원가입 페이지로 이동" )
	@GetMapping( "/join-member" )
	public String memberJoin()
	{
		return "member_join";
	}
	
	@ApiOperation( value = "아이디 중복체크", notes = "회원가입시 아이디 중복여부 확인" )
	@GetMapping( "/checkUser" )
	public @ResponseBody CyResult<String> checkUserId( @ApiParam( value = "가입할 아이디", required = true ) 
														String user_id )
	{
		return userService.checkUserId(user_id);
	}
	
	@ApiOperation( value = "회원가입", notes = "회원가입 API" )
	@PostMapping( "/join" )
	public @ResponseBody CyResult<String> joinMember( UserDto userDto )
	{
		return userService.joinMember( userDto );
	}
	
	@ApiOperation( value = "로그인", notes = "로그인 API" )
	@PostMapping("/login/{id}")
	public @ResponseBody String checkUser( @ApiParam( value = "로그인 아이디" ) 
											@PathVariable( value = "user_id" ) String user_id, 
											@ApiParam( value = "password" ) String password )
	{
		return userService.memberLogin( user_id, password );
	}
	
	@ApiOperation( value = "메인 페이지 이동", notes = "로그인 성공후 권한별 메인 페이지 이동" )
	@GetMapping( value="/goToMainPage" )
	public ModelAndView goToMainPage( ModelAndView mv, Authentication auth, HttpServletResponse response, HttpServletRequest request )
	{
		String returnUrl = "";
//		ModelAndView mv = new ModelAndView();

		switch( auth.getAuthorities().toString() )
		{
			case "[ROLE_ADMIN]" :  
				returnUrl = "admin/admin_main";
				break;
			case "[ROLE_SELLER]" : 
				returnUrl = "seller/seller_main";
				break;
			case "[ROLE_CUSTOMER]" : 
//				returnUrl = "customer/customer_main";
				returnUrl = "customer/canvas_chart";
				break;
		}
		
		mv.addObject( "userInfo", SecurityContextHolder.getContext().getAuthentication().getName() );
		mv.setViewName( returnUrl );
		return mv;
	}
	

}
