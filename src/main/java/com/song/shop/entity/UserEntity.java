package com.song.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "user")
public class UserEntity 
{
	@Id
	@Column(name = "user_id")
	private String user_id;
	
	@Column(name = "user_nm")
	private String user_nm;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_role")
	private String user_role;	// admin, consumer, merchant
	
	@Column(name = "user_type")
	private String user_type;	// local, naver, kakao


	@Builder 
	public UserEntity(String user_id, String user_nm, String password, String user_role, String user_type) 
	{ 
		this.user_id = user_id; 
		this.user_nm = user_nm; 
		this.password = password; 
		this.user_role = user_role; 
		this.user_type = user_type; 
	}
	 
}
