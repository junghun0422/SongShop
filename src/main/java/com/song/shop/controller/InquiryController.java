package com.song.shop.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/inquiry")
public class InquiryController 
{
	@ApiOperation(value = "�����ϱ�")
	@GetMapping("/goInquiry")
	public String goInquiryPage()
	{
		return "common/inquiry";
	}
	
	@ApiOperation(value = "�����ϱ� CKEditor �̹��� ���ε�" )
	@RequestMapping("/imgUpload")
	public @ResponseBody String imgUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) throws Exception
	{
		String fileName = upload.getOriginalFilename();
		
		String uploadPath = request.getServletContext().getRealPath("/upload/inquiry");
		System.out.println("################################");
		System.out.println(uploadPath + "/" + fileName);
		System.out.println("################################");
		File file = new File(uploadPath + "/" + fileName);
		
		try
		{
			FileUtils.writeByteArrayToFile(file, upload.getBytes());
			 return "{ \"uploaded\" : true, \"url\" : \"http://192.168.1.15:8080/upload/editor/" + fileName + "\" }";
		}
		catch (IOException e) 
		{
			return "{ \"uploaded\" : false, \"error\": { \"message\": \"���ε� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���.\" } }";
		}
	}
}
