package dev.GameDevPractice.Pong.State;

import java.awt.Graphics;

import dev.GameDevPractice.Pong.Game;
import dev.GameDevPractice.Pong.Component.Bounded;
import dev.GameDevPractice.Pong.Component.Collidable;
import dev.GameDevPractice.Pong.Component.PlayerMovable;
import dev.GameDevPractice.Pong.Component.Position;
import dev.GameDevPractice.Pong.Component.Sprite;
import dev.GameDevPractice.Pong.Component.VectorDirection;
import dev.GameDevPractice.Pong.EntityManager.CollisionSystem;
import dev.GameDevPractice.Pong.EntityManager.PlayerInput;
import dev.GameDevPractice.Pong.EntityManager.VectorDirectionSystem;
import dev.GameDevPractice.Pong.GFX.Assets;

public class GameState extends State{
	private int pongBall;
	private int pongPaddle;
	private int TopWall, LeftWall, RightWall;
	private VectorDirectionSystem v;
	private CollisionSystem c;
	private PlayerInput p;
	public GameState(Game game) {
		super(game);
		init();
		v = new VectorDirectionSystem(game);
		c = new CollisionSystem(game);
		p = new PlayerInput(game);
	}
	
	
	private void init(){
		pongBall = game.getEntityM().createEntity();
		pongPaddle = game.getEntityM().createEntity();
		TopWall = game.getEntityM().createEntity();
		LeftWall = game.getEntityM().createEntity();
		RightWall = game.getEntityM().createEntity();
		//initing components for ball entity
		game.getEntityM().addComponent(pongBall, new Position());
		game.getEntityM().addComponent(pongBall, new Sprite());
		game.getEntityM().addComponent(pongBall, new VectorDirection());
		game.getEntityM().addComponent(pongBall, new Bounded());
		game.getEntityM().addComponent(pongBall, new Collidable());
		game.getEntityM().getComponent(pongBall,  Position.class).setX(100);
		game.getEntityM().getComponent(pongBall,  Position.class).setY(100);
		game.getEntityM().getComponent(pongBall,  Bounded.class).setW(32);
		game.getEntityM().getComponent(pongBall,  Bounded.class).setH(32);
		game.getEntityM().getComponent(pongBall,  Sprite.class).setAnimationName("PongBallXD");
		game.getEntityM().getComponent(pongBall, VectorDirection.class).setDirectionX(0);
		game.getEntityM().getComponent(pongBall, VectorDirection.class).setDirectionY(1);
		//initing components for paddle
		game.getEntityM().addComponent(pongPaddle, new Position());
		game.getEntityM().addComponent(pongPaddle, new Sprite());
		game.getEntityM().addComponent(pongPaddle, new Bounded());
		game.getEntityM().addComponent(pongPaddle, new PlayerMovable());
		game.getEntityM().addComponent(pongPaddle, new VectorDirection());
		game.getEntityM().getComponent(pongPaddle,  Position.class).setX(80);
		game.getEntityM().getComponent(pongPaddle,  Position.class).setY(300);
		game.getEntityM().getComponent(pongPaddle,  Bounded.class).setW(32);
		game.getEntityM().getComponent(pongPaddle,  Bounded.class).setH(32);
		game.getEntityM().getComponent(pongPaddle,  Sprite.class).setAnimationName("PongPaddleB");
		game.getEntityM().addComponent(TopWall, new Bounded());
		game.getEntityM().addComponent(TopWall, new Position());
		game.getEntityM().getComponent(TopWall,  Position.class).setX(0);
		game.getEntityM().getComponent(TopWall,  Position.class).setY(0);
		game.getEntityM().getComponent(TopWall,  Bounded.class).setW(200);
		game.getEntityM().getComponent(TopWall,  Bounded.class).setH(1);
		game.getEntityM().addComponent(RightWall, new Bounded());
		game.getEntityM().addComponent(RightWall, new Position());
		game.getEntityM().getComponent(RightWall,  Position.class).setX(0);
		game.getEntityM().getComponent(RightWall,  Position.class).setY(0);
		game.getEntityM().getComponent(RightWall,  Bounded.class).setW(1);
		game.getEntityM().getComponent(RightWall,  Bounded.class).setH(400);
		game.getEntityM().addComponent(LeftWall, new Bounded());
		game.getEntityM().addComponent(LeftWall, new Position());
		game.getEntityM().getComponent(LeftWall,  Position.class).setX(200);
		game.getEntityM().getComponent(LeftWall,  Position.class).setY(0);
		game.getEntityM().getComponent(LeftWall,  Bounded.class).setW(1);
		game.getEntityM().getComponent(LeftWall,  Bounded.class).setH(400);
		
	}
	@Override
	public void tick() {
		v.Tick();
		c.Tick();
		p.Tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.AnimationMap.get(game.getEntityM().getComponent(pongBall, Sprite.class).getAnimationName()).get(0), 
		game.getEntityM().getComponent(pongBall, Position.class).getX(), game.getEntityM().getComponent(pongBall, Position.class).getY(), null);
		
		g.drawImage(Assets.AnimationMap.get(game.getEntityM().getComponent(pongPaddle, Sprite.class).getAnimationName()).get(0), 
		game.getEntityM().getComponent(pongPaddle, Position.class).getX(), game.getEntityM().getComponent(pongPaddle, Position.class).getY(), null);
	}

}
