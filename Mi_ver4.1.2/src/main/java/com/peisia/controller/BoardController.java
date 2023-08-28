package com.peisia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.dynamic_beat_1.DynamicBeat;
import com.peisia.service.Board_Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.awt.Graphics;

@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
@Controller
public class BoardController {
	
	private Board_Service service;
	
	
	@GetMapping("/login")
	public String login(@RequestParam("submit_ID") String submit_ID , @RequestParam("submit_PW") String submit_PW, HttpServletRequest request ) {
		HttpSession session = request.getSession();
		if(service.login(submit_ID, submit_PW,session)) {
			log.info(session.getAttribute("nickname"));
			log.info("컨트롤 로그 로그인 성공 name은 " + session.getAttribute("nickname"));
			 return "redirect:/board/home";
		}else {
			log.info("컨트롤 로그 로그인 실패");
			 return "redirect:/board/home";
		}
	}
	
	@GetMapping("/home")
	public String home() {
	
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("nickname");
		
		return "redirect:/board/home";
	}
	
	@GetMapping("/free_Board")
	public String lists(HttpServletRequest request){
		HttpSession session= request.getSession();
		session.setAttribute("articles", service.lists());
		return "redirect:/board/home";
	}
	
	@GetMapping("/music_Board")
	public void music() {
		new DynamicBeat();
	}
}
