package com.song.shop.utils;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
//public class SwaggerConfig 
//{
//	@Bean
//	public Docket newsApi()
//	{
//		 ArrayList<ResponseMessage> responseMessageStatus = new ArrayList();
//		 responseMessageStatus.add(new ResponseMessageBuilder().code(400).message("Bad Request").responseModel(new ModelRef("Error")).build());
//		 responseMessageStatus.add(new ResponseMessageBuilder().code(401).message("No permission").responseModel(new ModelRef("Error")).build());
//		 responseMessageStatus.add(new ResponseMessageBuilder().code(404).message("Not found").responseModel(new ModelRef("Error")).build());
//		 responseMessageStatus.add(new ResponseMessageBuilder().code(405).message("Method Not Allowed").responseModel(new ModelRef("Error")).build());
//		 responseMessageStatus.add(new ResponseMessageBuilder().code(500).message("Internal Server Error").responseModel(new ModelRef("Error")).build());
//		 
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.song.shop.controller"))	// ���� RequestMapping ���� �Ҵ�� ��� URL ����Ʈ ����
//				.build()
//				.apiInfo(apiInfo())
//				.globalResponseMessage(RequestMethod.POST, responseMessageStatus)
//				.globalResponseMessage(RequestMethod.GET, responseMessageStatus)
//				.globalResponseMessage(RequestMethod.PUT, responseMessageStatus)
//				.globalResponseMessage(RequestMethod.DELETE, responseMessageStatus);
//	}
//	
//	private ApiInfo apiInfo()
//	{
//		return new ApiInfoBuilder()
//				.title("REST API")
//				.contact("TEST")
//				.version("0.0.1")
//				.build();
//	}
//}
