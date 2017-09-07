package dev.GameDevPractice.Pong.State;

import java.awt.Graphics;

import dev.GameDevPractice.Pong.Game;
import dev.GameDevPractice.Pong.Component.Position;
import dev.GameDevPractice.Pong.Component.Sprite;
import dev.GameDevPractice.Pong.GFX.Assets;

public class GameState extends State{
	private int pongBall;
	private int pongPaddle;
	public GameState(Game game) {
		super(game);
		init();
	}
	
	
	private void init(){
		pongBall = game.getEntityM().createEntity();
		pongPaddle = game.getEntityM().createEntity();
		//initing components for ball entity
		game.getEntityM().addComponent(pongBall, new Position());
		game.getEntityM().addComponent(pongBall, new Sprite());
		game.getEntityM().getComponent(pongBall,  Position.class).setX(100);
		game.getEntityM().getComponent(pongBall,  Position.class).setY(100);
		game.getEntityM().getComponent(pongBall,  Sprite.class).setAnimationName("PongBallXD");
		//initing components for paddle
		game.getEntityM().addComponent(pongPaddle, new Position());
		game.getEntityM().addComponent(pongPaddle, new Sprite());
		game.getEntityM().getComponent(pongPaddle,  Position.class).setX(80);
		game.getEntityM().getComponent(pongPaddle,  Position.class).setY(300);
		game.getEntityM().getComponent(pongPaddle,  Sprite.class).setAnimationName("PongPaddleB");
		
	}
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.AnimationMap.get(game.getEntityM().getComponent(pongBall, Sprite.class).getAnimationName()).get(0), 
		game.getEntityM().getComponent(pongBall, Position.class).getX(), game.getEntityM().getComponent(pongBall, Position.class).getY(), null);
		
		g.drawImage(Assets.AnimationMap.get(game.getEntityM().getComponent(pongPaddle, Sprite.class).getAnimationName()).get(0), 
		game.getEntityM().getComponent(pongPaddle, Position.class).getX(), game.getEntityM().getComponent(pongPaddle, Position.class).getY(), null);
	}

}
