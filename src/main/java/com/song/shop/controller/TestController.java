package com.song.shop.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.shop.dto.CodeDto;
import com.song.shop.dto.GroupDto;
import com.song.shop.entity.GroupEntity;
import com.song.shop.entity.UserEntity;
import com.song.shop.repository.UserRepository;
import com.song.shop.service.CodeService;
import com.song.shop.service.GroupService;

@Controller
public class TestController 
{ 
	private static final Logger log = LoggerFactory.getLogger(Test.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Resource(name = "groupService")
	private GroupService groupService;
	
	@Resource(name = "codeService")
	private CodeService codeService;
	
	@GetMapping("/")
	public String index()
	{	
		return "index";
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
	public String webSockete()
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
	
	/*
	 * @RequestMapping("/navercallback") public String naverLoginCallBack() {
	 * log.info("#######################"); log.info("navercallback");
	 * log.info("#######################"); return "index"; }
	 */
}
