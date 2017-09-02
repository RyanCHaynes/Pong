package dev.GameDevPractice.Pong.State;

import java.awt.Graphics;

import dev.GameDevPractice.Pong.Game;

public abstract class State {
	//simple game state manager
	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	//CLASS
	protected Game game;
	
	public State(Game game){
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
