package model;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;

public class MusicNote {
	
	private ImageIcon image;
	private int positionX, positionY;
	private int width, heigth;
	private Rectangle rectangleNote;
	
	public MusicNote(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		
		try {
			image = new ImageIcon(getClass().getClassLoader().getResource("notaMusical.png"));
			
		} catch (Exception e) {
			System.out.println("Nota musical não encontrada!");
			System.exit(0);
		}
	
		this.width = image.getIconWidth();
		this.heigth = image.getIconHeight();
//		this.rectangleNote = new Rectangle(positionX, positionY, width, heigth);
	}
	
	public boolean colisao(List<Rectangle> tmp, int x,int y) {

		Rectangle note = new Rectangle(getPositionX()+x, getPositionY()+y, 
				getWidth(), getHeigth());
		for(Rectangle rectangle : tmp) {
			if(rectangle.intersects(note)){
				return true;
			}
		}
		return false;
	}
	

	public ImageIcon getImage() {
		return image;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeigth() {
		return heigth;
	}

	public Rectangle getRectangleNote() {
		return rectangleNote;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(positionX+5, positionY+2, width-6, heigth-5);
	}
}
