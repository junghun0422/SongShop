package com.song.shop.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inquiry")
public class InquiryController 
{
	@ApiOperation( value = "문의하기", notes = "문의하기 페이지로 이동" )
	@GetMapping( "/goInquiry" )
	public ModelAndView goInquiryPage()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject( "userInfo", SecurityContextHolder.getContext().getAuthentication().getName() );
		mv.setViewName( "common/inquiry" );
		
		return mv;
	}
	
	@ApiOperation( value = "문의하기 CKEditor 이미지 업로드", notes = "문의하기 CKEditor 이미지 업로드" )
	@PostMapping( "/imgUpload" )
	public @ResponseBody String imgUpload( HttpServletRequest request, HttpServletResponse response, MultipartFile upload ) throws Exception
	{
		String fileName = upload.getOriginalFilename();
		
		String uploadPath = request.getServletContext().getRealPath( "/upload/inquiry" );
		
		File file = new File( uploadPath + "/" + fileName );
		
		try
		{
			FileUtils.writeByteArrayToFile( file, upload.getBytes() );
			return "{ \"uploaded\" : true, \"url\" : \"http://192.168.1.15:8080/upload/editor/" + fileName + "\" }";
		}
		catch (IOException e) 
		{
			return "{ \"uploaded\" : false, \"error\": { \"message\": \"업로드 중 에러가 발생하였습니다. 다시 시도해 주세요.\" } }";
		}
	}
}
