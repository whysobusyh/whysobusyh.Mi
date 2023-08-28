package com.peisia.spring.dto;

import lombok.Data;

@Data
public class Board_Dto {
	private int no;
	private String title;
	private String nickname;
	private String text;
	private int count;
	private String reply;
}
