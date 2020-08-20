package com.song.shop.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.song.shop.dto.CodeDto;
import com.song.shop.dto.GroupDto;
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
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	private Environment env;
	private RestTemplate restTemplate;
	private Gson gson;
	
	@Autowired
	private UserRepository userRepository;
	
	@Resource(name = "groupService")
	private GroupService groupService;
	
	@Resource(name = "codeService")
	private CodeService codeService;
	
	@Value( "${url.base}" )
	private String baseUrl;

	@Value( "${social.kakao.client_id}" )
	private String kakaoClientId;
	
	@Value( "${social.kakao.redirect}" )
	private String kakaoRedirect;
	
	@Value( "${social.kakao.url.login}" )
	private String kakaoLoginUrl;

	@ApiOperation(value = "로그인 페이지")
//	@LogExecutionTime
	@RequestMapping(value = { "/login", "/", "//" })
	public ModelAndView login( ModelAndView mv, HttpServletRequest request, String loginFail, Model model ) throws IOException
	{	
		if("[ROLE_ANONYMOUS]".equals( SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString() ) )
		{	
			if("true".equals(loginFail)) mv.addObject("message", "로그인 실패");
			StringBuilder loginUrl = new StringBuilder()
					.append( kakaoLoginUrl )
					.append( "?client_id=" )
					.append( kakaoClientId )
					.append( "&response_type=code" )
					.append( "&redirect_uri=" )
					.append( baseUrl )
					.append( kakaoRedirect );
			mv.addObject( "loginUrl", loginUrl );
			mv.setViewName( "index" );			
		}
		else mv.setViewName("redirect:/member/goToMainPage");

		return mv;
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
	
	@RequestMapping("/navercallback") 
	public String naverLoginCallBack() 
	{
		log.info("#######################"); 
		log.info("navercallback");
		log.info("#######################"); 
		return "index"; 
	}
	
	@RequestMapping( value = "/social/login/kakao", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST } )
	public String kakaoLogin( @RequestParam( "code" ) String code )
	{
		JsonNode kakaoNode = getAccessToken( code );		
		JsonNode accessToken = kakaoNode.get( "access_token" );
		JsonNode info = getKakaoUserInfo( accessToken );
		
		String id = info.get( "id" ).toString();
		String profile_image_url = info.get( "properties" ).get( "profile_image_url" ).toString();
		
		return "";
	}
	
	public JsonNode getAccessToken( String code ) 
	{
		final String requestUrl = "https://kauth.kakao.com/oauth/token";
		final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		
		postParams.add( new BasicNameValuePair( "grant_type", "authorization_code" ) );
		postParams.add( new BasicNameValuePair( "client_id", kakaoClientId ) );
		postParams.add( new BasicNameValuePair( "redirect_uri", baseUrl + kakaoRedirect ) );
		postParams.add( new BasicNameValuePair( "code", code ) );
		
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost();
		
		JsonNode returnNode = null;
		
		try
		{
			post.setEntity( new UrlEncodedFormEntity( postParams ) );
			
			final HttpResponse response = client.execute( post );
			final int responseCode = response.getStatusLine().getStatusCode();
			
			log.debug( "################################################" );
			log.debug( "Sending 'post' request to URL :: " + requestUrl );
			log.debug( "Post parameters :: " + postParams );
			log.debug( "Response Code :: " + responseCode );
			log.debug( "################################################" );
			
			// JSON 형태 반환값 처리
			ObjectMapper mapper = new ObjectMapper();
			
			returnNode = mapper.readTree( response.getEntity().getContent() );
			
			
		}
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return returnNode;
	}

	public JsonNode getKakaoUserInfo( JsonNode accessToken )
	{
		final String requestUrl = "http://kapi.kakao.com/v2/user/me";
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost( requestUrl );
		
		post.addHeader( "Authorization", "Bearer " + accessToken);
		
		JsonNode returnNode = null;
		
		try 
		{
			final HttpResponse response = client.execute( post );
			final int responseCode = response.getStatusLine().getStatusCode();
			
			log.debug( "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
			log.debug( "'Post' request to ULR :: " + requestUrl );
			log.debug( "ResponseCode :: " + responseCode );
			log.debug( "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
			
			ObjectMapper mapper = new ObjectMapper();
			returnNode = mapper.readTree( response.getEntity().getContent() );
		} 
		catch ( ClientProtocolException e ) 
		{
			e.printStackTrace();
		}
		catch ( IOException e ) 
		{
			e.printStackTrace();
		}
		
		return returnNode;
	}	
}
