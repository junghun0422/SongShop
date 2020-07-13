package com.song.shop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.shop.dto.ProductDto;
import com.song.shop.utils.Constant;
import com.song.shop.utils.CyResult;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerController 
{
	private static Logger log = LoggerFactory.getLogger(SellerController.class);
	
	@ApiOperation("상품등록")
	@RequestMapping(value = "/registProduct", headers = "Content-Type=multipart/form-data", method = RequestMethod.POST)
	public @ResponseBody CyResult<String> registProduct(Authentication auth, HttpServletRequest request, HttpServletResponse response, ProductDto productDto)
	{
		CyResult<String> result = new CyResult<>(); 
		
		if(StringUtils.isEmpty(productDto.getCategory_code()) || StringUtils.isEmpty(productDto.getProduct_nm()) ||
				StringUtils.isEmpty(productDto.getProduct_price()) || productDto.getProduct_img().getSize() < 1)
		{
			result.setCode(Constant.RESULT_FAIL_CODE_01);
			result.setMessage("필수항목이 누락되었습니다.");
			return result;
		}
		
		String fileName = productDto.getProduct_img().getOriginalFilename();
		String uploadPath = request.getServletContext().getRealPath("/upload/proudct");
		
		String[] arr = fileName.split("\\.");
		String name = arr[0] + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "." + arr[1];
		
		File file = new File(uploadPath + "/" + auth.getName() + "/" + name);
		
		log.debug("###########################################");
		log.debug("filePath :: " + file.getAbsolutePath());
		log.debug("###########################################");
		
		try
		{
			FileUtils.writeByteArrayToFile(file, productDto.getProduct_img().getBytes());
			
			// DataBase 작업 필요
			
			result.setCode(Constant.RESULT_SUCCESS_CODE);
			result.setMessage("상품 등록 성공");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			result.setCode(Constant.RESULT_FILE_CODE_90);
			result.setMessage("상품 이미지 업로드 실패");
		}

		return result;
	}
}
