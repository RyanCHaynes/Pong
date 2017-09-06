package dev.GameDevPractice.Pong.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	public static boolean left =false, right = false;


	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(KeyEvent.VK_A == e.getKeyCode()){
			left = true;
			System.out.println("keyPR A");
		} else if(KeyEvent.VK_D == e.getKeyCode()){
			right = true;
			System.out.println("keyPR D");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(KeyEvent.VK_A == e.getKeyCode()){
			left = false;
			System.out.println("keyReleased A");
		} else if(KeyEvent.VK_D == e.getKeyCode()){
			right = false;
			System.out.println("keyReleased D");
		}
	}
	
	public boolean keyPressed(){
		return this.keyPressed();
	}
}
