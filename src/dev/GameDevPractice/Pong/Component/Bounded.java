package dev.GameDevPractice.Pong.Component;

public class Bounded implements Component{

	private int width, height;
	public int getW() {
		return width;
	}
	public int getH() {
		return height;
	}
	public void setW(int w) {
		width = w;
	}
	public void setH(int h) {
		height = h;
	}
}
