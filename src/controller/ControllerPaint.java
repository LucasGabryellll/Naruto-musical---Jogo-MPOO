package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;

import model.Layer;
import model.Logic;
import model.MusicNote;
import model.MusicNotes;
import model.Hero;
import view.MapeGame;

public class ControllerPaint implements Runnable{

	private MapeGame mapeGame;
	private Hero hero;
	private Layer floor, collision, top;
	private Graphics g;
	public static List<Rectangle> collisionMap, collisionNote;
	private Logic logic;
	
	private Thread thread;	
	private static MusicNote[] musicNote;
	
	public ControllerPaint(MapeGame mapeGame, Hero hero, Layer floor, Layer collision, Layer top, Logic logic) {
		super();
		this.mapeGame = mapeGame;
		
		this.hero = hero;
		
		this.floor = floor;
		this.collision = collision;
		this.top = top;
		
		this.logic = logic;
		
		musicNote = MusicNotes.startNotes();
		
		collisionMap = collision.montarColisao();
	
		this.g =  mapeGame.getGraphicsMapeGame();
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void update() {
		floor.assembleMap();
		collision.assembleMap();
		top.assembleMap();
	}
	
	public void paint() {
		g.drawImage(floor.layer, 0, 0 , null);
		g.drawImage(collision.layer, 0, 0 , null);
		
		g.drawImage(hero.getSprites()[hero.getAppearance()], hero.getX(), hero.getY(), null);
		g.drawImage(top.layer, 0, 0 , null);
		
		for (int i = 0; i < musicNote.length; i++) {
			g.drawImage(musicNote[i].getImage().getImage(), musicNote[i].getPositionX(), musicNote[i].getPositionY(), null);
		}
	
		Graphics2D g2d = (Graphics2D) mapeGame.getGraphics();
//		g2d.drawImage(mapeGame, 0, 0, null);
		g2d.drawImage(mapeGame.getBackgroundMap(), 0, 0, null);
		
		((Graphics2D) g).draw(hero.getBounds());
		((Graphics2D) g).draw(musicNote[1].getBounds());
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
	
	}
	
	@Override
	public void run() {
			while(true) {
				mapeGame.repaint();
				update();
				paint();
				logic.startPhaseGame();
			}
	}

	public MusicNote[] getMusicNote() {
		return musicNote;
	}

	public Graphics getG() {
		return g;
	}		
	
}
