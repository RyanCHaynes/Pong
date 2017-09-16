package dev.GameDevPractice.Pong.EntityManager;

import java.util.List;

import dev.GameDevPractice.Pong.Game;
import dev.GameDevPractice.Pong.Component.Bounded;
import dev.GameDevPractice.Pong.Component.Collidable;
import dev.GameDevPractice.Pong.Component.Position;
import dev.GameDevPractice.Pong.Component.VectorDirection;

public class CollisionSystem implements SubSystem{
	
	private Game game;
	private List<Integer> CollidableEntities;
	private List<Integer> BoundedEntites;
	public CollisionSystem(Game g){
		game = g;
		CollidableEntities = 	game.getEntityM().getAllEntititiesWithComponentType(Collidable.class);
		BoundedEntites = game.getEntityM().getAllEntititiesWithComponentType(Bounded.class);
	}
	
	public void Tick() {
		for ( Integer e : CollidableEntities) {
			for(Integer f : BoundedEntites) {
				if(e == f) continue;
				 if(checkColision(game.getEntityM().getComponent(e, Bounded.class), game.getEntityM().getComponent(f, Bounded.class),
							game.getEntityM().getComponent(e, Position.class), game.getEntityM().getComponent(f, Position.class))) {
					game.getEntityM().getComponent(e, VectorDirection.class).setDirectionY(-game.getEntityM().getComponent(e, VectorDirection.class).getDirectionY());
					game.getEntityM().getComponent(e, VectorDirection.class).setDirectionX(-game.getEntityM().getComponent(e, VectorDirection.class).getDirectionX());
				}
			}
		}
					
	}
	private boolean checkColision(Bounded r1, Bounded r2, Position l1, Position l2) {
		if(l1.getX() > (r2.getW() + l2.getX()) || l2.getX() > (r1.getW()+l1.getX())) return false;
		if(l1.getY() > (r2.getH() + l2.getY()) || l2.getY() > (r1.getH()+l1.getY())) return false;
		System.out.println("t");
		return true;
	}
}
 