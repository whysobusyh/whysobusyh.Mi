package com.peisia.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.peisia.mapper.Login_Mapper;
import com.peisia.spring.dto.Board_Dto;
import com.peisia.spring.dto.Login_Dto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class Board_Service_Impl implements Board_Service {
	
	private Login_Mapper mapper;
	
	@Override
	public boolean login(String submit_ID, String submit_PW, HttpSession session) {
		Login_Dto login_Data =  mapper.login_Test(submit_ID, submit_PW);
		if(login_Data.getLogin_Test()==1) {
			log.info(String.format("ID 입력 = %s, PW 입력 = %s",submit_ID, submit_PW));
			log.info("서비스 impl 로그인 성공");
			session.setAttribute("nickname", login_Data.getC_Nickname());
			log.info("서비스 impl 닉네임은 " + session.getAttribute("nickname"));
			return true;
		}else {
			log.info(String.format("ID 입력 = %s, PW 입력 = %s",submit_ID, submit_PW));
			log.info("로그인 실패");
			return false;
		}
		
	}

	@Override
	public ArrayList<Board_Dto> lists() {
		
		return null;
	}

}
