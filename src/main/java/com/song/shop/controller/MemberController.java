package com.song.shop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.song.shop.dto.UserDto;
import com.song.shop.service.UserService;

@Controller
public class MemberController 
{
	private static Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/join-member")
	public String memberJoin()
	{
		return "member_join";
	}
	
	@RequestMapping("/join/checkUser")
	public @ResponseBody String checkUserId(String user_id)
	{
		return userService.checkUserId(user_id);
	}
	
	@RequestMapping("/join/member")
	public @ResponseBody String joinMember(UserDto userDto)
	{
		return userService.joinMember(userDto);
	}
	
	@RequestMapping("/member/login")
	public @ResponseBody String checkUser(String user_id, String password)
	{
		return userService.memberLogin(user_id, password);
	}
	
	@RequestMapping(value = { "/login", "/", "//" })
	public String login(Model model, HttpServletRequest request, HttpServletResponse response, String loginFail) throws IOException
	{
		String auth = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		
		if("[ROLE_ANONYMOUS]".equals(auth))
		{
			model.addAttribute("message", "loginFail");
			return "index";
		}
		else return "redirect:/goToMainPage";
	}
	
	@RequestMapping(value="/goToMainPage", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView goToMainPage(Model model, Authentication auth, HttpServletResponse response, HttpServletRequest request)
	{
		String returnUrl = "";
		ModelAndView mv = new ModelAndView();
		
		switch(auth.getAuthorities().toString())
		{
			case "[ROLE_ADMIN]" :  
				returnUrl = "admin/admin_main";
				break;
			case "[ROLE_SELLER]" : 
				returnUrl = "seller/seller_main";
				break;
			case "[ROLE_CONSUMER]" : 
				returnUrl = "consumer/consumer_main";
				break;
		}
		
		mv.addObject("userInfo", "SONG");
		mv.setViewName(returnUrl);
		return mv;
	}
	
}
