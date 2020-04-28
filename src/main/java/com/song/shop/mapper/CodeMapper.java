package com.song.shop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.song.shop.dto.CodeDto;

@Repository("codeMapper")
public interface CodeMapper 
{
	List<CodeDto> getCodeList();
}	
