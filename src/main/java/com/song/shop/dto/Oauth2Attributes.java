//package com.song.shop.dto;
//
//import java.util.Map;
//
//import com.song.shop.entity.User;
//import com.song.shop.utils.Role;
//
//import lombok.Builder;
//import lombok.Getter;
//
//@Getter
//public class Oauth2Attributes 
//{
//	private Map<String, Object> attributes;
//	private String nameAttributeKey, name, email, picture;
//	
//	@Builder
//	public Oauth2Attributes( Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture ) 
//	{
//		this.attributes = attributes;
//		this.nameAttributeKey = nameAttributeKey;
//		this.name = name;
//		this.email = email;
//		this.picture = picture;
//	}
//	
//	public static Oauth2Attributes of( String registrationId, String userNameAttributeName, Map<String, Object> attributes )
//	{
//		return ofGoogle( userNameAttributeName, attributes );
//	}
//	
//	public static Oauth2Attributes ofGoogle( String userNameAttributeName, Map<String, Object> attributes )
//	{
//		return Oauth2Attributes.builder()
//				.name( ( String ) attributes.get( "name" ) )
//				.email( ( String ) attributes.get( "email" ) )
//				.picture( ( String ) attributes.get( "picture" ) )
//				.attributes( attributes )
//				.nameAttributeKey( userNameAttributeName )
//				.build();
//	}
//	
//	public User toEntity()
//	{
//		return User.builder()
//				.name( name )
//				.email( email )
//				.picture( picture )
//				.role( Role.CUSTOMER )
//				.build();
//	}
//}
