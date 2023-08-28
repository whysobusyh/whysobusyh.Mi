package com.peisia.dynamic_beat_1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(DynamicBeat.game == null) {
			// 게임이 진행되지 않고 있다면
			return;
			// 밑의 작업을 하지 않고 그냥 바로 return으로 강제종료시켜서 무력화 하겠다.
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			DynamicBeat.game.pressS();
			
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.pressD();
			
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.pressF();
			
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			DynamicBeat.game.pressSpace();
			
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.pressJ();
			
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			DynamicBeat.game.pressK();
			
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.pressL();
			
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(DynamicBeat.game == null) {
			// 게임이 진행되지 않고 있다면
			return;
			// 밑의 작업을 하지 않고 그냥 바로 return으로 강제종료시켜서 무력화 하겠다.
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			DynamicBeat.game.releaseS();
			
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.releaseD();
			
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.releaseF();
			
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			DynamicBeat.game.releaseSpace();
			
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.releaseJ();
			
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			DynamicBeat.game.releaseK();
			
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.releaseL();
			
		}
		
	}
}
