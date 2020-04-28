package com.song.shop.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.song.shop.dto.GroupDto;
import com.song.shop.entity.GroupEntity;
import com.song.shop.mapper.GroupMapper;
import com.song.shop.repository.GroupRepository;
import com.song.shop.service.GroupService;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService
{
	@Resource(name = "groupRepository")
	private GroupRepository groupRepository;
	
	@Resource(name = "groupMapper")
	private GroupMapper groupMapper;
	
	@Override
	public List<GroupEntity> getGroupList() 
	{
		Iterator<GroupEntity> it = groupRepository.findAll(Sort.by(Sort.Direction.ASC, "groupNm")).iterator();
		
		List<GroupEntity> result = new ArrayList<>();
		while(it.hasNext()) 
		{
			result.add(it.next());
		}
		
		return result;
	}

	@Override
	public List<GroupDto> getGroupParkList(String deptTy) 
	{	
		return groupMapper.getGroupParkList(deptTy);
	}
}
