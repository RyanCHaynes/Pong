package dev.GameDevPractice.Pong.EntityManager;

import java.util.List;

import dev.GameDevPractice.Pong.Game;
import dev.GameDevPractice.Pong.Component.Position;
import dev.GameDevPractice.Pong.Component.VectorDirection;



public class VectorDirectionSystem implements SubSystem{
	private Game game;
	private List<Integer> entities;
	public VectorDirectionSystem(Game g){
		game = g;
		entities = 	game.getEntityM().getAllEntititiesWithComponentType(VectorDirection.class);
	}
	
	public void Tick() {
		for ( Integer e : entities) {
				game.getEntityM().getComponent(e, Position.class).setX
				(game.getEntityM().getComponent(e, Position.class).getX() + game.getEntityM().getComponent(e, VectorDirection.class).getDirectionX());
				game.getEntityM().getComponent(e, Position.class).setY
				(game.getEntityM().getComponent(e, Position.class).getY() + game.getEntityM().getComponent(e, VectorDirection.class).getDirectionY());
		}
	}
	
}
