package com.song.shop.dto;

import java.io.Serializable;

public class GroupDto implements Serializable 
{
	private String group_seq;
	private String group_nm;
	private String p_group_seq;
	private int disp_ordr;
	
	private String group_type;
	
	private String group_seq_ori;

	public GroupDto() { }

	public GroupDto(String group_seq, String group_nm, String p_group_seq, int disp_ordr, String group_type, String group_seq_ori) 
	{
		this.group_seq = group_seq;
		this.group_nm = group_nm;
		this.p_group_seq = p_group_seq;
		this.disp_ordr = disp_ordr;
		this.group_type = group_type;
		this.group_seq_ori = group_seq_ori;
	}

	public String getGroup_seq() {
		return group_seq;
	}

	public void setGroup_seq(String group_seq) {
		this.group_seq = group_seq;
	}

	public String getGroup_nm() {
		return group_nm;
	}

	public void setGroup_nm(String group_nm) {
		this.group_nm = group_nm;
	}

	public String getP_group_seq() {
		return p_group_seq;
	}

	public void setP_group_seq(String p_group_seq) {
		this.p_group_seq = p_group_seq;
	}

	public int getDisp_ordr() {
		return disp_ordr;
	}

	public void setDisp_ordr(int disp_ordr) {
		this.disp_ordr = disp_ordr;
	}

	public String getGroup_type() {
		return group_type;
	}

	public void setGroup_type(String group_type) {
		this.group_type = group_type;
	}

	public String getGroup_seq_ori() {
		return group_seq_ori;
	}

	public void setGroup_seq_ori(String group_seq_ori) {
		this.group_seq_ori = group_seq_ori;
	}

	@Override
	public String toString() {
		return "GroupDto [group_seq=" + group_seq + ", group_nm=" + group_nm + ", p_group_seq=" + p_group_seq
				+ ", disp_ordr=" + disp_ordr + ", group_type=" + group_type + ", group_seq_ori=" + group_seq_ori + "]";
	}
}
