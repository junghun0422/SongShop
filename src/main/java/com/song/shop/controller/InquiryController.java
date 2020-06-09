package com.song.shop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.JsonObject;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/inquiry")
public class InquiryController 
{
	@ApiOperation(value = "문의하기")
	@GetMapping("/goInquiry")
	public String goInquiryPage()
	{
		return "common/inquiry";
	}
	
	@ApiOperation(value = "문의하기 CKEditor 이미지 업로드" )
	@PostMapping("/imgUpload")
	public @ResponseBody void imgUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile multiFile) throws Exception
	{
//		printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
//
//	               + callback
//
//	               + ",'"
//
//	               + fileUrl
//
//	               + "','이미지를 업로드 하였습니다.'"
//
//	               + ")</script>");
//
//	       printWriter.flush();
		
		
		JsonObject json = new JsonObject();
		
		PrintWriter printWriter = null;
		OutputStream out = null;
		
		MultipartFile file = ((MultipartRequest) multiFile).getFile("upload");
		
		if(file != null)
		{
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName()))
			{
				if(file.getContentType().toLowerCase().startsWith("image/"));
				try
				{
					String fileName= file.getName();
					byte[] bytes = file.getBytes();
					String uploadPath = request.getServletContext().getRealPath("/img");
					File uploadFile = new File(uploadPath);
					if(!uploadFile.exists())
					{
						uploadFile.mkdirs();
					}
					
					fileName = UUID.randomUUID().toString();
					uploadPath = uploadPath + "/" + fileName;
					out = new FileOutputStream(new File(uploadPath));
					out.write(bytes);
					
					printWriter = response.getWriter();
					response.setContentType("text/html");
					String fileUrl = request.getContextPath() + "/img/" + fileName;
					
					// json 데이터 등록
					json.addProperty("uploaded", 1);
					json.addProperty("fileName", fileName);
					json.addProperty("url", fileUrl);
					
					printWriter.println(json);
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				finally 
				{
					if(out != null)
					{
						out.close();
					}
					
					if(printWriter != null)
					{
						printWriter.close();
					}
				}
			}
			
		}
	}
	
}
