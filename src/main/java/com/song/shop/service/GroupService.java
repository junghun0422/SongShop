package com.song.shop.service;

import java.util.List;

import com.song.shop.dto.GroupDto;
import com.song.shop.entity.GroupEntity;

public interface GroupService 
{
	public List<GroupEntity> getGroupList();
	
	public List<GroupDto> getGroupParkList(String deptTy);
}
