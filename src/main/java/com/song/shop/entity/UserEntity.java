package com.song.shop.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Setter @Getter
@Table( name = "user" )
public class UserEntity 
{
	@Id
	@Column( name = "user_id")
	private String user_id;
	
	@Column( name = "user_nm", nullable = false )
	private String user_nm;
	
	@Column( name = "password", nullable = false )
	private String password;
	
	@Column( name = "email", nullable = false )
	private String email;
	
	@Column( name = "auth_level", nullable = false )
	private int auth_level;	// ���ѵ�� :: (0: ������, 1: �Ǹ���, 2: ��)
	
	@Column( name = "phone_num", nullable = false )
	private String phone_num;
	
	@Column( name = "zip_code", nullable = false )
	private String zip_code;
	
	@Column( name = "address", nullable = false )
	private String address;
	
	@Column( name = "detail_address", nullable = false )
	private String detail_address;
	
	@Column( name = "regist_dt", nullable = false )
	private Timestamp regist_dt;
	
//	@OneToMany( cascade = CascadeType.REMOVE )
//	@JoinTable( name = "category", joinColumns = @JoinColumn( name = "user_id") )
//	private List<CategoryEntity> categories = new ArrayList<CategoryEntity>();
	
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAuth_level() {
		return auth_level;
	}

	public void setAuth_level(int auth_level) {
		this.auth_level = auth_level;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}

	public Timestamp getRegist_dt() {
		return regist_dt;
	}

	public void setRegist_dt(Timestamp regist_dt) {
		this.regist_dt = regist_dt;
	}	
}
