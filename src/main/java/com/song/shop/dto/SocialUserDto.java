package com.song.shop.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;

import lombok.Getter;

import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class SocialUserDto 
{
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY )
	private long msrl;
	
	@Column( nullable = false, unique = true, length = 50 )
	private String uid;
	
	@JsonProperty( access = JsonProperty.Access.WRITE_ONLY )
	@Column( length = 100 )
	private String password;
	
	@Column( nullable = false, length = 100 )
	private String name;
	
	@Column( length = 100 )
	private String provider;
}
