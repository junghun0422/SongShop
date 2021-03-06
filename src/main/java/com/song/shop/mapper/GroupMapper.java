package com.song.shop.mapper;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.song.shop.dto.GroupDto;
import com.song.shop.entity.GroupEntity;

@Repository("groupMapper")
public interface GroupMapper 
{
	List<GroupDto> getGroupParkList(String deptTy);
}
