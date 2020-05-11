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
	
	@Column(name = "auth_level")
	private String auth_level;	// admin, consumer, merchant
	
	@Column(name = "regist_dt")
	private String regist_dt;	


	@Builder 
	public UserEntity(String user_id, String user_nm, String password, String auth_level, String regist_dt) 
	{ 
		this.user_id = user_id; 
		this.user_nm = user_nm; 
		this.password = password; 
		this.auth_level = auth_level; 
		this.regist_dt = regist_dt; 
	}
	 
}
