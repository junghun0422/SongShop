package com.song.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.song.shop.service.KakaoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SocialController 
{
//	private final Environment env;
//	private final RestTemplate restTemplate;
//	private final Gson gson;
	
	@Autowired
	private KakaoService kakaoService;
	
	@Value( "${url.base}" )
	private String baseUrl;
	
	@Value( "${social.kakao.client_id}" )
	private String kakaoClientId;
	
	@Value( "${social.kakao.redirect}" )
	private String kakaoRedirect;
	
	@Value( "${social.kakao.url.login}" )
	private String kakaoLoginUrl;

	// 카카오 로그인 페이지
//	@GetMapping
//	public ModelAndView socialLogin( ModelAndView mv )
//	{
//		StringBuilder loginUrl = new StringBuilder()
//				.append( kakaoLoginUrl )
//				.append( "?client_id=" )
//				.append( kakaoClientId )
//				.append( "&response_type=code" )
//				.append( "&redirect_uri=" )
//				.append( baseUrl )
//				.append( kakaoRedirect );
//		
//		mv.addObject( "loginUrl", loginUrl );
//		mv.setViewName( "index" );
//		return mv;
//	}
//	
//	@RequestMapping( value = "/social/login/kakao", method = { RequestMethod.GET, RequestMethod.POST } )
//	public String redirectKakao( ModelAndView mv, @RequestParam String access_token, @RequestParam String refresh_token, 
//											@RequestParam String expires_in, @RequestParam String refresh_token_expires_in, @RequestParam String token_type )
//	{
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		mv.addObject( "authInfo", kakaoService.getKakaoTokenInfo( code ) );
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		
//		return "꺅";
//	} 
	
}
