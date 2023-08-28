package com.peisia.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.peisia.spring.dto.Board_Dto;


public interface Board_Service {
	public boolean login(String submit_ID, String submit_PW, HttpSession session);
	public ArrayList<Board_Dto> lists();
}
