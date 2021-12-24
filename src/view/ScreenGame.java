package view;

import javax.swing.JFrame;

public class ScreenGame extends JFrame {

	public static final int WIDTH = 640;
	public static final int HEIGHT = 640;
	
	private MapeGame mapeGame;
	
	public ScreenGame() {
		setTitle("Mapa");
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setResizable(false);
		setLocale(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		mapeGame = new MapeGame();
		add(mapeGame);
		
		setVisible(true);
	}
	
	public MapeGame getMapeGame() {
		return mapeGame;
	}
}
