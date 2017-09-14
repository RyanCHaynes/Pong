package dev.GameDevPractice.Pong.EntityManager;

import java.util.ArrayList;
import java.util.List;

import dev.GameDevPractice.Pong.Game;
import dev.GameDevPractice.Pong.Component.Position;
import dev.GameDevPractice.Pong.Component.VectorDirection;

public class PositionSystem implements SubSystem{
	private static Game game;
	
	PositionSystem(Game g){
		game = g;
	}
	
	@Override
	public void Tick() {
		for ( Position x : game.getEntityM().getAllComponentsOfType(Position.class)){
			
		}
		
	}
	
}
