package app;

import controller.ControllerHero;
import controller.ControllerPaint;
import model.Layer;
import model.Logic;
import model.MusicNote;
import model.MusicNotes;
import model.Hero;
import view.MapeGame;
import view.ScreenGame;

public class App {
	public static void main(String[] args) {
		ScreenGame screenGame = new ScreenGame();
		
		Layer floor = new Layer(20, 20, 32, 32, "res/tileFloresta.png", "chao.txt");
		Layer collision = new Layer(20, 20, 32, 32, "res/tileFloresta.png", "colisao.txt");
		Layer top = new Layer(20, 20, 32, 32, "res/tileFloresta.png", "topo.txt");
		
//		MusicNote note = new MusicNote(100, 250);
		Hero hero = new Hero(0, 126, 228, 3, 4, 50, 540, "heroi.png", MusicNotes.getMusicNote());

		Logic logic = new Logic(hero, MusicNotes.getMusicNote());
		
		ControllerPaint controllerPaint = new ControllerPaint(screenGame.getMapeGame(), hero, floor, collision, top, logic);
		ControllerHero controllerHero = new ControllerHero(screenGame.getMapeGame(), hero);
		
		screenGame.addKeyListener(controllerHero);
		
		//Jogo não finalizado
	}
}
