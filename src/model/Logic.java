package model;

import javax.swing.JOptionPane;

import controller.ControllerPaint;

public class Logic {
	private Hero hero;
	private MusicNote[] note;
	
	ControllerPaint controllerPaint;
	
	public Logic(Hero hero, MusicNote[] note) {
		this.hero = hero;
		this.note = note;
		
//		this.controllerPaint = controllerPaint;
		
		
	}

	public void startPhaseGame() {
		for (int i = 0; i < note.length; i++) {
			if (hero.collisionMusicNote()) {
				JOptionPane.showMessageDialog(null, "Parabens Você pegou uma nota");
				System.out.println(note[i]);
//				note[i] = null;
				System.gc();				
				break;
			}
			
		}

	}
	
	public Hero getHero() {
		return hero;
	}

	public MusicNote[] getNote() {
		return note;
	}
}

