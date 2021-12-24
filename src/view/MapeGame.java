package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MapeGame extends JPanel {

	private BufferedImage backgroundMap;
	private Graphics graphicsMape;
	
	public MapeGame() {
		setSize(640, 640);
		setLocation(0, 0);
		
		backgroundMap = new BufferedImage(ScreenGame.WIDTH, ScreenGame.HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
		
		graphicsMape = backgroundMap.getGraphics();
		
		setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundMap, 0, 0, null);
	}
	
	public Graphics getGraphicsMapeGame() {
		return graphicsMape;
		
	}
	
	public BufferedImage getBackgroundMap() {
		return backgroundMap;
	}
}
