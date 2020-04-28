package com.song.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.song.shop.dto.CodeDto;
import com.song.shop.mapper.CodeMapper;
import com.song.shop.service.CodeService;

@Service("codeService")
@Transactional
public class CodeServiceImpl implements CodeService
{
	@Resource(name = "codeMapper")
	private CodeMapper codeMapper;
	
	@Override
	public List<CodeDto> getCodeList() 
	{	
		return codeMapper.getCodeList();
	}
}
