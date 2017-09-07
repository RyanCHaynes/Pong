package dev.GameDevPractice.Pong.Component;

import java.awt.image.BufferedImage;

public class Sprite implements Component{
	private String animation;
	
	public String getAnimationName(){
		return animation;
	}
	public void setAnimationName(String s){
		animation = s;
	}
}
