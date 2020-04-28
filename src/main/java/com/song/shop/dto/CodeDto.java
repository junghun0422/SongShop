package com.song.shop.dto;

import java.io.Serializable;

public class CodeDto implements Serializable
{
	private String cm_code_cd;
	private String gr_code_cd;
	private String gr_code_cd_nm;
	
	private String sub_code_cd;
	private String sub_code_cd_nm;
	private String cd_dc;
	private String cd_dc_en;
	
	private String cd_nm;
	private String cd_nm_en;
	private String use_at;
	private String cd_del_at;
	private String regist_trnsctor;
	private String regist_dt;
	private int disp_ordr;
	private String regist_trnsctor_nm;
	
	public CodeDto() { }

	public CodeDto(String cm_code_cd, String gr_code_cd, String gr_code_cd_nm, String sub_code_cd,
			String sub_code_cd_nm, String cd_dc, String cd_dc_en, String cd_nm, String cd_nm_en, String use_at,
			String cd_del_at, String regist_trnsctor, String regist_dt, int disp_ordr, String regist_trnsctor_nm) {
		this.cm_code_cd = cm_code_cd;
		this.gr_code_cd = gr_code_cd;
		this.gr_code_cd_nm = gr_code_cd_nm;
		this.sub_code_cd = sub_code_cd;
		this.sub_code_cd_nm = sub_code_cd_nm;
		this.cd_dc = cd_dc;
		this.cd_dc_en = cd_dc_en;
		this.cd_nm = cd_nm;
		this.cd_nm_en = cd_nm_en;
		this.use_at = use_at;
		this.cd_del_at = cd_del_at;
		this.regist_trnsctor = regist_trnsctor;
		this.regist_dt = regist_dt;
		this.disp_ordr = disp_ordr;
		this.regist_trnsctor_nm = regist_trnsctor_nm;
	}

	public String getCm_code_cd() {
		return cm_code_cd;
	}

	public void setCm_code_cd(String cm_code_cd) {
		this.cm_code_cd = cm_code_cd;
	}

	public String getGr_code_cd() {
		return gr_code_cd;
	}

	public void setGr_code_cd(String gr_code_cd) {
		this.gr_code_cd = gr_code_cd;
	}

	public String getGr_code_cd_nm() {
		return gr_code_cd_nm;
	}

	public void setGr_code_cd_nm(String gr_code_cd_nm) {
		this.gr_code_cd_nm = gr_code_cd_nm;
	}

	public String getSub_code_cd() {
		return sub_code_cd;
	}

	public void setSub_code_cd(String sub_code_cd) {
		this.sub_code_cd = sub_code_cd;
	}

	public String getSub_code_cd_nm() {
		return sub_code_cd_nm;
	}

	public void setSub_code_cd_nm(String sub_code_cd_nm) {
		this.sub_code_cd_nm = sub_code_cd_nm;
	}

	public String getCd_dc() {
		return cd_dc;
	}

	public void setCd_dc(String cd_dc) {
		this.cd_dc = cd_dc;
	}

	public String getCd_dc_en() {
		return cd_dc_en;
	}

	public void setCd_dc_en(String cd_dc_en) {
		this.cd_dc_en = cd_dc_en;
	}

	public String getCd_nm() {
		return cd_nm;
	}

	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
	}

	public String getCd_nm_en() {
		return cd_nm_en;
	}

	public void setCd_nm_en(String cd_nm_en) {
		this.cd_nm_en = cd_nm_en;
	}

	public String getUse_at() {
		return use_at;
	}

	public void setUse_at(String use_at) {
		this.use_at = use_at;
	}

	public String getCd_del_at() {
		return cd_del_at;
	}

	public void setCd_del_at(String cd_del_at) {
		this.cd_del_at = cd_del_at;
	}

	public String getRegist_trnsctor() {
		return regist_trnsctor;
	}

	public void setRegist_trnsctor(String regist_trnsctor) {
		this.regist_trnsctor = regist_trnsctor;
	}

	public String getRegist_dt() {
		return regist_dt;
	}

	public void setRegist_dt(String regist_dt) {
		this.regist_dt = regist_dt;
	}

	public int getDisp_ordr() {
		return disp_ordr;
	}

	public void setDisp_ordr(int disp_ordr) {
		this.disp_ordr = disp_ordr;
	}

	public String getRegist_trnsctor_nm() {
		return regist_trnsctor_nm;
	}

	public void setRegist_trnsctor_nm(String regist_trnsctor_nm) {
		this.regist_trnsctor_nm = regist_trnsctor_nm;
	}
}
