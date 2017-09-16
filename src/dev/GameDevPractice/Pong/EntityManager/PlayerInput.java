package dev.GameDevPractice.Pong.EntityManager;

import java.util.List;

import dev.GameDevPractice.Pong.Game;
import dev.GameDevPractice.Pong.Component.PlayerMovable;
import dev.GameDevPractice.Pong.Component.VectorDirection;

public class PlayerInput implements SubSystem {
	private Game game;
	private List<Integer> PlayerMovableEntities;
	
	public PlayerInput(Game G){
		game = G;
		PlayerMovableEntities = game.getEntityM().getAllEntititiesWithComponentType(PlayerMovable.class);
	}
	public void Tick() {
		for (Integer e : PlayerMovableEntities) {
			if(game.getKeyM().left) {
				game.getEntityM().getComponent(e, VectorDirection.class).setDirectionX(-1);;
			}
			if(game.getKeyM().right) {
				game.getEntityM().getComponent(e, VectorDirection.class).setDirectionX(1);;
			}
		}
		
	}

}
