package dev.GameDevPractice.Pong.Component;

public class VectorDirection implements Component{
	private int MDirectionX, MDirectionY;
	
	public int getDirectionX() {
		return MDirectionX;
	}
	public void setDirectionX(int directionX) {
		MDirectionX = directionX;
	}
	public int getDirectionY() {
		return MDirectionY;
	}
	public void setDirectionY(int directionY) {
		MDirectionY = directionY;
	}
	
}
