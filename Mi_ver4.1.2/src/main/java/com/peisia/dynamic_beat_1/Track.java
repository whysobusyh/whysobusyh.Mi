package com.peisia.dynamic_beat_1;

import lombok.Data;

@Data
public class Track {
	
	private String titleImage; // 제목 부분 이미지
	private String startImage; //게임 선택 창 표지 이미지
	private String gameImage; // 해당 곡을 실행했을 때 표지 이미지
	private String startMusic; // 게임선택 창 음악
	private String gameMusic; // 해당 곡을 실행했을 때 음악
	private String titleName; // 곡 제목
	
	// getter setter함수는 @Data 선언으로 대체
	// springBoot가 아닌 일반 프로젝트라면 getter setter함수를 넣어주어야함
	
	
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic,
			String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}
	
	
	
	
}	
