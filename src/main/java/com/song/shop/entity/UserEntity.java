package com.song.shop.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "auth_level")
	private int auth_level;	// 권한등급 :: (0: 관리자, 1: 판매자, 2: 고객)
	
	@Column(name = "phone_num")
	private String phone_num;
	
	@Column(name = "zip_code")
	private String zip_code;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "detail_address")
	private String detail_address;
	
	@Column(name = "regist_dt")
	private Timestamp regist_dt;
	
	public UserEntity() { }
	
	@Builder 
	public UserEntity(String user_id, String user_nm, String password, String email, int auth_level, String phone_num,
			String zip_code, String address, String detail_address) {
		this.user_id = user_id;
		this.user_nm = user_nm;
		this.password = password;
		this.email = email;
		this.auth_level = auth_level;
		this.phone_num = phone_num;
		this.zip_code = zip_code;
		this.address = address;
		this.detail_address = detail_address;
	}

	@Builder 
	public UserEntity(String user_id, String user_nm, String password, String email, int auth_level, String phone_num,
			String zip_code, String address, String detail_address, Timestamp regist_dt) {
		this.user_id = user_id;
		this.user_nm = user_nm;
		this.password = password;
		this.email = email;
		this.auth_level = auth_level;
		this.phone_num = phone_num;
		this.zip_code = zip_code;
		this.address = address;
		this.detail_address = detail_address;
		this.regist_dt = regist_dt;
	}

	@Override
	public String toString() {
		return "UserEntity [user_id=" + user_id + ", user_nm=" + user_nm + ", password=" + password + ", email=" + email
				+ ", auth_level=" + auth_level + ", phone_num=" + phone_num + ", zip_code=" + zip_code + ", address="
				+ address + ", detail_address=" + detail_address + ", regist_dt=" + regist_dt + "]";
	}	
	
	
}
