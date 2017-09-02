package dev.GameDevPractice.Pong;

public class Launcher {
	
		public static void main(String[] args){
			Game g = new Game("Pong", 200, 400);
			g.start();
		}
}
