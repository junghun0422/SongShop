package com.song.shop.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.song.shop.dto.KakaoProfile;
import com.song.shop.dto.RetKakaoAuth;
import com.song.shop.service.KakaoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service( "kakaoService" )
public class KakaoServiceImpl implements KakaoService 
{
	private final RestTemplate restTemplate;
	private final Environment env;
	private final Gson gson;
	
	@Value( "${url.base}" )
	private String baseUrl;

	@Value( "${social.kakao.client_id}" )
	private String kakaoClientId;
	
	@Value( "${social.kakao.redirect}" )
	private String kakaoRedirect;
	
	@Override
	public KakaoProfile getKakaoProfile( String accessToken )
	{
		// Set Header :: Content-type : application/x-www-form-urlencoded
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType( MediaType.APPLICATION_FORM_URLENCODED );
		headers.set( "Authorization", "Bearer " + accessToken );

		// Set http entity
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity( env.getProperty( "social.kakao.url.profile" ), request, String.class );
		
		if( response.getStatusCode() == HttpStatus.OK ) return gson.fromJson( response.getBody(), KakaoProfile.class );	
		return null;
	}
	
	@Override
	public RetKakaoAuth getKakaoTokenInfo( String code )
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType( MediaType.APPLICATION_FORM_URLENCODED );
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add( "grant_type", "authorization_code" );
		params.add( "clientId", kakaoClientId );
		params.add( "redirect_url" , baseUrl + kakaoRedirect );
		params.add( "code", code );
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
		ResponseEntity<String> response = restTemplate.postForEntity( env.getProperty( "social.kakao.url.token" ), request, String.class );
		
		if( response.getStatusCode() == HttpStatus.OK ) return gson.fromJson( response.getBody(), RetKakaoAuth.class );
		return null;
	}
}

