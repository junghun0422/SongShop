package com.song.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "cm_group")
public class GroupEntity 
{
	@Id
	@Column(name = "group_seq")
	private long groupSeq;
	
	@Column(name = "group_nm")
	private String groupNm;
	
	@Column(name = "p_group_seq")
	private long pGroupSeq;
	
	@Column(name = "disp_ordr")
	private int dispOrdr;
	
	
	/*
	 * @Column(name = "group_type") private String groupType;
	 * 
	 * @Column(name = "group_seq_ori") private long groupSeqOri;
	 */
	
	public GroupEntity() { }

	@Builder
	public GroupEntity(long groupSeq, String groupNm, long pGroupSeq, int dispOrdr) {
		super();
		this.groupSeq = groupSeq;
		this.groupNm = groupNm;
		this.pGroupSeq = pGroupSeq;
		this.dispOrdr = dispOrdr;
	}	

	@Override
	public String toString() {
		return "GroupEntity [groupSeq=" + groupSeq + ", groupNm=" + groupNm + ", pGroupSeq=" + pGroupSeq + ", dispOrdr="
				+ dispOrdr + "]";
	}
}
