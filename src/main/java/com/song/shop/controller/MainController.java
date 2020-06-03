package com.song.shop.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.song.shop.dto.CodeDto;
import com.song.shop.dto.GroupDto;
import com.song.shop.dto.UserDto;
import com.song.shop.entity.GroupEntity;
import com.song.shop.entity.UserEntity;
import com.song.shop.repository.UserRepository;
import com.song.shop.service.CodeService;
import com.song.shop.service.GroupService;
import com.song.shop.utils.EncryptUtils;

import io.swagger.annotations.ApiOperation;

@Controller
public class MainController 
{ 
	private static final Logger log = LoggerFactory.getLogger(Test.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Resource(name = "groupService")
	private GroupService groupService;
	
	@Resource(name = "codeService")
	private CodeService codeService;
	
	@ApiOperation(value = "�α��� ������")
	@RequestMapping(value = { "/login", "/", "//" })
	public String login(Model model, HttpServletRequest request, HttpServletResponse response, String loginFail) throws IOException
	{
		if("[ROLE_ANONYMOUS]".equals(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString()) )
		{	
			if("true".equals(loginFail)) model.addAttribute("message", "�α��� ����");
			return "index";
		}
		else return "redirect:/goToMainPage";
	}
	
	
	@RequestMapping("/userList")
	public @ResponseBody List<UserEntity> userList()
	{
		return userRepository.findAll();
	}
	
	@RequestMapping("/getUser")
	public @ResponseBody Optional<UserEntity> getUserList()
	{
		return userRepository.findById("song");
	}
	
	@RequestMapping("/treePage")
	public String treePage()
	{
		return "main/tree";
	}
	
	@RequestMapping("/webSocket")
	public String webSocket()
	{
		return "main/websocket";
	}
	
	@RequestMapping("/getGroupList") 
	public @ResponseBody List<GroupEntity> getGroupList() 
	{
		return groupService.getGroupList();
	}
	
	@RequestMapping("/getGroupParkList")
	public @ResponseBody List<GroupDto> getGroupParkList()
	{
		return groupService.getGroupParkList("G_1");
	}
	
	@RequestMapping("/getCodeList")
	public @ResponseBody List<CodeDto> getCodeList()
	{
		return codeService.getCodeList();
	}
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public String greeting(String msg) throws Exception
	{
		return msg;
	}

	@RequestMapping("/checkUser")
	public @ResponseBody String checkUser(String user_id, String password)
	{
		Optional<UserEntity> userEntity = userRepository.findById(user_id);
		
		String en_pw = EncryptUtils.encryptSHA256(password, user_id.getBytes()).toUpperCase();
		System.out.println(en_pw);
		return en_pw;
	}
	
	
	/*
	 * @RequestMapping("/navercallback") public String naverLoginCallBack() {
	 * log.info("#######################"); log.info("navercallback");
	 * log.info("#######################"); return "index"; }
	 */
}