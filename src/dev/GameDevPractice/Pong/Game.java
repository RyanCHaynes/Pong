package dev.GameDevPractice.Pong;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.GameDevPractice.Pong.Display.Display;
import dev.GameDevPractice.Pong.EntityManager.EntityManager;
import dev.GameDevPractice.Pong.GFX.Assets;
import dev.GameDevPractice.Pong.Input.KeyManager;
import dev.GameDevPractice.Pong.State.GameState;
import dev.GameDevPractice.Pong.State.State;

public class Game implements Runnable{
		private Display display;
		private Thread thread;
		private boolean running = false;
		private BufferStrategy bs;
		private Graphics g;
		private String title;
		private int width, height;
		private State GameState;
		private KeyManager keyManager;
		private EntityManager entityManager;
		private long DeltaTime;
		
		Game(String t, int w, int h){
			title = t;
			width = w;
			height = h;
		}
		private void tick(){
			
			if(State.getState() != null)
				State.getState().tick();
		}
		private void render(){
			bs = display.getCanvas().getBufferStrategy();
			if (bs  == null){
				display.getCanvas().createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics();
			
			g.clearRect(0, 0, width, height);
			
			if(State.getState() != null)
				State.getState().render(g);

			bs.show();
			g.dispose();
		}
		
		private void init(){
			entityManager = new EntityManager();
			Assets.init();
			display = new Display(title, width, height);
			GameState = new GameState(this);
			display.getFrame().addKeyListener(keyManager = new KeyManager());
			State.setState(GameState);
		}
		
		public synchronized void start(){
			if (running) return;
			running = true;
			thread = new Thread(this);
			thread.start();
		}
		
		private void stop(){
			if(!running) return;
			running = false;
			try {
				thread.join();
			} catch(InterruptedException e) {
				
			}
		}
		public void run() {
			init();
			int fps = 60;
			double timePerTick = 1000000000/fps;
			double deltaTime = 0;
			long currentTime;
			long lastTime = System.nanoTime();
			long timer = 0;
			int ticks =0;
			
			while(running){
				currentTime = System.nanoTime();
				deltaTime += (currentTime - lastTime)/timePerTick;
				timer += currentTime - lastTime;
				lastTime = currentTime;
				
				if(deltaTime >= 1){
					tick();
					render();
					ticks++;
					deltaTime--;
				}
			}
			
			
			stop();
		}
		public EntityManager getEntityM(){
			return this.entityManager;
		}
		public KeyManager getKeyM(){
			return this.keyManager;
		}
		public Graphics getGraphics(){
			return this.g;
		}
}
