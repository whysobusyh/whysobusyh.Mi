package com.peisia.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.peisia.spring.dto.Login_Dto;

@Mapper
public interface Login_Mapper {
	public Login_Dto login_Test(@Param("submit_ID") String submit_ID, @Param("submit_PW") String submit_PW);
	public Login_Dto find_Nickname();
}
