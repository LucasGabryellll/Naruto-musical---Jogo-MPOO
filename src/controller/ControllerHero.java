package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Hero;
import view.MapeGame;
import view.ScreenGame;

public class ControllerHero extends Thread implements KeyListener {
	
	private Hero hero;
	private MapeGame mapeGame;
	private String direction = "";
	
	public ControllerHero(MapeGame mapeGame, Hero hero) {
		this.hero = hero;
		this.mapeGame = mapeGame;
		
		mapeGame.addKeyListener(this);
		
		start();
		
	}
	
	public void run() {
		while (true) {
			try {
				hero.move(direction);
				Thread.sleep(40);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		switch (code) {
		case KeyEvent.VK_UP:
			direction = "up";
			break;
		case KeyEvent.VK_DOWN:
			direction = "down";
			break;
		case KeyEvent.VK_LEFT:
			direction = "left";
			break;
		case KeyEvent.VK_RIGHT:
			direction = "right";
			break;

		default:
			break;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		switch (code) {
		case KeyEvent.VK_UP:
			direction = "";
			break;
		case KeyEvent.VK_DOWN:
			direction = "";
			break;
		case KeyEvent.VK_LEFT:
			direction = "";
			break;
		case KeyEvent.VK_RIGHT:
			direction = "";
			break;

		default:
			break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
}
