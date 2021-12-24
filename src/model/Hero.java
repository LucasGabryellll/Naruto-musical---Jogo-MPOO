package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import controller.ControllerPaint;

public class Hero extends Sprite{
	
	private MusicNote[] musicNote;
	
	public Hero(int appearance, int width, int heigth, int columns, int lines, int x, int y, String address, MusicNote[] musicNote) {
		super(appearance, width, heigth, columns, lines, x, y, address);
		
		this.musicNote = musicNote;
	}

	@Override
	public void animate(String direction) {
		setAppearance(getAppearance() + 1);
		
		if (direction.equalsIgnoreCase("up")) {
			if(getAppearance() < 9 || getAppearance() > 11)
				setAppearance(9);
			
		} else if (direction.equalsIgnoreCase("down")) {
			if(getAppearance() < 0 || getAppearance() > 2)
				setAppearance(0);
			
		} else if (direction.equalsIgnoreCase("left")) {
			if(getAppearance() < 3 || getAppearance() > 5)
				setAppearance(3);
			
		} else if (direction.equalsIgnoreCase("right")) {
			if(getAppearance() < 6 || getAppearance() > 8) 
				setAppearance(6);
		}
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getSprites()[getAppearance()], getX(), getY(), null);
		
	}

	@Override
	public void move(String direction) {
		switch (direction) {
		case "up":
			setY(getY() - 5);
			break;

		case "down":
			setY(getY() + 5);
			break;
			
		case "left":
			setX(getX() - 5);
			break;
			
		case "right":
			setX(getX() + 5);
			break;
		}
		
		if(!direction.equals("")) {
			animate(direction);
			
		}
	}
	
	public boolean collisionMusicNote() {
		Rectangle personagem = new Rectangle(getX()+10, getY()+10, 
				getCharacterWidth()-10, getCharacterHeigth()-10);
		List<Rectangle> tmp = new ArrayList<Rectangle>();
		for (MusicNote note : musicNote) {
			tmp.add(new Rectangle(note.getPositionX(), note.getPositionY(), note.getWidth(), note.getHeigth()));
		}
		for(Rectangle rectangle : tmp) {
			if(rectangle.intersects(personagem)){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean collision(List<Rectangle> tmp, int x,int y) {

		Rectangle personagem = new Rectangle(getX()+x+5, getY()+y+2, 
				getCharacterWidth()-10, getCharacterHeigth()-5);
		for(Rectangle rectangle : tmp) {
			if(rectangle.intersects(personagem)){
				
				return true;
			}
		}
		return false;
	}
	
	//metodos para tratar colis�o Y
	@Override
	public void setX(int x) {
		if(!collision(ControllerPaint.collisionMap, x-getX(), 0))
			super.setX(x);

	}
	
	//metodos para tratar colis�o X	
	@Override
	public void setY(int y) {
		if(!collision(ControllerPaint.collisionMap, 0, y-getY()))
			super.setY(y);
		
	}

}
